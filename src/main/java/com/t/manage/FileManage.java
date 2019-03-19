package com.t.manage;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

import com.t.handler.FreeMarkerHandle;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.t.annotation.FileCreate;
import com.t.annotation.Table;
import com.t.config.Application;

/**
 * 创建文件
 * 
 * @author: shuyi
 * @date 2019/3/19 11:38
 */
public class FileManage {

    public static void createFile() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(Application.class);
        FreeMarkerHandle factory = (FreeMarkerHandle)ac.getBean("freeMarkerHandle");
        Map<String, Object> beansWithAnnotation = ac.getBeansWithAnnotation(Table.class);
        beansWithAnnotation.forEach((k, v) -> {
            try {
                factory.setTableDefinition(v.getClass());
                createFile(factory);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    private static void createFile(FreeMarkerHandle factory) throws InvocationTargetException, IllegalAccessException {
        Class factoryClass = factory.getClass();
        Method[] declaredMethods = factoryClass.getDeclaredMethods();
        for (Method method : declaredMethods) {
            if (method.isAnnotationPresent(FileCreate.class)) {
                method.invoke(factory);
            }
        }
    }

}