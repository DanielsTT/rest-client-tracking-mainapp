package com.example.restclienttrackingmainapp.service;

import com.example.restclienttrackingmainapp.dto.UserDto;
import com.example.restclienttrackingmainapp.entity.Role;
import com.example.restclienttrackingmainapp.entity.User;
import com.example.restclienttrackingmainapp.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class SecureUserService implements UserDetailsService {

    private final UserRepository userRepository;

    public SecureUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByFirstName(username)
                .orElseThrow(() -> new UsernameNotFoundException("User: " + username + " does not exist"));
        return map(user);
    }

    public List<UserDto> getUsers() {
        return userRepository.findAll().stream().map(this::map).map(this::toDto).collect(Collectors.toList());
    }

    private SecureUser map(User user) {
        SecureUser secure = new SecureUser();
        secure.setId(user.getId());
        secure.setUsername(user.getFirstName());
        secure.setPassword(user.getPassword());
        secure.setRoles(user.getRoles().stream().map(Role::getName).collect(Collectors.toList()));
        return secure;
    }

    private UserDto toDto(SecureUser user) {
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setFirstName(user.getUsername());
        dto.setRoles(user.getRoles());
        return dto;
    }
}
