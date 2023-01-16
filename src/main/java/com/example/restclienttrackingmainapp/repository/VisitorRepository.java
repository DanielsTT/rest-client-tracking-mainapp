package com.example.restclienttrackingmainapp.repository;

import com.example.restclienttrackingmainapp.entity.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitorRepository extends JpaRepository<Visitor, Long> {
}
