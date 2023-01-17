package com.example.restclienttrackingmainapp.service;

import com.example.restclienttrackingmainapp.dto.CreateTrainerDto;
import com.example.restclienttrackingmainapp.dto.TrainerDto;
import com.example.restclienttrackingmainapp.entity.Trainer;
import com.example.restclienttrackingmainapp.repository.TrainerRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TrainerService {

    private final TrainerRepository trainerRepository;
    private final ModelMapper modelMapper;

    public List<TrainerDto> getAllTrainers() {
        return trainerRepository.findAll().stream()
                .map(trainer -> modelMapper.map(trainer, TrainerDto.class))
                .collect(Collectors.toList());
    }

    public Optional<TrainerDto> findById(Long id) {
        return trainerRepository.findById(id).map(trainer -> modelMapper.map(trainer, TrainerDto.class));
    }

    @Transactional
    public TrainerDto createTrainer(CreateTrainerDto createTrainerDto) {
        Trainer trainer = modelMapper.map(createTrainerDto, Trainer.class);
        return modelMapper.map(trainerRepository.save(trainer), TrainerDto.class);
    }

    @Transactional
    public TrainerDto updateTrainer(TrainerDto trainerDto) {
        Trainer trainer = trainerRepository.findById(trainerDto.getId()).orElse(null);
        if (trainer != null) {
            trainer.setFirstName(trainerDto.getFirstName());
            trainer.setEmail(trainerDto.getEmail());
        }

        trainerRepository.save(trainer);

        return modelMapper.map(trainer, TrainerDto.class);
    }

    @Transactional
    public boolean deleteTrainer(Long id) {
        Optional<Trainer> trainer = trainerRepository.findById(id);

        if (trainer.isPresent()) {
            trainerRepository.delete(trainer.get());
            return true;
        }

        return false;
    }

}
