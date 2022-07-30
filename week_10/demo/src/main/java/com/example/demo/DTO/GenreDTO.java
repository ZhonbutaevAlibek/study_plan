package com.example.demo.DTO;

import com.example.demo.entities.GenreEntity;

public class GenreDTO {
    private String genre;

    public static GenreDTO toModel(GenreEntity entity){
        GenreDTO model = new GenreDTO();
        model.setGenre(entity.getGenre());
        return model;
    }

    public GenreDTO() {
    }

    public GenreDTO(String genre) {
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
