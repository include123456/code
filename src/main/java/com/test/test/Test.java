package com.test.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.test.config.Application;
import com.test.entity.MyFreeMarker;

/**
 * @author shuyi
 * @date 2019年1月16日 下午8:40:08
 */
public class Test {

    public static void main(String[] args) throws Exception {

        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(Application.class);

        MyFreeMarker factory = (MyFreeMarker)ac.getBean("myFreeMarker");
        // 创建hbm文件
        factory.createHbm();
        // 创建sql文件
        factory.createSql();
        // 创建dto文件
        factory.createDto();
        // 创建dao文件
        factory.createDao();
        // 创建bpo文件
        factory.createBpo();
        // 创建facade文件
        factory.createFacade();
        // 创建service文件
        factory.createService();
        // 创建xml文件
        factory.createConfig();
    }
}
