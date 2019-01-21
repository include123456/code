package com.test.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 根据model文件生成sql文件需要的字段信息
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Sql {

    /** 字段 */
    private String field;
    /** 类型 */
    private String type;
    /** 注释 */
    private String commont;

}
