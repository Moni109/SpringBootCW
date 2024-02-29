package com.example.question2.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.question2.model.Employee;
import com.example.question2.service.EmployeeService;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    private EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService){
        this.employeeService=employeeService;
    }

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
        boolean pro = employeeService.saveEmployee(employee);
        if(!pro){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(employee,HttpStatus.CREATED);
    }

    @PutMapping("{employeeId}")
    public ResponseEntity<Employee> updateEmployeeid(@PathVariable ("employeeId") int id, @RequestBody Employee employee){
        if(employeeService.updateEmployee(id,employee)){
            return new ResponseEntity<>(employee,HttpStatus.OK);
        }
        return new ResponseEntity<>(employee,HttpStatus.NOT_FOUND);
    }
    
    @DeleteMapping("{employeeId}")
    public ResponseEntity<Boolean> deleteEmployeebyid(@PathVariable ("employeeId") int id){
        if(employeeService.deleteEmployee(id)){
            return new ResponseEntity<>(true,HttpStatus.OK);
        }
        return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
    }
}
