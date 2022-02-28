package com.shahian.mapstruct.service;

import com.shahian.mapstruct.domain.Base.BaseDTO;
import com.shahian.mapstruct.domain.DTO.EmployeeDTO;

public interface EmployeeService {
    BaseDTO getAllemployies();

    BaseDTO getemployeeById(Long id);

    BaseDTO addemployee(EmployeeDTO employeeDTO);

    BaseDTO updateemployee(Long id, EmployeeDTO employeeDTO);

    BaseDTO deleteemployee(Long id);
}
