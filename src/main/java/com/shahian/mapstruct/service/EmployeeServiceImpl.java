package com.shahian.mapstruct.service;

import com.shahian.mapstruct.domain.Base.BaseDTO;
import com.shahian.mapstruct.domain.Base.MetaDTO;
import com.shahian.mapstruct.domain.DTO.EmployeeDTO;
import com.shahian.mapstruct.domain.entity.Employee;
import com.shahian.mapstruct.exception.GlobalExceptionHandler;
import com.shahian.mapstruct.exception.ResourceNotFoundException;
import com.shahian.mapstruct.mapping.EmployeeMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
@Service
public class EmployeeServiceImpl extends BaseService implements EmployeeService {
    @Override
    public BaseDTO getAllemployies() {

        try {
            List<Employee> employeeList = new ArrayList<Employee>();
            employeeList = employeeRepository.findAllByIsDeletedFalse();
             List<EmployeeDTO> employeeDTOs = EmployeeMapper.Instance.toCEmployeeDTOs(employeeList);
            return new BaseDTO(MetaDTO.getInstance(applicationProperties), employeeDTOs);
        } catch (Exception ex) {
            throw new GlobalExceptionHandler(applicationProperties.getProperty("application.message.notfound.text"));
        }
    }

    @Override
    public BaseDTO getemployeeById(Long id) {
        try {
            Employee employee = employeeRepository.getEmployeeByIdAndIsDeletedFalse(id)
                    .orElseThrow(() -> new ResourceNotFoundException(applicationProperties.getProperty("application.message.notfound.text") + id));
            EmployeeDTO employeeDTO = EmployeeMapper.Instance.toEmployeeDTO(employee);
            return new BaseDTO(MetaDTO.getInstance(applicationProperties), employeeDTO);

        } catch (Exception e) {
            throw new GlobalExceptionHandler(applicationProperties.getProperty("application.message.exceptionError.text"));
        }
    }

    @Override
    @Transactional
    public BaseDTO addemployee(EmployeeDTO employeeDTO) {
        try {
            Employee employee = Employee.builder()
                    .firstName(employeeDTO.getFirstName())
                    .lastName(employeeDTO.getLastName())
                    .username(employeeDTO.getUsername())
                    .mobileNumber(employeeDTO.getMobileNumber())
                    .addreess(employeeDTO.getAddreess())
                    .nationalCode(employeeDTO.getNationalCode())
                    .createDateTime(new Timestamp(System.currentTimeMillis()))
                    .modifyDateTime(new Timestamp(System.currentTimeMillis()))
                    .isDeleted(false)
                    .build();
            employeeRepository.save(employee);
            return new BaseDTO(MetaDTO.getInstance(applicationProperties), employee);
        } catch (Exception e) {
            throw new GlobalExceptionHandler(applicationProperties.getProperty("application.message.exceptionError.code"));
        }
    }

    @Override
    @Transactional
    public BaseDTO updateemployee(Long id, EmployeeDTO employeeDTO) {
        Employee employee = employeeRepository.getEmployeeByIdAndIsDeletedFalse(id)
                .orElseThrow(() -> new ResourceNotFoundException(applicationProperties.getProperty("application.message.notfound.text") + id));
        employee.setUsername(employeeDTO.getUsername());
        employee.setFirstName(employeeDTO.getFirstName());
        employee.setLastName(employeeDTO.getLastName());
        employee.setAddreess(employeeDTO.getAddreess());
        employee.setMobileNumber(employeeDTO.getMobileNumber());
        employee.setNationalCode(employeeDTO.getNationalCode());
        employee.setModifyDateTime(new Timestamp(System.currentTimeMillis()));
        employeeRepository.save(employee);
        return new BaseDTO(MetaDTO.getInstance(applicationProperties), employee);
    }

    @Override
    public BaseDTO deleteemployee(Long id) {
        Employee employee = employeeRepository.getEmployeeByIdAndIsDeletedFalse(id)
                .orElseThrow(() -> new ResourceNotFoundException(applicationProperties.getProperty("application.message.notfound.text") + id));
        employee.setIsDeleted(true);
        employee.setModifyDateTime(new Timestamp(System.currentTimeMillis()));

        employeeRepository.save(employee);
        return new BaseDTO(MetaDTO.getInstance(applicationProperties), employee);
    }
}
