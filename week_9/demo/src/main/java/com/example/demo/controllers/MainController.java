package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    @GetMapping("/tohome")
    public String home(){
        return "redirect:home";
    }

    @GetMapping("/home")
    public String welcome(){
        return "home";
    }
}
