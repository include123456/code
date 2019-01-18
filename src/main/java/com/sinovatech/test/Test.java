package com.sinovatech.test;

import java.util.HashMap;

import com.sinovatech.entity.Hbm;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sinovatech.entity.MyFreeMarker;

/**
 * @author shuyi
 * @date 2019年1月16日 下午8:40:08
 */
public class Test {

    public static void main(String[] args) throws Exception {

        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
        MyFreeMarker factory = (MyFreeMarker)ac.getBean("myFreeMarker");
        HashMap<String,Object> map = new HashMap();
        Hbm hbm = factory.getHbm();
        map.put("hbm", hbm);
        factory.createFile("hbm", map, ".xml");
    }
}
