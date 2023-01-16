package com.example.restclienttrackingmainapp.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {

    private Long id;

    //    @NotEmpty
    private String firstName;

    //    @NotEmpty
    private String lastName;

    //    @NotEmpty(message = "Email should not be empty")
//    @Email
    private String email;

    //    @NotEmpty(message = "Password should not be empty")
    private String password;

    //    @NotEmpty
    private String phone;

    private List<String> roles;
}