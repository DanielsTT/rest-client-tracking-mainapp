package com.example.restclienttrackingmainapp.controller;

import com.example.restclienttrackingmainapp.dto.UserDto;
import com.example.restclienttrackingmainapp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegistrationController {

    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String registration(Model model){
        UserDto user = new UserDto();
        model.addAttribute("user", user);
        return "register";
    }
}
