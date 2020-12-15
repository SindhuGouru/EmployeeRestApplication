package com.artimes.employee.repository;

import com.artimes.employee.model.EmployeeDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeDTO, Long> {

    public EmployeeDTO findByEmailId(String emailId);

    @Query(value="select * from employee_details where emp_Id IN (:empId)",nativeQuery=true)
    public List<EmployeeDTO> findByIds(@Param("empId") List<Long> empId);
}
