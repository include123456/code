package com.sinovatech.test;

import com.sinovatech.util.FreeMarkerFactory;
import freemarker.template.TemplateException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author shuyi
 * @date 2019年1月16日 下午8:40:08
 */
public class Test {

    public static void main(String[] args) throws IOException, TemplateException {

        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
        FreeMarkerFactory factory = (FreeMarkerFactory) ac.getBean("freeMarkerFactory");
        HashMap<String, String> map = new HashMap<String, String>();
        //
        map.put("hello","xxxxx");

        //
        factory.createFile("hbm",map,".xml");

    }
}
