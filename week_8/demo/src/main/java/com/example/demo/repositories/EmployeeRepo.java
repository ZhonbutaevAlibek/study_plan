package com.example.demo.repositories;

import com.example.demo.entities.EmployeeEntity;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepo extends CrudRepository<EmployeeEntity, Long> {
    EmployeeEntity findByEmail(String email);
}
