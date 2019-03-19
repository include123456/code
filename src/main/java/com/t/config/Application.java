package com.t.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

/**
 * 配置类
 * 
 * @author: shuyi
 * @date 2019/1/23 14:36
 */
@Configuration
@ComponentScan(value = {"com.t"})
@PropertySources({@PropertySource("classpath:config.properties")})
public class Application {

}
