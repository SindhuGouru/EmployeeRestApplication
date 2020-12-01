package com.artimes.employee.controller;

import com.artimes.employee.model.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @PostMapping("/employeeDetails")
//    @ResponseBody
    public ResponseEntity<String> employeeDetails(@RequestBody Employee employee){
        System.out.println("Employee Id : "+employee.getEmpId());
        System.out.println("Employee Name : "+employee.getEmpName());
        System.out.println("Employee Salary : "+employee.getEmpSalary());
      return new ResponseEntity<>("Employee created with status 201",HttpStatus.CREATED);
    }

}
