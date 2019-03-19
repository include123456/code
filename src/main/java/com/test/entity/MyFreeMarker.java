package com.test.entity;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.lang.reflect.Field;
import java.util.*;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import com.test.annotation.Table;
import com.test.annotation.TableFiled;
import com.test.model.Model;
import com.test.util.Consts;
import com.test.util.StringUtils;

import freemarker.template.Configuration;
import freemarker.template.Template;

/**
 * freemarker处理
 * 
 * @author: shuyi
 * @date 2019/1/23 14:28
 */
@Component
public class MyFreeMarker implements BaseFreeMarker {

    @Value("${outpath}")
    private String outPath;
    @Value("${author}")
    private String author;

    private Hbm hbm;

    public void setHbm(Class clazz) throws Exception {
        this.hbm = getHbm(clazz);
    }

    /**
     * 输出模板生成的文件
     * 
     * @param model
     * @param map
     * @param fileName
     * @throws Exception
     */
    public void createFile(String model, Map map, String fileName) throws Exception {
        String filePath = this.outPath + "\\" + this.hbm.getTableName();
        File outDir = new File(filePath);
        if (!outDir.exists()) {
            outDir.mkdirs();
        }
        Configuration configuration = new Configuration();
        String path = Thread.currentThread().getClass().getResource("/").getPath();
        String dir = (path + "model/").substring(1);
        File file = new File(dir);
        configuration.setDirectoryForTemplateLoading(file);
        Template template = configuration.getTemplate(model + ".ftl", "UTF-8");
        Writer out = new FileWriter(new File(filePath + "\\" + fileName));
        template.process(map, out);
    }

    /**
     * 获取hbm文件属性
     * 
     * @return
     * @throws Exception
     */
    public Hbm getHbm(Class clazz) throws Exception {
        Hbm hbm = new Hbm();
        Table table = (Table)clazz.getAnnotation(Table.class);
        // 获取table上的值
        hbm.setTableName(table.name());
        hbm.setClazzName(table.clazzName());
        hbm.setTableComment(table.comment());
        // 获取属性值
        Field[] fields = Model.class.getDeclaredFields();
        Prop prop;
        List<Prop> list = new ArrayList<Prop>();
        for (Field field : fields) {
            TableFiled fieldAnnotation = field.getAnnotation(TableFiled.class);
            if (ObjectUtils.isEmpty(fieldAnnotation)) {
                continue;
            }
            prop = new Prop();
            // field名字
            String name = field.getName();
            // 表中对应的name
            prop.setName(StringUtils.getTableField(name).toUpperCase());
            // field name
            prop.setFieldName(name.trim());
            // 注释
            prop.setComment(fieldAnnotation.comment().trim());
            // 长度
            prop.setLength(fieldAnnotation.length().trim());
            // field类型
            prop.setType(field.getType().getName().trim());
            list.add(prop);
        }
        hbm.setPropList(list);
        return hbm;
    }

    /**
     * 创建hbm文件
     * 
     * @throws Exception
     */
    public void createHbm() throws Exception {
        Map map = new HashMap(4);
        map.put("hbm", this.hbm);
        this.createFile("hbm", map, this.hbm.getClazzName() + ".hbm.xml");
    }

    /**
     * 装配sql参数
     */
    public Hbm getSql() {
        Hbm hbm = this.hbm;
        // 装配数据库字段
        List<Prop> list = new ArrayList<Prop>();
        Prop sqlProp;
        for (Prop prop : this.hbm.getPropList()) {
            sqlProp = new Prop();
            BeanUtils.copyProperties(prop, sqlProp);
            sqlProp.setType(Consts.CONFIG_MAP.get(prop.getType()));
            list.add(sqlProp);
        }
        Hbm newHbm = new Hbm();
        BeanUtils.copyProperties(hbm, newHbm);
        newHbm.setPropList(list);
        return newHbm;
    }

    /**
     * 生成sql文件
     * 
     * @throws Exception
     */
    public void createSql() throws Exception {
        Map map = new HashMap(4);
        map.put("sql", this.getSql());
        this.createFile("sql", map, this.hbm.getTableName() + ".sql");
    }

    /**
     * 获取dto需要导入的包
     * 
     * @return
     */
    public Set<String> getDtoImport() throws Exception {
        Set<String> packageSet = new LinkedHashSet<String>();
        Hbm hbm = this.hbm;
        List<Prop> propList = this.hbm.getPropList();
        for (Prop p : propList) {
            if (p.getType().equals(Date.class.getName())) {
                packageSet.add(Date.class.getName());
            }
        }
        return packageSet;
    }

    /**
     * 创建dto文件
     * 
     * @throws Exception
     */
    public void createDto() throws Exception {
        Map map = new HashMap(4);
        map.put("dto", this.hbm);
        map.put("author", this.author);
        map.put("packageSet", this.getDtoImport());
        this.createFile("dto", map, this.hbm.getClazzName() + ".java");
    }

    /**
     * 创建dao文件
     * 
     * @throws Exception
     */
    public void createDao() throws Exception {
        Map map = new HashMap(4);
        map.put("dao", this.hbm);
        map.put("author", this.author);
        String clazzName = this.hbm.getClazzName().replace("Tb", "B").replace("DTO", "Dao");
        this.createFile("dao", map, clazzName + ".java");
    }

    /**
     * 创建bpo文件
     * 
     * @throws Exception
     */
    public void createBpo() throws Exception {
        Map map = new HashMap(4);
        map.put("bpo", this.hbm);
        map.put("author", this.author);
        String clazzName = this.hbm.getClazzName().replace("Tb", "B").replace("DTO", "Bpo");
        this.createFile("bpo", map, clazzName + ".java");
    }

    /**
     * 创建facade文件
     * 
     * @throws Exception
     */
    public void createFacade() throws Exception {
        Map map = new HashMap(4);
        map.put("facade", this.hbm);
        map.put("author", this.author);
        String clazzName = this.hbm.getClazzName().replace("Tb", "B").replace("DTO", "Facade");
        this.createFile("facade", map, clazzName + ".java");
    }

    /**
     * 创建配置文件
     * 
     * @throws Exception
     */
    public void createConfig() throws Exception {
        Map map = new HashMap(4);
        map.put("config", this.hbm);
        this.createFile("config", map, this.hbm.getTableName() + ".config.xml");
    }

    /**
     * 创建service
     *
     * @throws Exception
     */
    public void createService() throws Exception {
        Map map = new HashMap(4);
        map.put("service", this.hbm);
        map.put("author", this.author);
        String clazzName = this.hbm.getClazzName().replace("Tb", "B").replace("DTO", "Service");
        this.createFile("service", map, clazzName + ".java");
    }

    /**
     * 创建serviceImpl
     *
     * @throws Exception
     */
    public void createServiceImpl() throws Exception {
        Map map = new HashMap(4);
        map.put("serviceImpl", this.hbm);
        map.put("author", this.author);
        String clazzName = this.hbm.getClazzName().replace("Tb", "B").replace("DTO", "ServiceImpl");
        this.createFile("serviceImpl", map, clazzName + ".java");
    }

}
