package com.internship.ems.service;

import com.internship.ems.dao.EmployeeDao;
import com.internship.ems.dao.EmployeeRepository;
import com.internship.ems.dto.EmployeeDto;
import com.internship.ems.enums.Gender;
import com.internship.ems.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepo;

    @Autowired
    private EmployeeDao employeeDao;

    public Employee save(Employee employee){

        return employeeRepo.save(employee);
    }

    public List<Employee> getAll() {
        List<Employee> result = new ArrayList<>();
        employeeRepo.findAll().forEach(result::add);
        return result;
    }
    public Employee getById(long id) {

        return employeeRepo.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public Employee updateEmployee(long id, Employee newEmployee) {
      Employee employee = employeeRepo.findById(id).orElseThrow(EntityNotFoundException::new);
        employee.setFirstName(newEmployee.getFirstName());
        employee.setLastName(newEmployee.getLastName());
        employee.setGender(newEmployee.getGender());
        employee.setAge(newEmployee.getAge());
        employee.setEmail(newEmployee.getEmail());
        employee.setDesignation(newEmployee.getDesignation());
        employee.setHireDate(newEmployee.getHireDate());
        employee.setResignedDate(newEmployee.getResignedDate());
        employee.setAddress(newEmployee.getAddress());
      employeeRepo.save(employee);
        return employee;
    }



    public void deleteEmployee(Long id){
       employeeRepo.deleteById(id);
    }

    public List<Employee> getEmployeeByGender(Gender gender){
        return  employeeRepo.getEmployeeByGender(gender);
    }

    public List<Employee> getEmployeeByFirstName(String firstName){

        return employeeRepo.getUserByFirstName(firstName);
    }

    public List<Employee> getEmployeeByGenderAndAge(Gender gender, int age){

        return employeeRepo.getEmployeeByGenderAndAge(gender, age);
    }

    public String updateById(Long id, int age){
        employeeRepo.updateEmployeeById(id, age);
        return "Age of id: "+id+" updated";
    }

    public String deleteEmployeeById(Long id){
        employeeRepo.deleteEmployeeById(id);

        return "ID: "+id+" Deleted";
    }

    public List<Employee> getByNamedQuery(Long departmentId) {
        return employeeDao.getEmployeeByNamedQuery(departmentId);
    }

    public List<Employee> getByTypedQuery(Long departmentId) {
        return employeeDao.getEmployeeByTypedQuery(departmentId);
    }

    public List<Employee> getByCriteriaApi(float amount, float bonus) {
        return employeeDao.getEmployee(amount, bonus);
    }

}
