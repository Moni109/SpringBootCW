package com.example.qustion2.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.qustion2.model.Student;
import com.example.qustion2.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
    private StudentService studentService;
    public StudentController(StudentService studentService){
        this.studentService=studentService;
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        if(studentService.postStudent(student)!=null){
            return new ResponseEntity<>(student, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(student,HttpStatus.NOT_FOUND);
    }
    
    @GetMapping 
    public ResponseEntity<List<Student>> getStudent(){
        if(studentService.getStudents()!=null){
            return new ResponseEntity<>(studentService.getStudents(), HttpStatus.OK);
        }
        return new ResponseEntity<>(studentService.getStudents(),HttpStatus.NOT_FOUND);
    }
    
    @GetMapping("/{id}") 
    public ResponseEntity<Student> getStudentById(@PathVariable long id){
        if(studentService.getById(id)!=null){
            return new ResponseEntity<>(studentService.getById(id), HttpStatus.OK);
        }
        return new ResponseEntity<>(studentService.getById(id),HttpStatus.NOT_FOUND);
    }
    
    @PutMapping("/{id}") 
    public ResponseEntity<Student> updateStudentById(@PathVariable long id,@RequestBody Student student){
        Student s=studentService.updateDetails(id, student);
        if(s!=null){
            return new ResponseEntity<>(s, HttpStatus.OK);
        }
        return new ResponseEntity<>(s,HttpStatus.NOT_FOUND);
    }
    
    @DeleteMapping("/{id}") 
    public ResponseEntity<String> deleteStudentById(@PathVariable long id){
        if(studentService.deleteDetails(id)==true){
            return new ResponseEntity<>("Deleted Student succesfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Student with ID"+id+"not found",HttpStatus.NOT_FOUND);
    }
}
