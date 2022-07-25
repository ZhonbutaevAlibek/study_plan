package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class UserController {

    @GetMapping("/admin")
    public String helooAdmin(){
        return "admin";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

}
