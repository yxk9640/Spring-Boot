package com.example.restAPIdemo.controller;


import com.example.restAPIdemo.dto.EmployeeDTO;
import com.example.restAPIdemo.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@AllArgsConstructor
//convert to REST API
@RestController
//base URL
@RequestMapping("/api/employees")
public class EmployeeController {

    private EmployeeService employeeService;

//    Build Add Employee REST API
    @PostMapping
    public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody EmployeeDTO employeeDTO){
        EmployeeDTO savedEmployee = employeeService.createEmployee(employeeDTO);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

//    build get emp Rest API also add code in service implement
    @GetMapping("{id}")
    public ResponseEntity<EmployeeDTO> getElementById(@PathVariable("id") Long employeeId){
        EmployeeDTO employeeDTO = employeeService.getEmployeebyId(employeeId);
        return ResponseEntity.ok(employeeDTO);
    }

//    build delete emp Rest API also add code in service implement
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteElementById(@PathVariable("id") Long employeeId){
        employeeService.deleteElementbyId(employeeId);
        return ResponseEntity.ok("Deleted Successfully");
    }
}