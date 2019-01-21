package com.test.entity;

import java.util.Map;

public interface BaseFreeMarker {

    void createFile(String model, Map map, String fileType) throws Exception;

    Hbm getHbm() throws Exception;

}
