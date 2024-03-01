package com.example.qustion2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.qustion2.model.Student;
import com.example.qustion2.model.StudentIDCard;
import com.example.qustion2.repository.StudentIDRepository;
import com.example.qustion2.repository.StudentRepository;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final StudentIDRepository studentIDRepository;

    public StudentService(StudentRepository studentRepository, StudentIDRepository studentIDRepository) {
        this.studentRepository = studentRepository;
        this.studentIDRepository = studentIDRepository;
    }


    public Student postStudent(Student student){
        StudentIDCard studentID=student.getStudentIDCard();
        studentIDRepository.save(studentID);
        return studentRepository.save(student);
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public Student getById(long id){
        return studentRepository.findById(id).orElse(null);
    }

    public Student updateDetails(long id, Student student){
        Optional<Student> optionalStudent = studentRepository.findById(id);
    
    if (optionalStudent.isPresent()) {
        Student existingStudent = optionalStudent.get();

        existingStudent.setName(student.getName());
        existingStudent.setId(id);
        existingStudent.setStudentIDCard(student.getStudentIDCard());
        return studentRepository.save(existingStudent);
    } else {
        return null;
    }
    }   

    public boolean deleteDetails(long id){
        if(studentRepository.existsById(id)){
            return true;
        }
        return false;
    }

}
