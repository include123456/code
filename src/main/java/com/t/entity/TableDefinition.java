package com.t.entity;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * 获取hbm文件所需要的映射
 * 
 * @author: shuyi
 * @date 2019/1/23 14:27
 */
@Getter
@Setter
public class TableDefinition {

    /**
     * class_name
     */
    private String clazzName;

    /**
     * table
     */
    private String tableName;

    /**
     * comment
     */
    private String tableComment;

    /**
     * 属性信息
     */
    private List<FieldProperty> propList;

}
