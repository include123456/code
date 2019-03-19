package com.t.util;

/**
 * 字符串工具类
 * 
 * @author: shuyi
 * @date 2019/1/23 14:30
 */
public class StringUtils extends org.apache.commons.lang3.StringUtils {

    public static final char UNDERLINE = '_';

    /**
     * 驼峰转换成_
     *
     * @param fieldName
     * @return
     */
    public static String getTableField(String fieldName) {
        if (fieldName == null || "".equals(fieldName.trim())) {
            return "";
        }
        char[] chars = fieldName.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char a : chars) {
            if (Character.isUpperCase(a)) {
                sb.append(UNDERLINE);
                sb.append(Character.toLowerCase(a));
            } else {
                sb.append(a);
            }
        }
        return sb.toString();
    }

}
