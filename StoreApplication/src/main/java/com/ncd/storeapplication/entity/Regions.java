package com.ncd.storeapplication.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Setter
@Getter
@Entity
public class Regions {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "regions_id", nullable = false)
    private int regionsId;
    @Basic
    @Column(name = "name", nullable = false, length = 100)
    private String name;
    @Basic
    @Column(name = "description", nullable = true, length = -1)
    private String description;
    @Basic
    @Column(name = "branches_id", nullable = false)
    private int branchesId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Regions regions = (Regions) o;
        return regionsId == regions.regionsId && branchesId == regions.branchesId && Objects.equals(name, regions.name) && Objects.equals(description, regions.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(regionsId, name, description, branchesId);
    }
}
