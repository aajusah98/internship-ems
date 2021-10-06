package com.internship.ems.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;


@Entity

@Table(name = "employee", uniqueConstraints= {@UniqueConstraint(columnNames={"email"})})
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long  employeeId;


    @NotNull
    @Size(min = 2,max = 10,message = "Name Should Be Grater Than 4 Char And Less Than 10")
    private String firstName;

    @NotNull
    @Size(min = 2,max = 10,message = "Name Should Be Grater Than 4 Char And Less Than 10")
    private String lastName;

    private String gender;

    @NotNull
    @Min(18)
    private int age;

    @NotNull
    @Size(min = 2,max = 100,message = "Name Should Be Grater Than 4 Char And Less Than 10")
    private String email;


    private String designation;


    private LocalDate hireDate;

    private LocalDate resignedDate;

    private String address;
}
