package com.artimes.employee.controller;

import com.artimes.employee.model.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @PostMapping("/createEmployee")
//    @ResponseBody
    public ResponseEntity<String> createEmployee(@RequestBody Employee employee){
        System.out.println("Employee Id : " + employee.getEmpId());
        System.out.println("Employee Name : " + employee.getEmpName());
        System.out.println("Employee Salary : " + employee.getEmpSalary());
      return new ResponseEntity<>("Employee created successfully",HttpStatus.CREATED);
    }

}
