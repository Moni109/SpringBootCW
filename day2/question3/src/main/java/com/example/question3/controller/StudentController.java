package com.example.question3.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.question3.model.Student;

@RestController
public class StudentController {
     @GetMapping("/student")
    public Student getStudentdetail(){
        return new Student(1, "John Doe", "This is a student description.");
    }
}
