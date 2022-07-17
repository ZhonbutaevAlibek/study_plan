package com.example.demo.models;


import com.example.demo.entities.EmployeeEntity;

public class Employee {
    private String name;
    private String address;
    private String phone;
    private String post;

    public static Employee toModel(EmployeeEntity entity){
        Employee model = new Employee();
        model.setName(entity.getName());
        model.setAddress(entity.getAddress());
        model.setPhone(entity.getPhone());
        model.setPost(entity.getPost().getPost());
        return model;
    }

    public Employee() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }
}
