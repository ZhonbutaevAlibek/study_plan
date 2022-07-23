package com.example.demo.models;

import com.example.demo.entities.AuthorEntity;

public class Author {
    private String name;

    public static Author toModel(AuthorEntity entity){
        Author model = new Author();
        model.setName(entity.getName());
        return model;
    }

    public Author() {
    }

    public Author(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
