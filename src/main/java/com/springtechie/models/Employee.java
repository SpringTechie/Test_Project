package com.springtechie.models;

import jakarta.persistence.*;

@Entity
@Table(name = "employee_details")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    @Column(name = "full_name")
    String name;
    int age;

}
