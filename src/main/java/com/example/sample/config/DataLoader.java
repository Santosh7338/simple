package com.example.sample.config;

import com.example.sample.entity.Employee;
import com.example.sample.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final EmployeeRepository repo;

    public DataLoader(EmployeeRepository repo) {
        this.repo = repo;
    }

    @Override
    public void run(String... args) throws Exception {

        if (repo.count() == 0) {
            for (int i = 1; i <= 100; i++) {
                repo.save(new Employee("Employee " + i, "Department " + i));
            }
            System.out.println("✔ Inserted 100 employee records into H2");
        } else {
            System.out.println("✔ Employee table already has data");
        }
    }
}
