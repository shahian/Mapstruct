package com.shahian.mapstruct.domain.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.shahian.mapstruct.domain.Base.BaseEntity;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CompanyDTO extends BaseEntity {
    private Long id;
    private String  name;
    private String address;
    private String dscription;

}
