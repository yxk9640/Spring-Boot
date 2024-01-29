package com.example.restAPIdemo.mapper;

import com.example.restAPIdemo.dto.EmployeeDTO;
import com.example.restAPIdemo.entity.Employee;

public class EmployeeMapper {

    public static EmployeeDTO mapToDto(Employee employee){
        return new EmployeeDTO(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail()
        );
    }

    public static Employee mapToEmployee(EmployeeDTO employeeDTO){
        return new Employee(
                employeeDTO.getId(),
                employeeDTO.getFirstName(),
                employeeDTO.getLastName(),
                employeeDTO.getEmail()
        );
    }
}
