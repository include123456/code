package com.t.handler;

import com.t.entity.TableDefinition;

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
    void createFile(String model, Map<String, Object> map, String fileType) throws Exception;

    /**
     * 获取hbm文件属性
     * 
     * @return
     * @throws Exception
     */
    TableDefinition getDefinitionByClazz(Class clazz) throws Exception;

    void setTableDefinition(Class clazz) throws Exception;

    void createHbm() throws Exception;

    void createSql() throws Exception;

    void createDto() throws Exception;

    void createDao() throws Exception;

    void createBpo() throws Exception;

    void createFacade() throws Exception;

    void createConfig() throws Exception;

    void createService() throws Exception;

    void createServiceImpl() throws Exception;
}
