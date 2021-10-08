package com.internship.ems.controller;

import com.internship.ems.Mapper.DepartmentMapper;
import com.internship.ems.dao.DepartmentRepository;
import com.internship.ems.dto.DepartmentDto;
import com.internship.ems.model.*;
import com.internship.ems.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
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
public class DepartmentController {
    @Autowired
    DepartmentService service;

    @Autowired
    private DepartmentMapper departmentMapper;


    @PostMapping("/addDepartment")
    public ResponseEntity<DepartmentDto> save(@Valid @RequestBody DepartmentDto departmentDto){
           DepartmentDto departmentDto1= DepartmentMapper.INSTANCE.modelToDto( service.save(
                departmentMapper.dtoToModel(departmentDto)));
        return new ResponseEntity<>(departmentDto1, HttpStatus.CREATED);
    }

    @GetMapping("/department")
    public ResponseEntity <List <DepartmentDto> > getAllDepartment(){
        return new ResponseEntity<>(departmentMapper.modlesToDtos(service.getAll()),HttpStatus.OK);
    }


    @GetMapping("/department/{id}")
    public ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable Long id){

        return new ResponseEntity<>(departmentMapper.modelToDto(service.getById(id)),HttpStatus.OK);
    }





    @PutMapping("/updateDepartment/{id}")
    public ResponseEntity<Department> updateDepartment(@PathVariable Long id, @RequestBody  DepartmentDto departmentDto) {

        return new ResponseEntity<>(
                service.updateDepartment(id,
                        departmentMapper.dtoToModel(departmentDto)
                ), HttpStatus.OK);
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

//    @DeleteMapping("/deleteDepartment/{id}")
//    public ResponseEntity<DepartmentDto> removeDepartment(@PathVariable Long id){
//        return new ResponseEntity<Department>(service.deleteDepartment(id),HttpStatus.OK);
//    }

}
