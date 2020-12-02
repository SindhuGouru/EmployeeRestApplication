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

    @PostMapping("/createEmployee")
//    @ResponseBody
    public ResponseEntity<String> createEmployee(@RequestBody Employee employee){
        System.out.println("Employee Id : " + employee.getEmpId());
        System.out.println("Employee Name : " + employee.getEmpName());
        System.out.println("Employee Salary : " + employee.getEmpSalary());
      return new ResponseEntity<>("Employee created successfully",HttpStatus.CREATED);
    }

    @PostMapping("/createEmployeeList")
    public ResponseEntity<String> createEmployeeList(@RequestBody EmployeeList employeeList){
       for(int i=0;i<employeeList.getEmployeeList().size();i++) {
           System.out.println(employeeList.getEmployeeList().get(i).getEmpId());
           System.out.println(employeeList.getEmployeeList().get(i).getEmpName());
           System.out.println(employeeList.getEmployeeList().get(i).getEmpSalary());
       }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
