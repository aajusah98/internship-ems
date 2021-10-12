package com.internship.ems.dao;

import com.internship.ems.enums.Gender;
import com.internship.ems.model.Employee;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    List<Employee> getEmployeeByGender(Gender gender);


    @Query(value = "SELECT * FROM  employee WHERE first_name=:name", nativeQuery = true)
    List<Employee> getUserByFirstName( @Param("name") String firstName);

    @Query("SELECT e FROM employee e WHERE e.gender =?1 AND e.age =?2")
    List<Employee> getEmployeeByGenderAndAge(Gender gender, int age);

    @Modifying
    @Query("UPDATE employee  e SET e.age=:age WHERE e.employeeId=:employeeId")
    void updateEmployeeById(@Param("employeeId") Long employeeId, @Param("age") int age);

    @Modifying
    @Query("DELETE from employee e WHERE e.employeeId=:employeeId")
    void deleteEmployeeById(@Param("employeeId") Long employeeId);

}
