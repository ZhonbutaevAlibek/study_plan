package com.example.demo.controllers;

import com.example.demo.DTO.UserDTO;
import com.example.demo.entities.UserEntity;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    private UserService userService;

    @ModelAttribute("userForm")
    public UserDTO newUserDTO(){
        return new UserDTO();
    }

    @GetMapping
    public String registration(){
        return "registration";
    }

    @PostMapping
    public String registrationUser(@ModelAttribute("userForm") UserEntity userEntity){
        userService.save(userEntity);
        return "redirect:/registration?success";
    }
}
