package com.sinovatech.entity;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.sinovatech.annotation.Table;
import com.sinovatech.annotation.TableFiled;
import com.sinovatech.model.Model;
import com.sinovatech.util.StringUtils;

import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.util.ObjectUtils;

@Component
public class MyFreeMarker implements BaseFreeMarker {

    @Value("${outpath}")
    private String outPath;
    @Resource
    private Model model;

    /**
     * 输出模板生成的文件
     * 
     * @param model
     * @param map
     * @param fileType
     * @throws Exception
     */
    public void createFile(String model, Map map, String fileType) throws Exception {
        Configuration configuration = new Configuration();
        String path = Thread.currentThread().getClass().getResource("/").getPath();
        String dir = (path + "model/").substring(1);
        File file = new File(dir);
        configuration.setDirectoryForTemplateLoading(file);
        Template template = configuration.getTemplate(model + ".ftl", "UTF-8");
        Writer out = new FileWriter(new File(this.outPath + model + fileType));
        template.process(map, out);
    }

    /**
     * 生成hbm.xml文件
     * 
     * @return
     * @throws Exception
     */
    public Hbm getHbm() throws Exception {
        Hbm hbm = new Hbm();
        Table table = Model.class.getAnnotation(Table.class);
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

}
