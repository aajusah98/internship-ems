package com.internship.ems.controller;

import com.internship.ems.model.Project;
import com.internship.ems.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ProjectController {
    @Autowired
    ProjectService service;

    @PostMapping("/addProject")
    public ResponseEntity<Project> addProject(@Valid  @RequestBody Project project){
        Project serviceProject= service.save(project);
        return new ResponseEntity<>(serviceProject,HttpStatus.CREATED);
    }

    @GetMapping("/project")
    public List<Project> getAllProject(){

        return service.getAll();
    }

    @GetMapping("/project/{id}")
    public Project getProjectById(@PathVariable Long id){

        return service.getById(id);
    }



    @PutMapping("/updateProject/{id}")
    public Project updateProject(@PathVariable Long id, @RequestBody Project projectInfo) {
        return service.updateProject(id, projectInfo);
    }

    @DeleteMapping("/deleteProject/{id}")
    public ResponseEntity<HttpStatus> removeProject(@PathVariable Long id){

        try {
            service.deleteProject(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }
}
