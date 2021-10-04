package com.internship.ems.controller;

import com.internship.ems.model.Salary;
import com.internship.ems.service.SalaryService;
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
public class SalaryController {
    @Autowired
    SalaryService service;

    @PostMapping("/addSalary")
    public Salary addSalary(@RequestBody Salary salary){

        return service.save(salary);
    }

    @GetMapping("/salary")
    public List<Salary> getAllSalary(){

        return service.getAll();
    }

    @GetMapping("/salary/{id}")
    public Salary getSalaryById(@PathVariable Long id){

        return service.getById(id);
    }



    @PutMapping("/updateSalary/{id}")
    public Salary updateSalary(@PathVariable Long id, @RequestBody Salary salaryInfo) {
        return service.updateSalary(id, salaryInfo);
    }

    @DeleteMapping("/deleteSalary/{id}")
    public ResponseEntity<HttpStatus> removeSalary(@PathVariable Long id){
        try {
            service.deleteSalary(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }
}
