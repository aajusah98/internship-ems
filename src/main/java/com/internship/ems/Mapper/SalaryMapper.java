package com.internship.ems.Mapper;

import com.internship.ems.dto.EmployeeDto;
import com.internship.ems.dto.SalaryDto;
import com.internship.ems.model.Employee;
import com.internship.ems.model.Salary;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SalaryMapper {

    SalaryMapper INSTANCE = Mappers.getMapper(SalaryMapper.class);

    List<SalaryDto> modlesToDtos(List<Salary> salaryList);

    SalaryDto modelToDto (Salary salary);

    Salary dtoToModel (SalaryDto salaryDto);

}
