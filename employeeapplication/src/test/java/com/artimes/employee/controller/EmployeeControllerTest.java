package com.artimes.employee.controller;

import com.artimes.employee.model.Employee;
import com.artimes.employee.model.EmployeeList;
import com.artimes.employee.repository.EmployeeRepository;
import com.artimes.employee.service.EmployeeService;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


public class EmployeeControllerTest {

    private EmployeeRepository employeeRepository = Mockito.mock(EmployeeRepository.class);
    private EmployeeService employeeService =Mockito.mock(EmployeeService.class);

    @Test
    public void emailIdExsists(){
        Employee employee=new Employee("chinnu","chinnu@gmail.com",1000000);
        Employee employee1= new Employee("minnu","minnu@gmail.com",200000);
        List<Employee> empList = new ArrayList<>();
       empList.add(employee);
       empList.add(employee1);
        EmployeeList employeeList= new EmployeeList();
        employeeList.setEmployeeList(empList);
        List<String> emailIds=new ArrayList<>();
        for (Employee e: empList) {
            emailIds.add(e.getEmailId());
        }
        EmployeeController employeeController1=new EmployeeController(employeeService);
        when(employeeService.insertEmployeeRecord(any())).thenReturn(emailIds);
        ResponseEntity<String> status=employeeController1.createEmployee(employeeList);
       assertEquals(HttpStatus.CONFLICT,status.getStatusCode());
    }



}