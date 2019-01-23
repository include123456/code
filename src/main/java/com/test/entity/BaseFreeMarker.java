package com.test.entity;

import java.util.Map;

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
    Hbm getHbm() throws Exception;

}
