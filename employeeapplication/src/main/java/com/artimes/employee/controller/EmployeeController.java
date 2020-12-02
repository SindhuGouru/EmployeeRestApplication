package com.artimes.employee.controller;

import com.artimes.employee.model.Employee;
import com.artimes.employee.model.EmployeeList;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    @PostMapping("/createEmployees")
    public ResponseEntity<String> createEmployees(@RequestBody EmployeeList employeeList){
       for(Employee e : employeeList.getEmployeeList()) {
           System.out.println(e.toString());
       }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
