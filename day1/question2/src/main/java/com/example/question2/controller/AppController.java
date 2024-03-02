package com.example.question2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {
    @GetMapping("/student{name}")
    public String studentname(@PathVariable ("name") String pass){
        return "Welcome "+pass;
    }
}