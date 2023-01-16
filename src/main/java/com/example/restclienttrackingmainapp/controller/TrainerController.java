package com.example.restclienttrackingmainapp.controller;

import com.example.restclienttrackingmainapp.dto.CreateUserDto;
import com.example.restclienttrackingmainapp.dto.UserDto;
import com.example.restclienttrackingmainapp.service.SecureUserService;
import com.example.restclienttrackingmainapp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String addNewTrainer(@Valid @ModelAttribute("trainer") CreateUserDto user, Model model) {
        model.addAttribute("trainer", userService.createUser(user));
        return "trainer";
    }

    @GetMapping("{id}")
    public String getTrainer(@PathVariable Long id, Model model) {
        UserDto trainerDto = userService.findById(id).orElseThrow();
        model.addAttribute("trainer", trainerDto);
        return "trainer";
    }


    @GetMapping("edit/{id}")
    public String getEditTrainerForm(@PathVariable Long id, Model model) {
        UserDto trainerDto = userService.findById(id).orElseThrow();
        model.addAttribute("trainer", trainerDto);
        return "trainer-edit-form";
    }


    @PostMapping(value = "/update")
    public String editTrainer(@Valid @ModelAttribute("trainer") UserDto trainer, Model model) {
        UserDto update = userService.updateUser(trainer);

        if (update == null) {
            return "error";
        }

        model.addAttribute("trainer", update);
        return "trainer";
    }

    @GetMapping("/delete/{id}")
    public String deleteTrainer(@PathVariable Long id) {
        userService.deleteUser(id);
        return "redirect:/trainers/all";
    }

}
