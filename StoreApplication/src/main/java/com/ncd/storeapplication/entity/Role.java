package com.ncd.storeapplication.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Setter
@Getter
@Entity
public class Role {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "role_id", nullable = false)
    private int roleId;
    @Basic
    @Column(name = "role", nullable = false, length = 45)
    private String role;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role1 = (Role) o;
        return roleId == role1.roleId && Objects.equals(role, role1.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleId, role);
    }
}
