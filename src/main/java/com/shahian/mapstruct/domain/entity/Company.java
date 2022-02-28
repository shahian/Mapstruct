package com.shahian.mapstruct.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.experimental.SuperBuilder;
import com.shahian.mapstruct.domain.Base.BaseEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@SuperBuilder
@Entity
@Table(name = "Company")

@JsonIgnoreProperties(ignoreUnknown = true,value ={"projectProgres","exchangePortfolioChanges","exchangePortfolios"})

public class Company extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;
    @Column(name = "Name")
    private String  name;
    @Column(name = "Address")
    private String address;
    @Column(name = "Description")
    private String dscription;

    public Company(Boolean isDeleted, Date createDateTime, Date modifyDateTime, Long id, String name, String address, String dscription) {
        super(isDeleted, createDateTime, modifyDateTime);
        this.id = id;
        this.name = name;
        this.address = address;
        this.dscription = dscription;
    }

    public Company() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDscription() {
        return dscription;
    }

    public void setDscription(String dscription) {
        this.dscription = dscription;
    }




}
