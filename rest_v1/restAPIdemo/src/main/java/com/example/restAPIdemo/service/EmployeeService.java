package com.example.restAPIdemo.service;

import com.example.restAPIdemo.dto.EmployeeDTO;

public interface EmployeeService {
    EmployeeDTO createEmployee(EmployeeDTO employeeDTO);
    EmployeeDTO getEmployeebyId(Long employeeId);
    void deleteElementbyId(Long employeeId);

}
