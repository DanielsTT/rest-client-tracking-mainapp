package com.example.restclienttrackingmainapp.service;


import com.example.restclienttrackingmainapp.dto.CreateVisitorDto;
import com.example.restclienttrackingmainapp.dto.VisitorDto;
import com.example.restclienttrackingmainapp.entity.Visitor;
import com.example.restclienttrackingmainapp.repository.VisitorRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VisitorService {

    private final VisitorRepository visitorRepository;
    private final ModelMapper modelMapper;

    public VisitorDto saveVisitorInfo(CreateVisitorDto createVisitorDto) {
        Visitor visitor = modelMapper.map(createVisitorDto, Visitor.class);
        return modelMapper.map(visitorRepository.save(visitor), VisitorDto.class);
    }
}
