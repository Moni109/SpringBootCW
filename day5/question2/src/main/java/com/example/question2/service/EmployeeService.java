package com.example.question2.service;

import org.springframework.stereotype.Service;

import com.example.question2.model.Employee;
import com.example.question2.repository.EmployeeRepo;

@Service
public class EmployeeService {
    private EmployeeRepo employeeRepo;
    public EmployeeService(EmployeeRepo employeeRepo){
        this.employeeRepo=employeeRepo;
    }

    public boolean saveEmployee(Employee employee){
        if(employee!=null){
            employeeRepo.save(employee);
            return true;
        }
        return false;

    } 
    
    public boolean updateEmployee(int id, Employee employee){
        boolean p = employeeRepo.existsById(id);
        if(p){
            employeeRepo.save(employee);
            return true;
        }
        return false;
    }

    public boolean deleteEmployee(int id){
        boolean p = employeeRepo.existsById(id);
        if(p){
            employeeRepo.deleteById(id);;
            return true;
        }
        return false;
    }
}

