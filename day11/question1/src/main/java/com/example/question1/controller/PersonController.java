package com.example.question1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.question1.model.Person;
import com.example.question1.service.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    public PersonService personService;

    @PostMapping
    public ResponseEntity<Person> createPerson(@RequestBody Person person){
        Person p = personService.postDetails(person);
        if(p!=null){
            return new ResponseEntity<>(p,HttpStatus.CREATED);
        }
        return new ResponseEntity<>(p,HttpStatus.INTERNAL_SERVER_ERROR);
        
    }
    
    @GetMapping("/persons")
    public ResponseEntity<List<Person>> getPerson(){
        List<Person> p = personService.getDetails();
        if(p!=null){
            return new ResponseEntity<>(p,HttpStatus.OK);
        }
        return new ResponseEntity<>(p,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/{personId}")
    public ResponseEntity<Person> getPersonById(@PathVariable long personId){
        Person p = personService.getById(personId);
        if(p!=null){
            return new ResponseEntity<>(p,HttpStatus.OK);
        }
        return new ResponseEntity<>(p,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
