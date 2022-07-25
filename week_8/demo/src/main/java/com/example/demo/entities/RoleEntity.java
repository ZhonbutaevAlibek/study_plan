package com.example.demo.entities;

import javax.persistence.*;

@Entity
@Table(name="roles")
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long role_id;

    private String role;

    public RoleEntity() {
    }

    public RoleEntity(Long role_id, String role) {
        this.role_id = role_id;
        this.role = role;
    }

    public Long getRole_id() {
        return role_id;
    }

    public void setRole_id(Long role_id) {
        this.role_id = role_id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
