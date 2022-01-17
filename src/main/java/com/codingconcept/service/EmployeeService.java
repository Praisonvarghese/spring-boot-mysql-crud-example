package com.codingconcept.service;

import com.codingconcept.entity.Employee;
import com.codingconcept.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;


    public Employee saveEmployee(Employee employee){
        employeeRepository.save(employee);
        return employee;
    }

    public List<Employee> saveEmployees( List<Employee> employees){
        employeeRepository.saveAll(employees);
        return employees;
    }

    public List<Employee> getEmployees(){
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(int empid){
        return employeeRepository.findById(empid).orElse(null);
    }

    public Employee getEmployeeByName(String name){
        return employeeRepository.findByEmployeeName(name);
    }

    public String deleteEmployee(int id){
        employeeRepository.deleteById(id);
        return "Employee Id"+ id +" Deleted..";
    }

    public Employee updateEmployee(Employee employee,int id){
        Employee existingEmployee = employeeRepository.findById(id).orElse(null);
        if(null != existingEmployee){
            existingEmployee.setEmployeeName(employee.getEmployeeName());
            existingEmployee.setEmployeeDepartment(employee.getEmployeeDepartment());
            existingEmployee.setSalary(employee.getSalary());
            return employeeRepository.save(existingEmployee);
        }
        return null;
    }


}
