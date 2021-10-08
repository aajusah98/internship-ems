package com.internship.ems.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.internship.ems.model.Employee;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class SalaryDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long salaryId;

    @NotNull
    private LocalDate issueDate;

    @NotNull
    @Min(1000)
    private float amount;

    private float bonus;

    private Employee employee;

}
