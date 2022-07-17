package com.example.demo.repositories;

import com.example.demo.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<UserEntity, Long> {
    UserEntity findByEmail(String email);
}
