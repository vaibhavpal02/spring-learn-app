package com.vaibhavpal.springlearnapp.configures;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Mapconfigure
{
    @Bean
    public ModelMapper getModelmapper()
    {
        return new ModelMapper();
    }

}
