package com.example.restclienttrackingmainapp.logger;

import com.example.restclienttrackingmainapp.dto.CreateEventLogDto;
import com.example.restclienttrackingmainapp.service.EventLogCrud;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class EventLogLogger implements HandlerInterceptor {

    private final EventLogCrud eventLogService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        CreateEventLogDto eventLog = new CreateEventLogDto();

        eventLog.setIpAddress(request.getRemoteAddr());
        eventLog.setRequestMethod(request.getMethod());
        eventLog.setRequestUri(String.valueOf(request.getRequestURL()));
        eventLog.setRequestTimestamp(LocalDate.now());

        eventLogService.createEventLog(eventLog);

        return true;
    }
}
