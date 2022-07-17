package com.example.demo.models;


import com.example.demo.entities.SalesEntity;

public class Sale {
    private String date;
    private String book;
    private String employee;
    private Integer amount;
    private Float sum;

    public static Sale toModel(SalesEntity salesEntity){
        Sale model = new Sale();
        model.setDate(salesEntity.getDate());
        model.setBook(salesEntity.getBook().getTitle());
        model.setEmployee(salesEntity.getEmployee().getName());
        model.setAmount(salesEntity.getAmount());
        model.setSum(salesEntity.getSum());

        return model;
    }

    public Sale() {
    }

    public Sale(String date, String book, String employee, Integer amount, Float sum) {
        this.date = date;
        this.book = book;
        this.employee = employee;
        this.amount = amount;
        this.sum = sum;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Float getSum() {
        return sum;
    }

    public void setSum(Float sum) {
        this.sum = sum;
    }
}
