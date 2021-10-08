package com.internship.ems.controller;

import com.internship.ems.Mapper.EmployeeMapper;
import com.internship.ems.Mapper.ProjectMapper;
import com.internship.ems.dto.EmployeeDto;
import com.internship.ems.dto.ProjectDto;
import com.internship.ems.model.Employee;
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

    @Autowired
    ProjectMapper projectMapper;


    @PostMapping("/addProject")
    public ResponseEntity<ProjectDto> addProject(@Valid  @RequestBody ProjectDto projectDto){
        ProjectDto projectDto1= ProjectMapper.INSTANCE.modelToDto(service.save(projectMapper.dtoToModel(projectDto)));
        return new ResponseEntity<>(projectDto1,HttpStatus.CREATED);
    }

    @GetMapping("/project")
    public ResponseEntity <List  <ProjectDto> > getAllProject(){
        return new ResponseEntity<>(projectMapper.modlesToDtos(service.getAll()),HttpStatus.OK);
    }

    @GetMapping("/project/{id}")
    public ResponseEntity<ProjectDto> getProjectById(@PathVariable Long id){

        return new ResponseEntity<>(projectMapper.modelToDto(service.getById(id)),HttpStatus.OK);
    }



    @PutMapping("/updateProject/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody ProjectDto projectDto) {
        return new ResponseEntity (
                service.updateProject(id,
                        projectMapper.dtoToModel(projectDto)
                ), HttpStatus.OK);
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
