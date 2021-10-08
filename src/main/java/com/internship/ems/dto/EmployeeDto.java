package com.internship.ems.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.internship.ems.enums.Gender;
import com.internship.ems.model.Department;
import com.internship.ems.model.Salary;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
public class EmployeeDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long  employeeId;


    @Column(nullable = false)
    private String firstName;

    @NotNull
    @Size(min = 2,max = 10,message = "Name Should Be Grater Than 4 Char And Less Than 10")
    private String lastName;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name="age",columnDefinition = "int default 24")
    private int age;

    @NotNull
    @Size(min = 2,max = 100,message = "Name Should Be Grater Than 4 Char And Less Than 10")
    private String email;


    private String designation;


    private LocalDate hireDate;

    private LocalDate resignedDate;

    private String address;


    @JsonBackReference(value = "employee-department")
    private Department department;


    @JsonBackReference(value = "employee-salary")
    public Salary salary;


}
