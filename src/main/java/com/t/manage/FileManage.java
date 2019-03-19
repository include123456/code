package com.t.manage;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.t.annotation.FileCreate;
import com.t.annotation.Table;
import com.t.config.Application;
import com.t.handler.BaseFreeMarkerHandle;

/**
 * 创建文件
 * 
 * @author: shuyi
 * @date 2019/3/19 11:38
 */
public class FileManage {

    public static void createFile() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(Application.class);
        BaseFreeMarkerHandle handle = (BaseFreeMarkerHandle)ac.getBean("freeMarkerHandle");
        Map<String, Object> beansWithAnnotation = ac.getBeansWithAnnotation(Table.class);
        beansWithAnnotation.forEach((k, v) -> {
            try {
                handle.setTableDefinition(v.getClass());
                createFile(handle);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    private static void createFile(BaseFreeMarkerHandle handle)
        throws InvocationTargetException, IllegalAccessException {
        Class handleClass = handle.getClass();
        Method[] declaredMethods = handleClass.getDeclaredMethods();
        for (Method method : declaredMethods) {
            if (method.isAnnotationPresent(FileCreate.class)) {
                method.invoke(handle);
            }
        }
    }

}
