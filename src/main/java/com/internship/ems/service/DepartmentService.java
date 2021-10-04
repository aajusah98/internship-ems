package com.internship.ems.service;

import com.internship.ems.dao.DepartmentRepository;
import com.internship.ems.dao.ProjectRepository;
import com.internship.ems.dao.SalaryRepository;
import com.internship.ems.dao.UserRepository;
import com.internship.ems.model.Department;
import com.internship.ems.model.Project;
import com.internship.ems.model.Salary;
import com.internship.ems.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepo;

    public Department save(Department department){

        return departmentRepo.save(department);
    }

    public List<Department> getAll() {
        List<Department> result = new ArrayList<>();
        departmentRepo.findAll().forEach(result::add);
        return result;
    }
    public Department getById(long id) {

        return departmentRepo.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public Department updateDepartment(long id, Department newDepartment) {
       Department department = departmentRepo.findById(id).orElseThrow(EntityNotFoundException::new);
      department.setName(newDepartment.getName());
      department.setDescription(newDepartment.getDescription());
        departmentRepo.save(department);
        return department;
    }



    public void deleteDepartment(Long id){

        departmentRepo.deleteById(id);

    }
}
