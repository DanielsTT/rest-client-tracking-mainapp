package com.example.restclienttrackingmainapp.repository;


import com.example.restclienttrackingmainapp.entity.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainerRepository extends JpaRepository<Trainer, Long> {
}
