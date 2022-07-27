package com.example.demo.repositories;

import com.example.demo.entities.PostEntity;
import org.springframework.data.repository.CrudRepository;

public interface PostRepo extends CrudRepository<PostEntity, Long> {
    PostEntity findByPost(String post);
}
