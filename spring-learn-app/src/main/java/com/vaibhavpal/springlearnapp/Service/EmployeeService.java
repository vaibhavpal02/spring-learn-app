package com.vaibhavpal.springlearnapp.Service;

import com.vaibhavpal.springlearnapp.DTO.EmployeeDTO;
import com.vaibhavpal.springlearnapp.Entities.EmployeeEntity;
import com.vaibhavpal.springlearnapp.Respository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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

    public EmployeeDTO getemployeebyID(Long employeeId) {

        EmployeeEntity employeeEntity = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + employeeId));

        return modelMapper.map(employeeEntity, EmployeeDTO.class);
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

    public EmployeeDTO updateemployeebyID(Long employeeId, EmployeeDTO employeeDTO) {
        EmployeeEntity employeeEntity=modelMapper.map(employeeDTO,EmployeeEntity.class);
        employeeEntity.setId(employeeId);
        EmployeeEntity savedID=employeeRepository.save(employeeEntity);
        return modelMapper.map(savedID,EmployeeDTO.class);
    }

    public void deleteemployeeId(Long employeeId) {
        employeeRepository.deleteById(employeeId);

    }

    public EmployeeDTO updatepartialdetailsbyID(Long employeeId, Map<String, Object> updates) {

        EmployeeEntity employeeEntity = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + employeeId));

        updates.forEach((field, value) -> {
            Field fieldToBeUpdated = ReflectionUtils.findField(EmployeeEntity.class, field);


                fieldToBeUpdated.setAccessible(true);
                ReflectionUtils.setField(fieldToBeUpdated, employeeEntity, value);

        });

        EmployeeEntity saved = employeeRepository.save(employeeEntity);
        return modelMapper.map(saved, EmployeeDTO.class);
    }

}
