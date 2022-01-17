package com.codingconcept.repository;

import com.codingconcept.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    Employee findByEmployeeName(String name);
}
