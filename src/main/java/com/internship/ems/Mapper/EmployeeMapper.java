package com.internship.ems.Mapper;


import com.internship.ems.dto.EmployeeDto;

import com.internship.ems.model.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    List<EmployeeDto> modlesToDtos(List<Employee> employeeList);

    EmployeeDto modelToDto (Employee employee);

    Employee dtoToModel (EmployeeDto employeedto);

}
