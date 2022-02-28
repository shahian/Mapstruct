package com.shahian.mapstruct.mapping;

import com.shahian.mapstruct.domain.DTO.CompanyDTO;
import com.shahian.mapstruct.domain.entity.Company;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CompanyMapper {

    CompanyMapper Instance= Mappers.getMapper(CompanyMapper.class);

    CompanyDTO toCompanyDTO(Company company);


    List<CompanyDTO>toCompanyDTOs(List<Company>companies);

    Company toCompany(CompanyDTO companyDTO);
}
