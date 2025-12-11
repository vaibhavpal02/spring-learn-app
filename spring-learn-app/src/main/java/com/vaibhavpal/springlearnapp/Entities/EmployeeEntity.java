package com.vaibhavpal.springlearnapp.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Entity
@Table(name="employees")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeEntity
{
    @Id
    @GeneratedValue()
    private Long id;
    private String name;
    private String email;
    private Integer age;
    private LocalDate doj;
    private String role;
    private int Salary;
    private boolean isActive;

}

