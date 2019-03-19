package com.test.entity;

import java.util.Map;

/**
 * freemarker接口
 * 
 * @author: shuyi
 * @date 2019/1/23 14:36
 */
public interface BaseFreeMarker {

    /**
     * 创建文件
     * 
     * @param model
     * @param map
     * @param fileType
     * @throws Exception
     */
    void createFile(String model, Map map, String fileType) throws Exception;

    /**
     * 获取hbm文件属性
     * 
     * @return
     * @throws Exception
     */
    Hbm getHbm(Class clazz) throws Exception;

}
