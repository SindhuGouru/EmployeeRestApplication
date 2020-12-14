package com.artimes.employee.service;

import com.artimes.employee.model.Employee;
import com.artimes.employee.model.EmployeeDTO;
import com.artimes.employee.model.EmployeeList;
import com.artimes.employee.repository.EmployeeRepository;
import com.artimes.employee.service.EmployeeService;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class EmployeeServiceTest {

    private EmployeeRepository employeeRepository = Mockito.mock(EmployeeRepository.class);


    @Test
    public void noEmployeeExists(){

        Employee employee=new Employee("chinnu","chinnu@gmail.com",1000000);
        Employee employee1= new Employee("minnu","minnu@gmail.com",200000);
        List<Employee> empList = new ArrayList<>();
        empList.add(employee);
        empList.add(employee1);
        EmployeeList employeeList= new EmployeeList();
        employeeList.setEmployeeList(empList);
        EmployeeService employeeService= new EmployeeService(employeeRepository);
        when(employeeRepository.findByEmailId(any())).thenReturn(null);
        List<String> emailIds=employeeService.insertEmployeeRecord(employeeList);
        verify(employeeRepository, times(2)).save(any());
        assertEquals(0,emailIds.size());
        
    }

    @Test
    public void employeeExists(){
        Employee employee=new Employee("Sindhu","sindhugouru@gmail.com",1000000);
        Employee employee1= new Employee("Avyuth","Avyuthelluri@gmail.com",200000);
        List<Employee> empList = new ArrayList<>();
        empList.add(employee);
        empList.add(employee1);
        EmployeeList employeeList= new EmployeeList();
        employeeList.setEmployeeList(empList);
        EmployeeDTO employeeDTO = new EmployeeDTO();
        EmployeeService employeeService= new EmployeeService(employeeRepository);
        when(employeeRepository.findByEmailId(any())).thenReturn(employeeDTO);
        List<String> emailIds=employeeService.insertEmployeeRecord(employeeList);
        verify(employeeRepository, times(0)).save(any());
        assertEquals(2,emailIds.size());
    }

}