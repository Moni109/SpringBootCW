package com.example.question1.controller;

import java.util.List;

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
    private PersonService personService;
    public PersonController(PersonService personService){
        this.personService=personService;
    }

    @PostMapping
    public ResponseEntity<Person> createPerson(@RequestBody Person person){
        if(personService.postPerson(person)!=null){
            return new ResponseEntity<>(person,HttpStatus.CREATED);
        }
        return new ResponseEntity<>(person,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/startsWithName/{value}")
    public ResponseEntity<List<Person>> getStartsNAme(@PathVariable String value){
        List<Person> p = personService.getByStartingName(value);
        if(p!=null){
            return new ResponseEntity<>(p,HttpStatus.OK);
        }
        return new ResponseEntity<>(p,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/endsWithName/{value}")
    public ResponseEntity<List<Person>> getEndName(@PathVariable String value){
        List<Person> p = personService.getByEndingName(value);
        if(p!=null){
            return new ResponseEntity<>(p,HttpStatus.OK);
        }
        return new ResponseEntity<>(p,HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
}
