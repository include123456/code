package com.test.entity;

import java.util.Map;

/**
 * freemarker接口
 * 
 * @author: shuyi
 * @date 2019/1/23 14:36
 */
public interface BaseFreeMarkerHandle {

    /**
     * 创建文件
     * 
     * @param model
     * @param map
     * @param fileType
     * @throws Exception
     */
    void createFile(String model, Map<String, String> map, String fileType) throws Exception;

    /**
     * 获取hbm文件属性
     * 
     * @return
     * @throws Exception
     */
    TableDefinition getDefinitionByClazz(Class clazz) throws Exception;

}
