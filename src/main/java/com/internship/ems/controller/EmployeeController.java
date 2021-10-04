package com.internship.ems.controller;

import com.internship.ems.model.Employee;
import com.internship.ems.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService service;

    @PostMapping("/addEmployee")
    public Employee addEmployee(@RequestBody Employee employee){

        return service.save(employee);
    }

    @GetMapping("/employee")
    public List<Employee> getAllEmployee(){

        return service.getAll();
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployeeById(@PathVariable Long id){

        return service.getById(id);
    }



    @PutMapping("/updateEmployee/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employeeInfo) {
        return service.updateEmployee(id, employeeInfo);
    }

    @DeleteMapping("/deleteEmployee/{id}")
    public ResponseEntity<HttpStatus> removeEmployee(@PathVariable Long id){

        try {
            service.deleteEmployee(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
