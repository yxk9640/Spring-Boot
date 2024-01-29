package com.example.restAPIdemo.repository;

import com.example.restAPIdemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


//JpaRepository has arg1 as Entity and arg2 as primary key
public interface EmployeeRepository extends JpaRepository<Employee, Long> {


}
