package com.shahian.mapstruct.controller;

import com.shahian.mapstruct.domain.Base.BaseDTO;
import com.shahian.mapstruct.domain.entity.Company;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/company")
public class CompanyController extends BaseController {
    @GetMapping("/getAll")
    public ResponseEntity<?> getAllCompanies() {
        BaseDTO baseDTO = companyService.getAllCompanies();
        return new ResponseEntity<>(baseDTO, HttpStatus.OK);
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<?>getCompanyById(@PathVariable("id")Long id){
        BaseDTO baseDTO=companyService.getCompanyById(id);
        return new ResponseEntity<>(baseDTO,HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<?>addCompany(@RequestBody Company company){
        BaseDTO baseDTO=companyService.addCompany(company);
        return new ResponseEntity<>(baseDTO,HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?>updateCompany(@PathVariable("id")Long id,@RequestBody Company company){
        BaseDTO baseDTO=companyService.updateCompany(id,company);
        return new ResponseEntity<>(baseDTO,HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?>deleteCompany(@PathVariable("id")Long id){
        BaseDTO baseDTO=companyService.deleteCompany(id);
        return  new ResponseEntity<>(baseDTO,HttpStatus.OK);
    }
}
