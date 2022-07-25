package com.example.demo.DTO;

import com.example.demo.entities.BookEntity;

public class BookDTO {
    private String title;
    private String author;
    private String genre;
    private Integer year;
    private Float price;
    private Integer amount;

    public static BookDTO toModel(BookEntity bookEntity){
        BookDTO model = new BookDTO();
        model.setTitle(bookEntity.getTitle());
        model.setAuthor(bookEntity.getAuthor().getName());
        model.setGenre(bookEntity.getGenre().getGenre());
        model.setYear(bookEntity.getYear());
        model.setPrice(bookEntity.getPrice());
        model.setAmount(bookEntity.getAmount());
        return model;
    }

    public BookDTO() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
