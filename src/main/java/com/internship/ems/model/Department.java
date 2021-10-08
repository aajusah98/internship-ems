package com.internship.ems.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Entity(name = "department")
@Table(name = "department")
@Data
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_id",unique = true,nullable = false)
    private long  departmentId;
    private String name;
    private String description;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "department",  fetch = FetchType.LAZY)
    @JsonManagedReference(value =  "employee-department")
    private List<Employee> employee;


    @PreRemove
    public void PreRemove(){
        System.out.println("Pre Removed "+this);
    }

    @PostRemove
    public  void PostRemove(){
        System.out.println("Post Removed "+this);
    }



}
