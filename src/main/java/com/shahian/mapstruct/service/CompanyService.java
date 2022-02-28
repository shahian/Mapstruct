package com.shahian.mapstruct.service;
import com.shahian.mapstruct.domain.Base.BaseDTO;
import com.shahian.mapstruct.domain.entity.Company;

public interface CompanyService  {
    BaseDTO getAllCompanies();

    BaseDTO getCompanyById(Long id);

    BaseDTO addCompany(Company company);

    BaseDTO updateCompany(Long id, Company company);

    BaseDTO deleteCompany(Long id);
}
