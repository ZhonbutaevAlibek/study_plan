package com.company;

public class Employee {
    private long id;
    private String name;
    private String address;
    private String phoneNumber;
    private long post;

    public Employee() {}

    public Employee(long id, String name, String address, String phoneNumber, long post) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.post = post;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public long getPost() {
        return post;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setPost(long post) {
        this.post = post;
    }
}
