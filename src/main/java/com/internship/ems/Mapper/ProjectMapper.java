package com.internship.ems.Mapper;

import com.internship.ems.dto.EmployeeDto;
import com.internship.ems.dto.ProjectDto;
import com.internship.ems.model.Employee;
import com.internship.ems.model.Project;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProjectMapper {
    ProjectMapper INSTANCE = Mappers.getMapper(ProjectMapper.class);

    List<ProjectDto> modlesToDtos(List<Project> projectList);

    ProjectDto modelToDto (Project project);

    Project dtoToModel (ProjectDto projectDto);
}
