package com.internship.ems.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;


@Entity
@Table(name = "employee")
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long  employeeId;



    private String firstName;

    private String lastName;

    private String gender;

    private int age;


    private String email;


    private String designation;


    private LocalDate hireDate;

    private LocalDate resignedDate;

    private String address;
}
