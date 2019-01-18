package com.sinovatech.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Prop {

    /**
     * name
     */
    private String name;

    /**
     * fieldName
     */
    private String fieldName;

    /**
     * type
     */
    private String type;

    /**
     * length
     */
    private String length;

    /**
     * 注解
     */
    private String comment;

}