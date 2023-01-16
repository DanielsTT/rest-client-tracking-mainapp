package com.example.restclienttrackingmainapp.service;

import com.example.restclienttrackingmainapp.dto.EventLogDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class EventLogService implements EventLogCrud{

    private final ModelMapper modelMapper;
    private final RestTemplate restTemplate;


    @Override
    public EventLogDto[] getEventLogs(HttpHeaders headers) {
        RequestEntity<Void> requestEntity = RequestEntity.get("/logs")
                .headers(httpHeaders -> httpHeaders.setAccept(headers.getAccept()))
                .build();
        return restTemplate.exchange(requestEntity, EventLogDto[].class).getBody();
    }

}
