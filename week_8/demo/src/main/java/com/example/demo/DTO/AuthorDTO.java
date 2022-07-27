package com.example.demo.DTO;

import com.example.demo.entities.AuthorEntity;

public class AuthorDTO {
    private String name;

    public static AuthorDTO toModel(AuthorEntity entity){
        AuthorDTO model = new AuthorDTO();
        model.setName(entity.getName());
        return model;
    }

    public AuthorDTO() {
    }

    public AuthorDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
