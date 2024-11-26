package com.ncd.storeapplication.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Setter
@Getter
@Entity
@Table(name = "branches_products", schema = "nhasach", catalog = "")
public class BranchesProducts {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "branches_products_id", nullable = false)
    private int branchesProductsId;
    @Basic
    @Column(name = "number", nullable = false)
    private int number;
    @Basic
    @Column(name = "branches_id", nullable = false)
    private int branchesId;
    @Basic
    @Column(name = "products_id", nullable = false)
    private int productsId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BranchesProducts that = (BranchesProducts) o;
        return branchesProductsId == that.branchesProductsId && number == that.number && branchesId == that.branchesId && productsId == that.productsId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(branchesProductsId, number, branchesId, productsId);
    }
}
