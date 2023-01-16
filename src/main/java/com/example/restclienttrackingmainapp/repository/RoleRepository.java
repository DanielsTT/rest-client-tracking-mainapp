package com.example.restclienttrackingmainapp.repository;


import com.example.restclienttrackingmainapp.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}

