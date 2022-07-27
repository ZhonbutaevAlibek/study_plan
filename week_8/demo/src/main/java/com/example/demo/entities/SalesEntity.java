package com.example.demo.entities;

import javax.persistence.*;

@Entity
@Table(name = "sales")
public class SalesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sale_id;
    private String date;

    @ManyToOne
    @JoinColumn(name = "book")
    private BookEntity book;

    @ManyToOne
    @JoinColumn(name = "employee")
    private EmployeeEntity employee;

    private Integer amount;
    private Float sum;

    public SalesEntity() {
    }

    public SalesEntity(Long sale_id, String date, BookEntity book, EmployeeEntity employee, Integer amount, Float sum) {
        this.sale_id = sale_id;
        this.date = date;
        this.book = book;
        this.employee = employee;
        this.amount = amount;
        this.sum = sum;
    }

    public Long getSale_id() {
        return sale_id;
    }

    public void setSale_id(Long sale_id) {
        this.sale_id = sale_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public BookEntity getBook() {
        return book;
    }

    public void setBook(BookEntity book) {
        this.book = book;
    }

    public EmployeeEntity getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeEntity employee) {
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
