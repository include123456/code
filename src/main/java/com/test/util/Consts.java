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
        configMap.put(String.class.getSimpleName(), "VARCHAR2");
        configMap.put(Date.class.getSimpleName(), "DATE");
        configMap.put(Double.class.getSimpleName(), "NUMBER");
    }

}
