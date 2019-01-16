package com.sinovatech.config;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

@Configuration
public class Application {

    @Bean
    public PropertyPlaceholderConfigurer propertyPlaceholderConfigurer(String config) {
        PropertyPlaceholderConfigurer configurer = new PropertyPlaceholderConfigurer();
        configurer.setIgnoreUnresolvablePlaceholders(true);
        Resource locations = new ClassPathResource(config);
        configurer.setLocations(locations);
        return configurer;
    }

}
