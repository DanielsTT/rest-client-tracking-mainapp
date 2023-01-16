package com.example.restclienttrackingmainapp.service;


import com.example.restclienttrackingmainapp.dto.CreateEventLogDto;
import com.example.restclienttrackingmainapp.dto.EventLogDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EventLogCrud {

    List<EventLogDto> getEventLogs(HttpHeaders headers);

    ResponseEntity<CreateEventLogDto> createEventLog(CreateEventLogDto createEventLogDto);
}
