package com.example.demo.services;

import com.example.demo.entities.UserEntity;
import com.example.demo.DTO.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    UserEntity save(UserDTO userDTO);
}
