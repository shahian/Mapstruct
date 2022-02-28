package com.shahian.mapstruct.controller;

import com.shahian.mapstruct.service.*;
import com.shahian.mapstruct.utility.ApplicationProperties;
import org.springframework.beans.factory.annotation.Autowired;


public class BaseController {

    @Autowired
    protected ApplicationProperties applicationProperties;
    @Autowired
    protected CompanyService companyService;
    @Autowired
    protected EmployeeService employeeService;



}
