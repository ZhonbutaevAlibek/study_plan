package com.example.demo.entities;

public enum Permission {
    BOOKS_READ("books:read"),
    BOOKS_WRITE("books:write");


    final String permission;

    Permission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
