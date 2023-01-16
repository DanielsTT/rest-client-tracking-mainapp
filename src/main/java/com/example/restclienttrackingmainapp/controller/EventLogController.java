package com.example.restclienttrackingmainapp.controller;

import com.example.restclienttrackingmainapp.dto.EventLogDto;
import com.example.restclienttrackingmainapp.service.EventLogCrud;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(path = "/proxy", produces = MediaType.APPLICATION_JSON_VALUE)
public class EventLogController {

    private final EventLogCrud eventLogService;

    public EventLogController(EventLogCrud eventLogService) {
        this.eventLogService = eventLogService;
    }

    @GetMapping(path = "/logs")
    public String getEventLogs(@RequestHeader HttpHeaders headers, Model model) {
        List<EventLogDto> eventLogs = eventLogService.getEventLogs(headers);
        model.addAttribute("logs", eventLogs);
        return "event-logs";
    }
}
