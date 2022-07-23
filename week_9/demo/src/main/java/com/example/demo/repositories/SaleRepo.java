package com.example.demo.repositories;

import com.example.demo.entities.SalesEntity;
import org.springframework.data.repository.CrudRepository;

public interface SaleRepo extends CrudRepository<SalesEntity, Long> {
    SalesEntity findByDate(String date);
}
