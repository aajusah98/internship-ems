package com.internship.ems.model;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "department")
@Data
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long  departmentId;

    @NotNull
    @Size(min = 2,max = 10,message = "Name Should Be Grater Than 4 Char And Less Than 10")
    private String name;
    private String description;

    @PreRemove
    public void PreRemove(){
        System.out.println("Pre Removed "+this);
    }

    @PostRemove
    public  void PostRemove(){
        System.out.println("Post Removed "+this);
    }


}
