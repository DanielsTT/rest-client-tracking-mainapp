package com.example.restclienttrackingmainapp.rest;

import com.example.restclienttrackingmainapp.dto.EventLogDto;
import com.example.restclienttrackingmainapp.service.EventLogCrud;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/proxy", produces = MediaType.APPLICATION_JSON_VALUE)
public class EventLogRestController {

    private final EventLogCrud eventLogService;

    @GetMapping(path = "/logs")
    public ResponseEntity<EventLogDto[]> getEventLogs(@RequestHeader HttpHeaders headers) {
        return ResponseEntity.ok(eventLogService.getEventLogs(headers));
    }
}
