package com.artimes.employee.model;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeList {

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    private List<Employee> employeeList;
}
