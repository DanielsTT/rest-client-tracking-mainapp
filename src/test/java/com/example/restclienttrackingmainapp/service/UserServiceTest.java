package com.example.restclienttrackingmainapp.service;

import com.example.restclienttrackingmainapp.AbstractConfigTest;
import com.example.restclienttrackingmainapp.dto.UserDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;


class UserServiceTest extends AbstractConfigTest {

//    @Autowired
//    private UserService userService;
//
//    @Test
//    void createUser() {
//        // given
//        CreateUserDto user = new CreateUserDto("Jan", "Kovalsky", "jk@example.com", "password", "9603164620");
//        UserDto savedUser = userService.createUser(user);
//
//        // when
//        UserDto fromDb = userService.findById(savedUser.getId()).orElse(null);
//
//        // then
//        assertNotNull(fromDb);
//        assertEquals(savedUser.getFirstName(), fromDb.getFirstName());
//        assertEquals(savedUser.getLastName(), fromDb.getLastName());
//        assertEquals(savedUser.getEmail(), fromDb.getEmail());
//        assertEquals(savedUser.getPassword(), fromDb.getPassword());
//        assertEquals(savedUser.getPhone(), fromDb.getPhone());
//    }
//
//    @Test
//    void updateUser() {
//        // given
//        CreateUserDto user = new CreateUserDto("Janina", "Kowak", "jn@example.com", "password", "9945713320");
//        UserDto savedUser = userService.createUser(user);
//
//        UserDto userFromDb = userService.findById(savedUser.getId()).orElse(null);
//        userFromDb.setLastName("Kovalsky");
//        userFromDb.setEmail("jk@example.com");
//
//        // when
//        UserDto updatedUser = userService.updateUser(userFromDb);
//
//        //then
//        assertNotNull(updatedUser);
//        assertEquals(updatedUser.getLastName(), "Kovalsky");
//        assertEquals(updatedUser.getEmail(), "jk@example.com");
//
//    }
}