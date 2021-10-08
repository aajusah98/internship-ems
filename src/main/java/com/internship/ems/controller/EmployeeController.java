package com.internship.ems.controller;

import com.internship.ems.Mapper.EmployeeMapper;
import com.internship.ems.dto.EmployeeDto;
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


import javax.validation.Valid;
import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService service;

    @Autowired
    EmployeeMapper employeeMapper;





    @PostMapping("/addEmployee")
    public ResponseEntity<EmployeeDto> addEmployee(@Valid @RequestBody EmployeeDto employeeDtoDto){
       EmployeeDto employeeDto= EmployeeMapper.INSTANCE.modelToDto( service.save(employeeMapper.dtoToModel(employeeDtoDto)));
        return new ResponseEntity<EmployeeDto>(employeeDto,HttpStatus.CREATED);
    }

    @GetMapping("/employee")
    public ResponseEntity <List <EmployeeDto> > getAllEmployee(){

        return new ResponseEntity<>(employeeMapper.modlesToDtos(service.getAll()),HttpStatus.OK);
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long id){

        return new ResponseEntity<>(employeeMapper.modelToDto(service.getById(id)),HttpStatus.OK);
    }


    @PutMapping("/updateEmployee/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody EmployeeDto employeeDto) {
        return new ResponseEntity<>(
                service.updateEmployee(id,
                        employeeMapper.dtoToModel(employeeDto)
                ), HttpStatus.OK);
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
