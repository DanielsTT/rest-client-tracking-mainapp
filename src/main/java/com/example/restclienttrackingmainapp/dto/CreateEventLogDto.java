package com.example.restclienttrackingmainapp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class CreateEventLogDto {

    private String ipAddress;

    private String requestMethod;

    private String requestUri;

    private String user;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime requestTimestamp;
}
