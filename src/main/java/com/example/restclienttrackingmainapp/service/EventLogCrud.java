package com.example.restclienttrackingmainapp.service;


import com.example.restclienttrackingmainapp.dto.EventLogDto;
import org.springframework.http.HttpHeaders;

public interface EventLogCrud {

//    EventLogDto save(CreateEventLogDto createEventLogDto);

    EventLogDto[] getEventLogs(HttpHeaders headers);
}
