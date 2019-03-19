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

import com.test.annotation.FileCreate;
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
public class FreeMarkerHandle implements BaseFreeMarkerHandle {

    @Value("${outpath}")
    private String outPath;
    @Value("${author}")
    private String author;

    private TableDefinition tableDefinition;

    public void setHbm(Class clazz) throws Exception {
        this.tableDefinition = getDefinitionByClazz(clazz);
    }

    /**
     * 输出模板生成的文件
     * 
     * @param model
     * @param map
     * @param fileName
     * @throws Exception
     */
    public void createFile(String model, Map<String,Object> map, String fileName) throws Exception {
        String filePath = this.outPath + "\\" + this.tableDefinition.getTableName();
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
    public TableDefinition getDefinitionByClazz(Class clazz) throws Exception {
        TableDefinition hbm = new TableDefinition();
        Table table = (Table)clazz.getAnnotation(Table.class);
        // 获取table上的值
        hbm.setTableName(table.name());
        hbm.setClazzName(table.clazzName());
        hbm.setTableComment(table.comment());
        // 获取属性值
        Field[] fields = clazz.getDeclaredFields();
        FieldProperty prop;
        List<FieldProperty> list = new ArrayList<FieldProperty>();
        for (Field field : fields) {
            TableFiled fieldAnnotation = field.getAnnotation(TableFiled.class);
            if (ObjectUtils.isEmpty(fieldAnnotation)) {
                continue;
            }
            prop = new FieldProperty();
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
    @FileCreate
    public void createHbm() throws Exception {
        Map<String,Object> map = new HashMap(4);
        map.put("hbm", this.tableDefinition);
        this.createFile("hbm", map, this.tableDefinition.getClazzName() + ".hbm.xml");
    }

    /**
     * 装配sql参数
     */
    public TableDefinition getSql() {
        TableDefinition hbm = this.tableDefinition;
        // 装配数据库字段
        List<FieldProperty> list = new ArrayList<FieldProperty>();
        FieldProperty sqlProp;
        for (FieldProperty prop : this.tableDefinition.getPropList()) {
            sqlProp = new FieldProperty();
            BeanUtils.copyProperties(prop, sqlProp);
            sqlProp.setType(Consts.CONFIG_MAP.get(prop.getType()));
            list.add(sqlProp);
        }
        TableDefinition newHbm = new TableDefinition();
        BeanUtils.copyProperties(hbm, newHbm);
        newHbm.setPropList(list);
        return newHbm;
    }

    /**
     * 生成sql文件
     * 
     * @throws Exception
     */
    @FileCreate
    public void createSql() throws Exception {
        Map<String,Object> map = new HashMap(4);
        map.put("sql", this.getSql());
        this.createFile("sql", map, this.tableDefinition.getTableName() + ".sql");
    }

    /**
     * 获取dto需要导入的包
     * 
     * @return
     */
    public Set<String> getDtoImport() throws Exception {
        Set<String> packageSet = new LinkedHashSet<String>();
        TableDefinition hbm = this.tableDefinition;
        List<FieldProperty> propList = this.tableDefinition.getPropList();
        for (FieldProperty p : propList) {
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
    @FileCreate
    public void createDto() throws Exception {
        Map<String,Object> map = new HashMap(4);
        map.put("dto", this.tableDefinition);
        map.put("author", this.author);
        map.put("packageSet", this.getDtoImport());
        this.createFile("dto", map, this.tableDefinition.getClazzName() + ".java");
    }

    /**
     * 创建dao文件
     * 
     * @throws Exception
     */
    @FileCreate
    public void createDao() throws Exception {
        Map<String,Object> map = new HashMap(4);
        map.put("dao", this.tableDefinition);
        map.put("author", this.author);
        String clazzName = this.tableDefinition.getClazzName().replace("Tb", "B").replace("DTO", "Dao");
        this.createFile("dao", map, clazzName + ".java");
    }

    /**
     * 创建bpo文件
     * 
     * @throws Exception
     */
    @FileCreate
    public void createBpo() throws Exception {
        Map<String,Object> map = new HashMap(4);
        map.put("bpo", this.tableDefinition);
        map.put("author", this.author);
        String clazzName = this.tableDefinition.getClazzName().replace("Tb", "B").replace("DTO", "Bpo");
        this.createFile("bpo", map, clazzName + ".java");
    }

    /**
     * 创建facade文件
     * 
     * @throws Exception
     */
    @FileCreate
    public void createFacade() throws Exception {
        Map<String,Object> map = new HashMap(4);
        map.put("facade", this.tableDefinition);
        map.put("author", this.author);
        String clazzName = this.tableDefinition.getClazzName().replace("Tb", "B").replace("DTO", "Facade");
        this.createFile("facade", map, clazzName + ".java");
    }

    /**
     * 创建配置文件
     * 
     * @throws Exception
     */
    @FileCreate
    public void createConfig() throws Exception {
        Map<String,Object> map = new HashMap(4);
        map.put("config", this.tableDefinition);
        this.createFile("config", map, this.tableDefinition.getTableName() + ".config.xml");
    }

    /**
     * 创建service
     *
     * @throws Exception
     */
    @FileCreate
    public void createService() throws Exception {
        Map<String,Object> map = new HashMap(4);
        map.put("service", this.tableDefinition);
        map.put("author", this.author);
        String clazzName = this.tableDefinition.getClazzName().replace("Tb", "B").replace("DTO", "Service");
        this.createFile("service", map, clazzName + ".java");
    }

    /**
     * 创建serviceImpl
     *
     * @throws Exception
     */
    @FileCreate
    public void createServiceImpl() throws Exception {
        Map<String,Object> map = new HashMap(4);
        map.put("serviceImpl", this.tableDefinition);
        map.put("author", this.author);
        String clazzName = this.tableDefinition.getClazzName().replace("Tb", "B").replace("DTO", "ServiceImpl");
        this.createFile("serviceImpl", map, clazzName + ".java");
    }

}
