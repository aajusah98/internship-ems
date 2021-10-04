package com.internship.ems.service;

import com.internship.ems.dao.ProjectRepository;
import com.internship.ems.dao.SalaryRepository;
import com.internship.ems.dao.UserRepository;
import com.internship.ems.model.Project;
import com.internship.ems.model.Salary;
import com.internship.ems.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service

public class ProjectService {
    @Autowired
    private ProjectRepository projectRepo;

    public Project save(Project project){

        return projectRepo.save(project);
    }

    public List<Project> getAll() {
        List<Project> result = new ArrayList<>();
        projectRepo.findAll().forEach(result::add);
        return result;
    }
    public Project getById(long id) {

        return projectRepo.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public Project updateProject(long id, Project newProject) {
        Project project = projectRepo.findById(id).orElseThrow(EntityNotFoundException::new);
        project.setName(newProject.getName());
        project.setDescription(newProject.getDescription());
        projectRepo.save(project);
        return project;
    }



    public void deleteProject(Long id){

        projectRepo.deleteById(id);

    }
}
