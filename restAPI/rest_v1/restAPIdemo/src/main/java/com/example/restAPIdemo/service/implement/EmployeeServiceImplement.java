package com.example.restAPIdemo.service.implement;

import com.example.restAPIdemo.dto.EmployeeDTO;
import com.example.restAPIdemo.entity.Employee;
import com.example.restAPIdemo.exception.ResourceNotFound;
import com.example.restAPIdemo.mapper.EmployeeMapper;
import com.example.restAPIdemo.repository.EmployeeRepository;
import com.example.restAPIdemo.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class EmployeeServiceImplement implements EmployeeService {

    private EmployeeRepository employeeRepository;
    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {

        Employee employee = EmployeeMapper.mapToEmployee(employeeDTO);
//        save to DB
        Employee savedEmployee = employeeRepository.save(employee);
//        send back to client
        return EmployeeMapper.mapToDto(savedEmployee);

    }

    @Override
    public EmployeeDTO getEmployeebyId(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(()-> new
                    ResourceNotFound("Not Employee with Id: "+employeeId));

        return EmployeeMapper.mapToDto(employee);
    }

    @Override
    public void deleteElementbyId(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(()-> new
                        ResourceNotFound("Not Employee with Id: "+employeeId) );

        employeeRepository.deleteById(employeeId);
    }


}
