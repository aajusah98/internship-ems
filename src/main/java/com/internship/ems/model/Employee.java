package com.internship.ems.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.internship.ems.enums.Gender;
import lombok.Data;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Set;


@Entity(name = "employee")
@Table(name = "employee", uniqueConstraints= {@UniqueConstraint(columnNames={"email"}), @UniqueConstraint(columnNames = {"employee_id"}) })
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id",unique = true,nullable = false)
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

    @ManyToOne
    @JoinColumn(name = "departmentId")
    @JsonBackReference(value = "employee-department")
    private Department department;

    @OneToOne
    @JoinColumn(name = "salaryId")
    @JsonBackReference(value = "employee-salary")
    public Salary salary;

    @PrePersist
    public void PrePersist(){
        ZoneId defaultZoneId = ZoneId.systemDefault();
        LocalDate localDate = LocalDate.now();
        this.setHireDate(localDate.atStartOfDay(defaultZoneId).toLocalDate());
    }


}
