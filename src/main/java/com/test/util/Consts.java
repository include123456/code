package com.test.util;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 常量
 */
@RequiredArgsConstructor
public class Consts {

    public static final Map<String, String> configMap = new HashMap<String, String>();

    static {
        configMap.put(String.class.getName(), "VARCHAR2");
        configMap.put(Date.class.getName(), "DATE");
        configMap.put(Double.class.getName(), "NUMBER");
    }

}
