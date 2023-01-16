package com.example.restclienttrackingmainapp.bean;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Beans {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public RestTemplate restTemplate(
            @Value("${com.example.restclienttrackingmainapp.service-url}") String serviceUrl,
            RestTemplateBuilder builder) {
        return builder
                .rootUri(serviceUrl)
                .build();
    }
}

