package com.codingconcept.controller;

import com.codingconcept.entity.Employee;
import com.codingconcept.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/employee")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        return new ResponseEntity<>(employeeService.saveEmployee(employee), HttpStatus.OK);
    }

    @PostMapping("/employees")
    public ResponseEntity< List<Employee>> addEmployees(@RequestBody List<Employee> employee){
        return new ResponseEntity<>(employeeService.saveEmployees(employee), HttpStatus.OK);
    }

    @GetMapping("/employee")
    public ResponseEntity< List<Employee>> getEmployees(){
        return new ResponseEntity<>(employeeService.getEmployees(), HttpStatus.OK);
    }

    @GetMapping("/employee/{id}")
    public  ResponseEntity<Employee> getEmployeeById(@PathVariable int id){
        return new ResponseEntity<>(employeeService.getEmployeeById(id), HttpStatus.OK);
    }

    @GetMapping("/employees/{name}")
    public  ResponseEntity<Employee> getEmployeeByName(@PathVariable String name){
        return new ResponseEntity<>(employeeService.getEmployeeByName(name), HttpStatus.OK);
    }

    @DeleteMapping("/employee/{id}")
    public  ResponseEntity<String> deleteEmployeeById(@PathVariable int id){
        return new ResponseEntity<>(employeeService.deleteEmployee(id), HttpStatus.OK);
    }

    @PutMapping("/employee/{id}")
    public  ResponseEntity<Employee> deleteEmployeeById(@RequestBody Employee employee,@PathVariable int id){
        return new ResponseEntity<>(employeeService.updateEmployee(employee,id), HttpStatus.OK);
    }

}
