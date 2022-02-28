package com.shahian.mapstruct.repository;

import com.shahian.mapstruct.domain.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company,Long> {

    List<Company> findAllByIsDeletedFalse();
    Optional<Company> getCompanyByIdAndIsDeletedFalse(Long id);

}
