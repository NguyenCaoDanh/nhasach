package com.ncd.storeapplication.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Setter
@Getter
@Entity
public class Branches {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "branches_id", nullable = false)
    private int branchesId;
    @Basic
    @Column(name = "name", nullable = false, length = 50)
    private String name;
    @Basic
    @Column(name = "address", nullable = false, length = 200)
    private String address;
    @Basic
    @Column(name = "phone", nullable = true, length = 15)
    private String phone;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Branches branches = (Branches) o;
        return branchesId == branches.branchesId && Objects.equals(name, branches.name) && Objects.equals(address, branches.address) && Objects.equals(phone, branches.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(branchesId, name, address, phone);
    }
}
