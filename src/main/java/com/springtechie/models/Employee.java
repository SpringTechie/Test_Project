package com.springtechie.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "employee_details")
@Data
public class Employee {
    @Id
    int id;
    String name;
    int age;
}
