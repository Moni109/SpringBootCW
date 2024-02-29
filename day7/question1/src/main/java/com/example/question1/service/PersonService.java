package com.example.question1.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.question1.model.Person;
import com.example.question1.repository.PersonRepo;

@Service
public class PersonService {
    private PersonRepo personRepo;
    public PersonService(PersonRepo personRepo){
        this.personRepo=personRepo;
    }

    public Person postPerson(Person person){
        return personRepo.save(person);
    }

    public List<Person> getPerson(){
        return personRepo.findAll();
    }

    public List<Person> findAge(int age){
        return personRepo.findByAge(age);
    }

}
