package com.example.restclienttrackingmainapp.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class CreateVisitorDto {

    private String ipAddress;
    private String method;
    private String request;
    private LocalDateTime loggedTime;
}