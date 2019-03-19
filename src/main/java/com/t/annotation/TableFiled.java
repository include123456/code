package com.t.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface TableFiled {

    /**
     * 注释
     */
    String comment();

    /**
     * 长度
     */
    String length() default "";
}
