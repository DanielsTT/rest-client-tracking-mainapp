package com.example.restclienttrackingmainapp.service;


import com.example.restclienttrackingmainapp.dto.EventLogDto;
import org.springframework.http.HttpHeaders;

import java.util.List;

public interface EventLogCrud {

//    EventLogDto save(CreateEventLogDto createEventLogDto);

    List<EventLogDto> getEventLogs(HttpHeaders headers);
}
