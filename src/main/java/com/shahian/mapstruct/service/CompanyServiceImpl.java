package com.shahian.mapstruct.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.shahian.mapstruct.domain.Base.BaseDTO;
import com.shahian.mapstruct.domain.Base.MetaDTO;
import com.shahian.mapstruct.domain.DTO.CompanyDTO;
import com.shahian.mapstruct.domain.entity.Company;
import com.shahian.mapstruct.exception.GlobalExceptionHandler;
import com.shahian.mapstruct.exception.ResourceNotFoundException;
import com.shahian.mapstruct.mapping.CompanyMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyServiceImpl extends BaseService implements CompanyService {
    @Override
    public BaseDTO getAllCompanies() {
        try {
            List<Company> companyList = new ArrayList<Company>();
            companyList = companyRepository.findAllByIsDeletedFalse();
            List<CompanyDTO> companyDTOS = objectMapper.convertValue(companyList, new TypeReference<List<CompanyDTO>>() {
            });
           // List<CompanyDTO> companyDTOS = CompanyMapper.Instance.toCompanyDTOs(companyList);
            return new BaseDTO(MetaDTO.getInstance(applicationProperties), companyDTOS);
        } catch (Exception ex) {
            throw new GlobalExceptionHandler(applicationProperties.getProperty("application.message.notfound.text"));
        }
    }

    @Override
    public BaseDTO getCompanyById(Long id) {
        try {
            Company company = companyRepository.getCompanyByIdAndIsDeletedFalse(id)
                    .orElseThrow(() -> new ResourceNotFoundException(applicationProperties.getProperty("application.message.notfound.text") + id));
            //CompanyDTO companyDTO = objectMapper.convertValue(company, CompanyDTO.class);
            CompanyDTO companyDTO = CompanyMapper.Instance.toCompanyDTO(company);
            return new BaseDTO(MetaDTO.getInstance(applicationProperties), companyDTO);

        } catch (Exception e) {
            throw new GlobalExceptionHandler(applicationProperties.getProperty("application.message.exceptionError.text"));
        }
    }

    @Override
    @Transactional
    public BaseDTO addCompany(Company company) {
        try {
            Company company1 = Company.builder()
                    .name(company.getName())
                    .address(company.getAddress())
                    .createDateTime(new Timestamp(System.currentTimeMillis()))
                    .modifyDateTime(new Timestamp(System.currentTimeMillis()))
                    .isDeleted(false)
                    .dscription(company.getDscription())
                    .build();
            companyRepository.save(company1);
            return new BaseDTO(MetaDTO.getInstance(applicationProperties), company1);
        } catch (Exception e) {
            throw new GlobalExceptionHandler(applicationProperties.getProperty("application.message.exceptionError.code"));
        }

    }

    @Override
    @Transactional
    public BaseDTO updateCompany(Long id, Company company) {
        Company companyOld = companyRepository.getCompanyByIdAndIsDeletedFalse(id)
                .orElseThrow(() -> new ResourceNotFoundException(applicationProperties.getProperty("application.message.notfound.text") + id));
        companyOld.setAddress(company.getAddress());
        companyOld.setDscription(company.getDscription());
        companyOld.setModifyDateTime(new Timestamp(System.currentTimeMillis()));
        companyRepository.save(companyOld);
        return new BaseDTO(MetaDTO.getInstance(applicationProperties), companyOld);
    }

    @Override
    public BaseDTO deleteCompany(Long id) {
        Company company = companyRepository.getCompanyByIdAndIsDeletedFalse(id)
                .orElseThrow(() -> new ResourceNotFoundException(applicationProperties.getProperty("application.message.notfound.text") + id));
        company.setIsDeleted(true);
        company.setModifyDateTime(new Timestamp(System.currentTimeMillis()));

        companyRepository.save(company);
        return new BaseDTO(MetaDTO.getInstance(applicationProperties), company);
    }


}
