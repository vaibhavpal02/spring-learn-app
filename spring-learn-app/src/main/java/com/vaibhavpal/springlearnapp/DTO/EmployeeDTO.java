package com.vaibhavpal.springlearnapp.DTO;

import java.time.LocalDate;

public class EmployeeDTO {
    private Long id;
    private String name;
    private String email;
    private Integer age;
    private LocalDate doj;
    private boolean isActive;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Integer getAge() {
        return age;
    }

    public LocalDate getDoj() {
        return doj;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setDoj(LocalDate doj) {
        this.doj = doj;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public EmployeeDTO()
    {

    }
    public EmployeeDTO(Long id, String name, String email, Integer age, LocalDate doj, boolean isActive) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
        this.doj = doj;
        this.isActive = isActive;
    }

}

