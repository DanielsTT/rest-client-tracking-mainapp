package com.example.restclienttrackingmainapp.logger;


import com.example.restclienttrackingmainapp.dto.CreateVisitorDto;
import com.example.restclienttrackingmainapp.service.VisitorService;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;

@Component
public class VisitorLogger implements HandlerInterceptor {

    private final VisitorService visitorService;

    public VisitorLogger(VisitorService visitorService) {
        this.visitorService = visitorService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        CreateVisitorDto visitorLog = new CreateVisitorDto();

        visitorLog.setIpAddress(request.getRemoteAddr());
        visitorLog.setMethod(request.getMethod());
        visitorLog.setRequest(String.valueOf(request.getRequestURL()));
        visitorLog.setLoggedTime(LocalDateTime.now());

        visitorService.saveVisitorInfo(visitorLog);

        return true;
    }
}
