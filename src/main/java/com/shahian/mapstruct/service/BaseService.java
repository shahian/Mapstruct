package com.shahian.mapstruct.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shahian.mapstruct.repository.*;
import com.shahian.mapstruct.utility.ApplicationProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public abstract class BaseService {
    @Autowired
    protected ApplicationProperties applicationProperties;
    @Autowired
    protected ObjectMapper objectMapper;
    @Autowired
    protected CompanyRepository companyRepository;
    @Autowired
    protected EmployeeRepository employeeRepository;






}
