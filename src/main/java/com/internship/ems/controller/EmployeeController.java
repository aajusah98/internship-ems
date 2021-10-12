package com.internship.ems.controller;

import com.internship.ems.Mapper.EmployeeMapper;
import com.internship.ems.dto.EmployeeDto;
import com.internship.ems.enums.Gender;
import com.internship.ems.model.Employee;
import com.internship.ems.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.transaction.Transactional;
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

    @GetMapping("/employeesByGender/{gender}")
    public List<EmployeeDto> getEmployeeByGender(@PathVariable Gender gender){

        return  employeeMapper.modlesToDtos(service.getEmployeeByGender(gender));
    }


    @GetMapping("/employeeByFirstName/{firstName}")
    public List<EmployeeDto> findEmployeeByFirstName(@PathVariable String firstName){
        return employeeMapper.modlesToDtos(service.getEmployeeByFirstName(firstName));
    }

    @GetMapping("/employeeByGenderAndAge/{gender}&{age}")
    public List<EmployeeDto> findEmployeeByGenderAndAge(@PathVariable Gender gender, @PathVariable int age){
        return employeeMapper.modlesToDtos(service.getEmployeeByGenderAndAge(gender, age));
    }

    @Transactional
    @PutMapping("/updateEmployeeAgeById/{id}&{age}")
    public String updateEmployeeAgeById(@PathVariable Long id, @PathVariable int age){
        return service.updateById(id, age);
    }

    @Transactional
    @DeleteMapping("/deleteEmployeeById/{id}")
    public String  deleteEmployeeById(@PathVariable Long id){
        return service.deleteEmployeeById(id);
    }



    @GetMapping("/custom/employees/namedQuery")
    public List<EmployeeDto> getEmployeeByNamedQuery(@RequestParam("departmentId") Long departmentId) {
        return employeeMapper.modlesToDtos(service.getByNamedQuery(departmentId));
    }

    @GetMapping("/custom/employees/typedQuery")
    public List<EmployeeDto> getEmployeeByTypedQuery(@RequestParam("departmentId") Long departmentId) {
        return employeeMapper.modlesToDtos(service.getByTypedQuery(departmentId));
    }

    @GetMapping("/custom/employees/criteriaApi")
    public List<EmployeeDto> getEmployeeByJpql(@RequestParam("amount") float amount, @RequestParam("bonus") float bonus) {
        return employeeMapper.modlesToDtos(service.getByCriteriaApi(amount, bonus));
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
