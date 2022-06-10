package com.company;

public class Sales {
    private long id;
    private String date;
    private long book;
    private long employee;
    private int amount;
    private float sum;

    public Sales() {}

    public Sales(long id, String date, long book, long employee, int amount, float sum) {
        this.id = id;
        this.date = date;
        this.book = book;
        this.employee = employee;
        this.amount = amount;
        this.sum = sum;
    }

    public long getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public long getBook() {
        return book;
    }

    public long getEmployee() {
        return employee;
    }

    public int getAmount() {
        return amount;
    }

    public float getSum() {
        return sum;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setBook(long book) {
        this.book = book;
    }

    public void setEmployee(long employee) {
        this.employee = employee;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setSum(float sum) {
        this.sum = sum;
    }
}
