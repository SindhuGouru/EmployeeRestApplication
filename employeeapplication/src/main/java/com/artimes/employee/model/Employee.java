package com.artimes.employee.model;

import java.io.Serializable;


public class Employee implements Serializable {

    private String empName;
    private String emailId;
    private int empSalary;

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }


    public int getEmpSalary() {
        return empSalary;
    }

    public void setEmpSalary(int empSalary) {
        this.empSalary = empSalary;
    }

    public Employee(String empName, String emailId, int empSalary) {
        this.empName = empName;
        this.emailId = emailId;
        this.empSalary = empSalary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empName='" + empName + '\'' +
                ", emailId='" + emailId + '\'' +
                ", empSalary=" + empSalary +
                '}';
    }
}
