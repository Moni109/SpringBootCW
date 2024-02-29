package com.example.question2.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.question2.model.Student;

@RestController
public class StudentController {
    @PostMapping("/students")
    public String createStudent(@RequestBody Student student){
        return "Student created: "+student.getName()+",Age: "+student.getAge();
    }
}
