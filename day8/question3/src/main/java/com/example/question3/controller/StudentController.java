package com.example.question3.controller;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.question3.model.Student;
import com.example.question3.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
    private StudentService studentService;
    public StudentController(StudentService studentService){
        this.studentService=studentService;
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        if(studentService.savedStudents(student)!=null){
            return new ResponseEntity<>(student,HttpStatus.CREATED);
        }
        return new ResponseEntity<>(student,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/markGreaterThan/{mark}")
    public ResponseEntity<List<Student>> getgreaterMark(@PathVariable int mark){
        List<Student> s = studentService.getGreaterMark(mark);
        if(s!=null){
            return new ResponseEntity<>(s,HttpStatus.OK);
        }
        return new ResponseEntity<>(s,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/markLesserThan/{mark}")
    public ResponseEntity<List<Student>> getlesserMark(@PathVariable int mark){
        List<Student> s = studentService.getSmallerMark(mark);
        if(s!=null){
            return new ResponseEntity<>(s,HttpStatus.OK);
        }
        return new ResponseEntity<>(s,HttpStatus.INTERNAL_SERVER_ERROR);
    }

}