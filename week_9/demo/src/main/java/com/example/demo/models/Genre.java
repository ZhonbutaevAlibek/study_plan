package com.example.demo.models;

import com.example.demo.entities.AuthorEntity;
import com.example.demo.entities.GenreEntity;

public class Genre {
    private String genre;

    public static Genre toModel(GenreEntity entity){
        Genre model = new Genre();
        model.setGenre(entity.getGenre());
        return model;
    }

    public Genre() {
    }

    public Genre(String genre) {
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
