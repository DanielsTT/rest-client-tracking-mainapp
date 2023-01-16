package com.example.restclienttrackingmainapp.controller;

import com.example.restclienttrackingmainapp.dto.CreateUserDto;
import com.example.restclienttrackingmainapp.dto.UserDto;
import com.example.restclienttrackingmainapp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/trainers")
public class TrainerController {

    private final UserService userService;

    public TrainerController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public String getTrainers(Model model) {
        model.addAttribute("trainers", userService.getAllUsers());
        return "trainers";
    }

    @GetMapping("/new")
    public String getNewTrainerForm(Model model) {
        model.addAttribute("trainer", new UserDto());
        return "trainer-form";
    }

    @PostMapping(value = "/new")
    public String createTrainer(@Valid @ModelAttribute("trainer") CreateUserDto user, Model model) {
        model.addAttribute("trainer", userService.createUser(user));
        return "trainer";
    }

}
