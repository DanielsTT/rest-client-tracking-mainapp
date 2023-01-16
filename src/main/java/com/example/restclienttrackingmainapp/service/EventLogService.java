package com.example.restclienttrackingmainapp.service;

import com.example.restclienttrackingmainapp.dto.EventLogDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class EventLogService implements EventLogCrud{

    private final ModelMapper modelMapper;
    private final RestTemplate restTemplate;


    @Override
    public List<EventLogDto> getEventLogs(HttpHeaders headers) {
        ResponseEntity<EventLogDto[]> response = restTemplate.getForEntity("/logs", EventLogDto[].class);
        return Arrays.asList(Objects.requireNonNull(response.getBody()));
    }

}
