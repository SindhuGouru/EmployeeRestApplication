package com.artimes.employee.repository;

import com.artimes.employee.model.EmployeeDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeDTO, Long> {

    public EmployeeDTO findByEmailId(String emailId);
}
