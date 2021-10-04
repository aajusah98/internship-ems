package com.internship.ems.dao;

import com.internship.ems.model.Salary;
import org.springframework.data.repository.CrudRepository;

public interface SalaryRepository extends CrudRepository<Salary, Long> {
}
