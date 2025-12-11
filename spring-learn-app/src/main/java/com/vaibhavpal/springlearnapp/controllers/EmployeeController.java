package com.vaibhavpal.springlearnapp.controllers;

import com.vaibhavpal.springlearnapp.DTO.EmployeeDTO;
import com.vaibhavpal.springlearnapp.Entities.EmployeeEntity;
import com.vaibhavpal.springlearnapp.Service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

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

    @GetMapping("/{employeeId}")
    public EmployeeDTO getemployeebyID(@PathVariable Long employeeId) {
        return employeeService.getemployeebyID(employeeId);
    }

    @GetMapping
    public List<EmployeeDTO> getallemployees(@RequestParam Integer age)
    {
        return employeeService.getallemployees();
    }


    @PostMapping
    public EmployeeDTO createEmployee(@RequestBody @Valid EmployeeDTO inputEmployee)
    {
        return employeeService.createEmployee(inputEmployee);
    }

//    @ExceptionHandler(NoSuchElementException.class)
//    public String handleemployeefound(NoSuchElementException exception)
//    {
//         return "Employee not found";
//    }

    @PutMapping("/{employeeId}")
    public EmployeeDTO updateemployeebyID(@RequestBody EmployeeDTO employeeDTO,@PathVariable Long employeeId)
    {
        return employeeService.updateemployeebyID(employeeId,employeeDTO);
    }

    @DeleteMapping("/{employeeId}")
    public void deleteemployeeId(@PathVariable Long employeeId)
    {
        employeeService.deleteemployeeId(employeeId);
    }

    @PatchMapping("/{employeeId}")
    public EmployeeDTO updatepartialdetailsbyID(@RequestBody Map<String,Object> updates, @PathVariable Long employeeId)
    {
        return employeeService.updatepartialdetailsbyID(employeeId,updates);
    }
}
