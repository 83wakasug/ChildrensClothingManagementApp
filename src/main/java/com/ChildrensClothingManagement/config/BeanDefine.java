package com.ChildrensClothingManagement.config;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanDefine {

    @Bean
    Mapper mapper() {
        return DozerBeanMapperBuilder.buildDefault();
    }

}
