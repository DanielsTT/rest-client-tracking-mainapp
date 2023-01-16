package com.example.restclienttrackingmainapp.config;

import com.example.restclienttrackingmainapp.logger.VisitorLogger;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppConfig implements WebMvcConfigurer {

    private final VisitorLogger visitorLogger;

    public AppConfig(VisitorLogger visitorLogger) {
        this.visitorLogger = visitorLogger;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(visitorLogger);
    }

}
