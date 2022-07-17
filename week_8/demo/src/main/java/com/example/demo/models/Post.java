package com.example.demo.models;

import com.example.demo.entities.GenreEntity;
import com.example.demo.entities.PostEntity;

public class Post {
    private String post;

    public static Post toModel(PostEntity entity){
        Post model = new Post();
        model.setPost(entity.getPost());
        return model;
    }

    public Post() {
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }
}
