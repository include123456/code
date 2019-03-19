package com.test.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.test.annotation.FileCreate;
import com.test.annotation.Table;
import com.test.config.Application;
import com.test.entity.FreeMarkerHandle;

/**
 * @author shuyi
 * @date 2019年1月16日 下午8:40:08
 */
public class Test {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(Application.class);
        FreeMarkerHandle factory = (FreeMarkerHandle)ac.getBean("freeMarkerHandle");
        Map<String, Object> beansWithAnnotation = ac.getBeansWithAnnotation(Table.class);
        beansWithAnnotation.forEach((k, v) -> {
            try {
                factory.setHbm(v.getClass());
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
