package com.shahian.mapstruct.controller;

import com.shahian.mapstruct.domain.Base.BaseDTO;
import com.shahian.mapstruct.domain.DTO.EmployeeDTO;
import com.shahian.mapstruct.domain.entity.Company;
import com.shahian.mapstruct.domain.entity.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController extends BaseController{
    @GetMapping("/getAll")
    public ResponseEntity<?> getAllCompanies() {
        BaseDTO baseDTO = employeeService.getAllemployies();
        return new ResponseEntity<>(baseDTO, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?>getCompanyById(@PathVariable("id")Long id){
        BaseDTO baseDTO=employeeService.getemployeeById(id);
        return new ResponseEntity<>(baseDTO,HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<?>addCompany(@RequestBody EmployeeDTO employeeDTO){
        BaseDTO baseDTO=employeeService.addemployee(employeeDTO);
        return new ResponseEntity<>(baseDTO,HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?>updateCompany(@PathVariable("id")Long id,@RequestBody EmployeeDTO employeeDTO){
        BaseDTO baseDTO=employeeService.updateemployee(id,employeeDTO);
        return new ResponseEntity<>(baseDTO,HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?>deleteCompany(@PathVariable("id")Long id){
        BaseDTO baseDTO=employeeService.deleteemployee(id);
        return  new ResponseEntity<>(baseDTO,HttpStatus.OK);
    }
}
