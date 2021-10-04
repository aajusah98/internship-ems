package com.internship.ems.controller;

import com.internship.ems.model.*;
import com.internship.ems.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DepartmentController {
    @Autowired
    DepartmentService service;

    @PostMapping("/addDepartment")
    public Department addDepartment(@Valid @RequestBody Department department){

        return service.save(department);
    }

    @GetMapping("/department")
    public List<Department> getAllDepartment(){

        return service.getAll();
    }

    @GetMapping("/department/{id}")
    public Department getDepartmentById(@PathVariable Long id){

        return service.getById(id);
    }



    @PutMapping("/updateDepartment/{id}")
    public Department updateDepartment(@PathVariable Long id, @RequestBody Department departmentInfo) {
        return service.updateDepartment(id, departmentInfo);
    }

    @DeleteMapping("/deleteDepartment/{id}")
    public ResponseEntity<HttpStatus> removeDepartment(@PathVariable Long id){
        try {
            service.deleteDepartment(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
