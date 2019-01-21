package com.test.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Hbm {

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
    private List<Prop> propList;

}
