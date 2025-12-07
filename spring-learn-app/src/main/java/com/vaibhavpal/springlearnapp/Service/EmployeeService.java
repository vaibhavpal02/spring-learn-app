package com.vaibhavpal.springlearnapp.Service;

import com.vaibhavpal.springlearnapp.DTO.EmployeeDTO;
import com.vaibhavpal.springlearnapp.Entities.EmployeeEntity;
import com.vaibhavpal.springlearnapp.Respository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService
{
    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;
    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper)
    {
        this.employeeRepository=employeeRepository;
        this.modelMapper = modelMapper;
    }

    public EmployeeDTO getemployeebyID(Long employeeID) {
        EmployeeEntity employeeEntity=employeeRepository.findById(employeeID).orElse(null);
        return modelMapper.map(employeeEntity,EmployeeDTO.class);
    }



    public EmployeeDTO createEmployee(EmployeeDTO inputEmployee)
    {
        EmployeeEntity toSavedEntity = modelMapper.map(inputEmployee, EmployeeEntity.class);
        EmployeeEntity savedEmployee = employeeRepository.save(toSavedEntity);
        return modelMapper.map(savedEmployee, EmployeeDTO.class);
    }

    public List<EmployeeDTO> getallemployees() {
        List<EmployeeEntity> entityList = employeeRepository.findAll();
        List<EmployeeDTO> dtoList = new ArrayList<>();

        for (EmployeeEntity emp : entityList) {
            EmployeeDTO dto = modelMapper.map(emp, EmployeeDTO.class);
            dtoList.add(dto);
        }

        return dtoList;
    }
}
