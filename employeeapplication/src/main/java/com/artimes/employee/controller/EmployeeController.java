package com.artimes.employee.controller;

import com.artimes.employee.model.Employee;
import com.artimes.employee.model.EmployeeDTO;
import com.artimes.employee.model.EmployeeList;
import com.artimes.employee.repository.employeeRepository;
import com.artimes.employee.service.employeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    employeeRepository employeeRepository;
    @Autowired
    employeeService employeeService;

    @PostMapping("/createEmployees")
    public ResponseEntity<String> createEmployee(@RequestBody EmployeeList employeeList){
       List<String> emailIds= employeeService.insertEmployeeRecord(employeeList);
        if (emailIds.size() > 0)

            return new ResponseEntity<>("The following employee are already present in system : \n"+ emailIds, HttpStatus.CONFLICT);
        else
            return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
