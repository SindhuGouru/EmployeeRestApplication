package com.artimes.employee.service;

import com.artimes.employee.model.Employee;
import com.artimes.employee.model.EmployeeDTO;
import com.artimes.employee.model.EmployeeList;
import com.artimes.employee.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }



    public List<String> insertEmployeeRecord(EmployeeList employeeList){
        List<String> emailIds= new ArrayList<String>();
        for (Employee e : employeeList.getEmployeeList())
        {
            //System.out.println(e.toString());
            EmployeeDTO dto= new EmployeeDTO();
            if(employeeRepository.findByEmailId(e.getEmailId()) !=null){
                emailIds.add(e.getEmpName());
            }
            else {
                dto.setEmpName(e.getEmpName());
                dto.setEmpSalary(e.getEmpSalary());
                dto.setEmailId(e.getEmailId());
                employeeRepository.save(dto);
            }

        }

       return emailIds;
    }

    public Optional<EmployeeDTO> getEmpById(Long empId){
       return employeeRepository.findById(empId);
    }

    public List<EmployeeDTO> getEmpByIds(List<Long> empId) {
        return employeeRepository.findByIds(empId);
    }
}
