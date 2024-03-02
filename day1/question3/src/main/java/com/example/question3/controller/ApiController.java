package com.example.question3.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {
     
     @RequestMapping("/favouriteColor")
     public String requestMethodName(@RequestParam String color) {
         return "My favorite color is " + color + "!";
     }
     
}

