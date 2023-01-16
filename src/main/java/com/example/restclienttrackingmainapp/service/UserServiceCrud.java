package com.example.restclienttrackingmainapp.service;



import com.example.restclienttrackingmainapp.dto.UserDto;
import com.example.restclienttrackingmainapp.entity.User;

import java.util.List;

public interface UserServiceCrud {

    void saveUser(UserDto userDto);

    User findByEmail(String email);

    List<UserDto> findAllUsers();

}
