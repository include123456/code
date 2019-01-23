package com.test.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import lombok.RequiredArgsConstructor;

/**
 * 常量
 * 
 * @author: shuyi
 * @date 2019/1/23 14:31
 */
@RequiredArgsConstructor
public class Consts {

    public static final Map<String, String> configMap = new HashMap<String, String>();

    static {
        configMap.put(String.class.getName(), "VARCHAR2");
        configMap.put(Date.class.getName(), "DATE");
        configMap.put(Double.class.getName(), "NUMBER");
        configMap.put(Integer.class.getName(), "NUMBER");
    }

}
