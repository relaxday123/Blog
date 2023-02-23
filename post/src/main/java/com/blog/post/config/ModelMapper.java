package com.blog.post.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapper {

    @Bean
    public org.modelmapper.ModelMapper modelMapperConfig() {
        return new org.modelmapper.ModelMapper();
    }
}
