package com.springtechie.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmployeeBonusDTO {

    private Integer id;
    private String name;
    private Double salary;
    private Double bonus;
    
}
