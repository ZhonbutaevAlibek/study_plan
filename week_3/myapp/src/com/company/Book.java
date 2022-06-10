package com.company;

public class Book {
    private long id;
    private String name;
    private long author;
    private long genre;
    private int year;
    private float price;

    public Book() {}

    public Book(long id, String name, long author, long genre, int year, float price) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.genre = genre;
        this.year = year;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getAuthor() {
        return author;
    }

    public long getGenre() {
        return genre;
    }

    public int getYear() {
        return year;
    }

    public float getPrice() {
        return price;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(long author) {
        this.author = author;
    }

    public void setGenre(long genre) {
        this.genre = genre;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
