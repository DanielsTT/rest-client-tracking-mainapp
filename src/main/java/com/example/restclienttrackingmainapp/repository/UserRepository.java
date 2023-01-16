package com.example.restclienttrackingmainapp.repository;

import com.example.restclienttrackingmainapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
