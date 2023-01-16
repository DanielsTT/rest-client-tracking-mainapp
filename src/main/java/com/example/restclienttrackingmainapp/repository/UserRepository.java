package com.example.restclienttrackingmainapp.repository;

import com.example.restclienttrackingmainapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByFirstName(String firstName);
}
