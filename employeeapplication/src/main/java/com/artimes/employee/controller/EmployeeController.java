package com.artimes.employee.controller;

import com.artimes.employee.model.EmployeeDTO;
import com.artimes.employee.model.EmployeeList;
import com.artimes.employee.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {


    public final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @PostMapping("/createEmployees")
    public ResponseEntity<String> createEmployee(@RequestBody EmployeeList employeeList){
       List<String> emailIds= employeeService.insertEmployeeRecord(employeeList);
        if (emailIds.size() > 0)

            return new ResponseEntity<>("The following employee are already present in system : \n"+ emailIds, HttpStatus.CONFLICT);
        else
            return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/getEmployeeById/{id}")
    public Optional<EmployeeDTO> getEmployeeById(@PathVariable(value="id") Long empId){
        return employeeService.getEmpById(empId);
    }

    @GetMapping("/getEmployeeByIds/{id}")
    public List<EmployeeDTO> getEmployeeByIds(@PathVariable(value="id") List<Long> empId){
        return employeeService.getEmpByIds(empId);
    }

}
