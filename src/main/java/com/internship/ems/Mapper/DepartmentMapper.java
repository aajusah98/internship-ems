package com.internship.ems.Mapper;

import com.internship.ems.dto.DepartmentDto;
import com.internship.ems.model.Department;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {

    DepartmentMapper INSTANCE = Mappers.getMapper(DepartmentMapper.class);

    List<DepartmentDto> modlesToDtos(List<Department> departmentList);

    DepartmentDto modelToDto (Department department);

    Department dtoToModel (DepartmentDto departmentdto);

}
