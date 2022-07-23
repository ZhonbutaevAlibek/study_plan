package com.example.demo.repositories;

import com.example.demo.entities.BookEntity;
import org.springframework.data.repository.CrudRepository;

public interface BookRepo extends CrudRepository<BookEntity, Long> {
    BookEntity findByTitle(String title);
}
