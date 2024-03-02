package com.example.question5.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.question5.model.Student;

@RestController
public class StudentController{
    @GetMapping("/student")
    public List<Student> studentDetails(){
        List <Student> li=new ArrayList<>();
        li.add( new Student("Malavika", 103));
        li.add( new Student("Monika", 109));
        return li;
    }
}

