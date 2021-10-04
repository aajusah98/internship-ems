package com.internship.ems.model;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name = "department")
@Data

public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long  departmentId;

    @NotBlank(message = "Name is mandatory")
    private String name;
    private String description;
}
