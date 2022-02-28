package com.shahian.mapstruct.domain.DTO;

import lombok.*;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class EmployeeDTO {
    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private String mobileNumber;
    private String addreess;
    private String nationalCode;
}
