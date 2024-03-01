package com.example.question1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.question1.model.Person;
import com.example.question1.repository.PersonRepository;

import jakarta.persistence.EntityNotFoundException;
 

@Service
public class PersonService {
    @Autowired
    public PersonRepository personRepository;

    public Person postDetails(Person person){
        return personRepository.save(person);
    }

    public List<Person> getDetails(){
      return personRepository.findAll();
    }

    public Person getById(long id){
        if (personRepository.existsById(id)) {
        return personRepository.findById(id).orElse(null);
    }
    throw new EntityNotFoundException("Person with id " + id + " not found");
    }


}
