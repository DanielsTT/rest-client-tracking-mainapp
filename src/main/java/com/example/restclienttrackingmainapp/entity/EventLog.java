package com.example.restclienttrackingmainapp.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
public class EventLog {

    private int id;
    private String ipAddress;
    private String requestMethod;
    private String requestUri;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime requestTimestamp;

}
