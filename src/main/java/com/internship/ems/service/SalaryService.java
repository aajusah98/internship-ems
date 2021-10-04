package com.internship.ems.service;

import com.internship.ems.dao.SalaryRepository;
import com.internship.ems.dao.UserRepository;
import com.internship.ems.model.Salary;
import com.internship.ems.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class SalaryService {
    @Autowired
    private SalaryRepository salaryRepo;

    public Salary save(Salary salary){

        return salaryRepo.save(salary);
    }

    public List<Salary> getAll() {
        List<Salary> result = new ArrayList<>();
        salaryRepo.findAll().forEach(result::add);
        return result;
    }
    public Salary getById(long id) {

        return salaryRepo.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public Salary updateSalary(long id, Salary newSalary) {
        Salary salary = salaryRepo.findById(id).orElseThrow(EntityNotFoundException::new);
        salary.setIssueDate(newSalary.getIssueDate());
        salary.setAmount(newSalary.getAmount());
        salary.setBonus(newSalary.getBonus());
        salaryRepo.save(salary);
        return salary;
    }



    public void deleteSalary(Long id){

        salaryRepo.deleteById(id);

    }
}
