package com.springtechie.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "employee_details")
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer age;
}
