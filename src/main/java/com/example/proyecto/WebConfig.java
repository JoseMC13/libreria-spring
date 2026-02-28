package com.example.proyecto;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins(
                        "https://josemc13.github.io",
                        "http://localhost:8080",
                        "http://127.0.0.1:8080"
                )
                .allowedMethods("GET", "POST", "OPTIONS")
                .allowedHeaders("*");
    }
}
