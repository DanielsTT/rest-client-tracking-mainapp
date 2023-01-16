package com.example.restclienttrackingmainapp.config;

import com.example.restclienttrackingmainapp.logger.EventLogLogger;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppConfig implements WebMvcConfigurer {

    private final EventLogLogger eventLogLogger;

    public AppConfig(EventLogLogger eventLogLogger) {
        this.eventLogLogger = eventLogLogger;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(eventLogLogger).excludePathPatterns("/proxy/**");
        registry.addInterceptor(eventLogLogger).addPathPatterns("/trainers/**");
    }

}
