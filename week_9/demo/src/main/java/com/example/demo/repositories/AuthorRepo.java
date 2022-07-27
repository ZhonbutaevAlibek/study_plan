package com.example.demo.repositories;

import com.example.demo.entities.AuthorEntity;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepo extends CrudRepository<AuthorEntity, Long> {
    AuthorEntity findByName(String name);
}
