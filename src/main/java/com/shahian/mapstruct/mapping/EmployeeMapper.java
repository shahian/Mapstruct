package com.shahian.mapstruct.mapping;


import com.shahian.mapstruct.domain.DTO.CompanyDTO;
import com.shahian.mapstruct.domain.DTO.EmployeeDTO;
import com.shahian.mapstruct.domain.entity.Company;
import com.shahian.mapstruct.domain.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    EmployeeMapper Instance= Mappers.getMapper(EmployeeMapper.class);

    @Mapping(target = "username",ignore = true)
    @Mapping(target = "addreess",ignore = true)
    EmployeeDTO toEmployeeDTO(Employee employee);


    List<EmployeeDTO> toCEmployeeDTOs(List<Employee>employies);

    Employee toEmployee(EmployeeDTO employeeDTO);
}
