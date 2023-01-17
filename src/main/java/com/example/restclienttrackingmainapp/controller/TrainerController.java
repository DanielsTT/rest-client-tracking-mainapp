package com.example.restclienttrackingmainapp.controller;

import com.example.restclienttrackingmainapp.dto.CreateTrainerDto;
import com.example.restclienttrackingmainapp.dto.TrainerDto;
import com.example.restclienttrackingmainapp.service.TrainerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
@RequestMapping("/trainers")
public class TrainerController {

    private final TrainerService trainerService;

    public TrainerController(TrainerService trainerService) {
        this.trainerService = trainerService;
    }

    @GetMapping("/all")
    public String getTrainers(Model model) {
        model.addAttribute("trainers", trainerService.getAllTrainers());
        return "trainers";
    }

    @GetMapping("/new")
    public String getNewTrainerForm(Model model) {
        model.addAttribute("trainer", new TrainerDto());
        return "trainer-form";
    }

    @PostMapping(value = "/new")
    public String addNewTrainer(@Valid @ModelAttribute("trainer") CreateTrainerDto trainer, Model model) {
        model.addAttribute("trainer", trainerService.createTrainer(trainer));
        return "trainer";
    }

    @GetMapping("{id}")
    public String getTrainer(@PathVariable Long id, Model model) {
        TrainerDto trainerDto = trainerService.findById(id).orElseThrow();
        model.addAttribute("trainer", trainerDto);
        return "trainer";
    }


    @GetMapping("edit/{id}")
    public String getEditTrainerForm(@PathVariable Long id, Model model) {
        TrainerDto trainerDto = trainerService.findById(id).orElseThrow();
        model.addAttribute("trainer", trainerDto);
        return "trainer-edit-form";
    }


    @PostMapping(value = "/update")
    public String editTrainer(@Valid @ModelAttribute("trainer") TrainerDto trainer, Model model) {
        TrainerDto update = trainerService.updateTrainer(trainer);

        if (update == null) {
            return "error";
        }

        model.addAttribute("trainer", update);
        return "trainer";
    }

    @GetMapping("/delete/{id}")
    public String deleteTrainer(@PathVariable Long id) {
        trainerService.deleteTrainer(id);
        return "redirect:/trainers/all";
    }

}
