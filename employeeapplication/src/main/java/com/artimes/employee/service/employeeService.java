package com.artimes.employee.service;

import com.artimes.employee.model.Employee;
import com.artimes.employee.model.EmployeeDTO;
import com.artimes.employee.model.EmployeeList;
import com.artimes.employee.repository.employeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class employeeService {

    @Autowired
   employeeRepository employeeRepository;

    public List<String> insertEmployeeRecord(EmployeeList employeeList){
        List<String> emailIds= new ArrayList<String>();
        for (Employee e : employeeList.getEmployeeList())
        {
            //System.out.println(e.toString());
            EmployeeDTO dto= new EmployeeDTO();
            if(employeeRepository.findByEmailId(e.getEmailId()) !=null){
                emailIds.add(e.getEmpName());
            }
            else{
                dto.setEmpName(e.getEmpName());
                dto.setEmpSalary(e.getEmpSalary());
                dto.setEmailId(e.getEmailId());
                employeeRepository.save(dto);
            }

        }

       return emailIds;
    }
}
