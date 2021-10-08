package com.internship.ems.controller;

import com.internship.ems.Mapper.SalaryMapper;
import com.internship.ems.dto.DepartmentDto;
import com.internship.ems.dto.EmployeeDto;
import com.internship.ems.dto.SalaryDto;
import com.internship.ems.model.Department;
import com.internship.ems.model.Employee;
import com.internship.ems.model.Salary;
import com.internship.ems.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
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
public class SalaryController {
    @Autowired
    SalaryService service;

    @Autowired
    SalaryMapper salaryMapper;


    @PostMapping("/addSalary")
    public ResponseEntity<SalaryDto> saveSalary(@Valid @RequestBody SalaryDto salaryDto){
        SalaryDto salaryDtoSave = salaryMapper.modelToDto(service.save(salaryMapper.dtoToModel(salaryDto)));

        return new ResponseEntity<>(salaryDtoSave, HttpStatus.CREATED);
    }

    @GetMapping("/salary")
    public ResponseEntity <List <SalaryDto> > getAllSalary(){

        return new ResponseEntity<>(salaryMapper.modlesToDtos(service.getAll()),HttpStatus.OK);
    }

    @GetMapping("/salary/{id}")
    public ResponseEntity<SalaryDto> getSalaryById(@PathVariable Long id){

        return new ResponseEntity<>(salaryMapper.modelToDto(service.getById(id)),HttpStatus.OK);
    }


    @PutMapping("/updateSalary/{id}")
    public ResponseEntity<Salary> updateSalary(@PathVariable Long id, @RequestBody SalaryDto salaryDto) {
        return new ResponseEntity<>(
                service.updateSalary(id,
                        salaryMapper.dtoToModel(salaryDto)
                ), HttpStatus.OK);
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
