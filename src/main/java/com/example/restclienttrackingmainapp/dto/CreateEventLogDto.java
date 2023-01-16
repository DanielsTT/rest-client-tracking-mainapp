package com.example.restclienttrackingmainapp.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class CreateEventLogDto {

    private String ipAddress;

    private String requestMethod;

    private String requestUri;

    private LocalDate requestTimestamp;
}
