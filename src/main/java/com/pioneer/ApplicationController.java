package com.pioneer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApplicationController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping("/createEmployee")
    public Employee createEmployee(@RequestBody Employee employee){
       return employeeRepository.save(employee);
    }

    @PostMapping("/updateEmployee")
    public Employee updateEmployee(@RequestBody Employee employee){
       Employee e= employeeRepository.findByFirstName(employee.getFirstName());
       e.setEmail(employee.getEmail());
        e.setPhoneNo(employee.getPhoneNo());
       e.setLastName(employee.getLastName());
        return employeeRepository.save(e);
    }

    @GetMapping("/getAllEmployee")
    public List<Employee> getAllEmployee(){
        return employeeRepository.findAll();
    }

    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable("id") String id){
       employeeRepository.delete(id);
        return "success";
    }

}
