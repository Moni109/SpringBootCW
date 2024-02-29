package com.example.question1.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.question1.model.Person;
import com.example.question1.repository.PersonRepo;

@Service
public class PersonService {
      @Autowired
    private PersonRepo personRepo;

    public Person addPerson(Person person) {
        return personRepo.save(person);
    }

    public List<Person> getPersonByAge(int age) {
        return personRepo.findByAge(age);
   }

}
