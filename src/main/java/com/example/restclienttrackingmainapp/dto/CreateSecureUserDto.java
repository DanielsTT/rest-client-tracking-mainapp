package com.example.restclienttrackingmainapp.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class CreateSecureUserDto {

    private Long id;
    private String firstName;

    private List<String> roles;
}
