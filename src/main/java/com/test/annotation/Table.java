package com.test.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Component
public @interface Table {

    /**
     * 类名
     */
    String clazzName();

    /**
     * 表名
     */
    String name();

    /**
     * 表注释
     */
    String comment();

}
