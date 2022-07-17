package com.example.demo.repositories;

import com.example.demo.entities.GenreEntity;
import org.springframework.data.repository.CrudRepository;

public interface GenreRepo extends CrudRepository<GenreEntity, Long> {
    GenreEntity findByGenre(String genre);
}
