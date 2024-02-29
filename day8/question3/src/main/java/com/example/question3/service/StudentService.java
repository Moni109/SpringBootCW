package com.example.question3.service;
import java.util.List;
import org.springframework.stereotype.Service;

import com.example.question3.model.Student;
import com.example.question3.repository.StudentRepo;

@Service
public class StudentService {
    private StudentRepo studentRepo;
    public StudentService(StudentRepo studentRepo){
        this.studentRepo=studentRepo;
    }

    public Student savedStudents(Student student){
        return studentRepo.save(student);
    }

    public List<Student> getGreaterMark(int mark){
        return studentRepo.findByMarksGreaterThan(mark);
    }
    
    public List<Student> getSmallerMark(int mark){
        return studentRepo.findByMarksLessThan(mark);
    }

}
