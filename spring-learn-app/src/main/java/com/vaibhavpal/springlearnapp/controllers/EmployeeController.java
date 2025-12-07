package com.vaibhavpal.springlearnapp.controllers;

import com.vaibhavpal.springlearnapp.DTO.EmployeeDTO;
import com.vaibhavpal.springlearnapp.Entities.EmployeeEntity;
import com.vaibhavpal.springlearnapp.Service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/employees")
public class EmployeeController
{
    //This is simple Get Request to check the Server....
    @GetMapping(path="/getsecretMessage")
    public String getSecretMessage()
    {
        return "Hi....";
    }

    // Making Service Layer to bridge between Controllers and Repository return DTO
    // 1. Use C-DI for defining serviceLayer then injecting it.

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService)
    {
        this.employeeService=employeeService;
    }

    @GetMapping(path="/{employeeId}")
    public EmployeeDTO getemployeebyID(@PathVariable Long employeeID)
    {
        return employeeService.getemployeebyID(employeeID);
    }

    @GetMapping
    public List<EmployeeDTO> getallemployees(@RequestParam Integer age)
    {
        return employeeService.getallemployees();
    }


    @PostMapping
    public EmployeeDTO createEmployee(@RequestBody EmployeeDTO inputEmployee)
    {
        return employeeService.createEmployee(inputEmployee);
    }


}
