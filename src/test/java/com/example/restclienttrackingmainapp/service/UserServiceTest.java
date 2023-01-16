package com.example.restclienttrackingmainapp.service;

import com.example.restclienttrackingmainapp.AbstractConfigTest;
import com.example.restclienttrackingmainapp.dto.CreateUserDto;
import com.example.restclienttrackingmainapp.dto.UserDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest extends AbstractConfigTest {

    @Autowired
    private UserService userService;

    @Test
    void createUser() {
        // given
        CreateUserDto user = new CreateUserDto("Jan", "Kovalsky", "jk@example.com", "password", "9603164620");
        UserDto savedUser = userService.createUser(user);

        // when
        UserDto fromDb = userService.findById(savedUser.getId()).orElse(null);

        // then
        assertNotNull(fromDb);
        assertEquals(savedUser.getFirstName(), fromDb.getFirstName());
        assertEquals(savedUser.getLastName(), fromDb.getLastName());
        assertEquals(savedUser.getEmail(), fromDb.getEmail());
        assertEquals(savedUser.getPassword(), fromDb.getPassword());
        assertEquals(savedUser.getPhone(), fromDb.getPhone());
    }

    @Test
    void updateUser() {
        // given
        CreateUserDto user = new CreateUserDto("Janina", "Kowak", "jn@example.com", "password", "9945713320");
        UserDto savedUser = userService.createUser(user);

        // when
        CreateUserDto updatedUser = new CreateUserDto("Janina", "Kovalsky", "jk@example.com", "password", "9945713320");
        userService.updateUser(savedUser.getId(), updatedUser);

        UserDto fromDb = userService.findById(savedUser.getId()).orElse(null);

        //then
        assertNotNull(fromDb);
        assertEquals(updatedUser.getFirstName(), fromDb.getFirstName());
        assertEquals(updatedUser.getLastName(), fromDb.getLastName());
        assertEquals(updatedUser.getEmail(), fromDb.getEmail());
        assertEquals(updatedUser.getPassword(), fromDb.getPassword());
        assertEquals(updatedUser.getPhone(), fromDb.getPhone());
    }
}