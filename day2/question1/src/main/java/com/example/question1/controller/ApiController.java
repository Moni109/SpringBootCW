package com.example.question1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.question1.config.AppConfig;

@RestController
@Service
public class ApiController {
        @Autowired
    public AppConfig app;
    @GetMapping("/app")
    public String getConfig(){
        String value1=app.getAppName();
        String value2=app.getAppVersion();
        return "AppName : "+value1+" "+"AppVersion : "+value2;
    }
}
