package com.example.restclienttrackingmainapp.service;

import com.example.restclienttrackingmainapp.dto.CreateUserDto;
import com.example.restclienttrackingmainapp.dto.UserDto;
import com.example.restclienttrackingmainapp.entity.User;
import com.example.restclienttrackingmainapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(user -> modelMapper.map(user, UserDto.class))
                .collect(Collectors.toList());
    }

    public Optional<UserDto> findById(Long id) {
        return userRepository.findById(id).map(user -> modelMapper.map(user, UserDto.class));
    }

    @Transactional
    public UserDto createUser(CreateUserDto createUserDto) {
        User user = modelMapper.map(createUserDto, User.class);
        return modelMapper.map(userRepository.save(user), UserDto.class);
    }

    @Transactional
    public UserDto updateUser(Long id, CreateUserDto updateUserDto) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            user.setFirstName(updateUserDto.getFirstName());
            user.setLastName(updateUserDto.getLastName());
            user.setEmail(updateUserDto.getEmail());
            user.setPassword(updateUserDto.getPassword());
            user.setPhone(updateUserDto.getPhone());
        }

        userRepository.save(user);

        return modelMapper.map(user, UserDto.class);
    }

    @Transactional
    public boolean deleteUser(Long id){
        Optional<User> user = userRepository.findById(id);

        if (user.isPresent()) {
            userRepository.delete(user.get());
            return true;
        }

        return false;
    }

}