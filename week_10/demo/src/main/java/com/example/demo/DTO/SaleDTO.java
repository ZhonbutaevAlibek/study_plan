package com.example.demo.DTO;


import com.example.demo.entities.SalesEntity;

public class SaleDTO {
    private String date;
    private String book;
    private String employee;
    private Integer amount;
    private Float sum;

    public static SaleDTO toModel(SalesEntity salesEntity){
        SaleDTO model = new SaleDTO();
        model.setDate(salesEntity.getDate());
        model.setBook(salesEntity.getBook().getTitle());
        model.setEmployee(salesEntity.getEmployee().getName());
        model.setAmount(salesEntity.getAmount());
        model.setSum(salesEntity.getSum());

        return model;
    }

    public SaleDTO() {
    }

    public SaleDTO(String date, String book, String employee, Integer amount, Float sum) {
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
