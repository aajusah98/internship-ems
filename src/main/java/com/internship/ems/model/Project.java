package com.internship.ems.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "project")
@Data
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ProjectId;

    @NotNull
    @Size(min = 2,max = 10,message = "Name Should Be Grater Than 4 Char And Less Than 10")
    private String name;
    private String description;

}
