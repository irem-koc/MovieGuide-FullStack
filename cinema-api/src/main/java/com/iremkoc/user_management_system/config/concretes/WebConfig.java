package com.iremkoc.user_management_system.config.concretes;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/v1/auth/login")
                .allowedOrigins("http://localhost:8080")
                .allowedMethods("POST");

        registry.addMapping("/api/v1/auth/register")
                .allowedOrigins("http://localhost:8080")
                .allowedMethods("POST");
    }
}
