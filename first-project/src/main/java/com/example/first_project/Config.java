package com.example.first_project;

import org.springframework.context.annotation.*;


@Configuration
public class Config {

    @Bean
    @Profile("dev")
    public String devDatabaseConnection(){
        return "Connected to DEV databases";
    }

    @Bean
    @Profile("prod")
    public String prodDatabaseConnection(){
        return "Connected to PROD databases";
    }

}
