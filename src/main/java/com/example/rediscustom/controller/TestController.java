package com.example.rediscustom.controller;

import com.example.rediscustom.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class TestController {

    private final EmployeeService service;

    public TestController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/employee/{id}")
    public String getData(@PathVariable int id) {
        return service.getEmployee(id);
    }
}
