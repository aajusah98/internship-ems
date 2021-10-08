package com.internship.ems.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;


@Entity
@Table(name = "salary")
@Data
public class Salary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long salaryId;

    @NotNull
    private LocalDate issueDate;

    @NotNull
    @Min(1000)
    private float amount;

    private float bonus;

    @OneToOne(mappedBy = "salary")
    @JsonManagedReference(value = "employee-salary")
    private Employee employee;
}
