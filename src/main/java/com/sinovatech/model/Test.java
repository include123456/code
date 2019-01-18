package com.sinovatech.model;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author shuyi
 * @date 2019年1月16日 下午8:40:08
 */
public class Test {
    public static void main(String[] args) {

        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
        Model model = (Model)ac.getBean("model");
        model.print();

    }
}
