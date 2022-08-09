package com.example.demo.DTO;

import com.example.demo.entities.PostEntity;

public class PostDTO {
    private String post;

    public static PostDTO toModel(PostEntity entity){
        PostDTO model = new PostDTO();
        model.setPost(entity.getPost());
        return model;
    }

    public PostDTO() {
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }
}
