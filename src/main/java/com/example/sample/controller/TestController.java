package com.example.sample.controller;

import com.example.sample.entity.Employee;
import com.example.sample.repository.EmployeeRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api")
public class TestController {

    private final EmployeeRepository repo;

    public TestController(EmployeeRepository repo){
        this.repo = repo;
    }

    @PostMapping("/employee")
    public Employee add(@RequestBody Employee emp){
        return repo.save(emp);
    }

    @GetMapping("/employees")
    public List<Employee> all(){
        return repo.findAll();
    }

//    @Cacheable(value = "employee", key = "#id")
//    @GetMapping("/employee/{id}")
//    public Employee find(@PathVariable Long id){
//        return repo.findById(id).orElse(null);
//    }
    
    @Cacheable(value = "employee", key = "#id")
    @GetMapping("/{id}")
    public ResponseEntity<?> getEmployeeById(@PathVariable Long id) {
    	
    	System.out.println("inside the id not found");

        return repo.findById(id)
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity
                        .status(404)
                        .body("Employee not found with ID: " + id));
    }

}
