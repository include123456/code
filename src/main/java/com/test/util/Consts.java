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

    public static final Map<String, String> CONFIG_MAP = new HashMap<String, String>();

    static {
        CONFIG_MAP.put(String.class.getName(), "VARCHAR2");
        CONFIG_MAP.put(Date.class.getName(), "DATE");
        CONFIG_MAP.put(Double.class.getName(), "NUMBER");
        CONFIG_MAP.put(Integer.class.getName(), "NUMBER");
    }

}
