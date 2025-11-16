package com.example.rediscustom.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Cacheable(value = "employee", key = "#id")
    public String getEmployee(int id) {
        try { Thread.sleep(3000); } catch (Exception ignored) {}
        return "Employee-" + id + "-Data";
    }
}
