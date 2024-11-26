package com.ncd.storeapplication.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Setter
@Getter
@Entity
@Table(name = "order_detail", schema = "nhasach", catalog = "")
public class OrderDetail {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "order_detail_id", nullable = false)
    private int orderDetailId;
    @Basic
    @Column(name = "order_id", nullable = false)
    private int orderId;
    @Basic
    @Column(name = "branches_products_id", nullable = false)
    private int branchesProductsId;
    @Basic
    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDetail that = (OrderDetail) o;
        return orderDetailId == that.orderDetailId && orderId == that.orderId && branchesProductsId == that.branchesProductsId && quantity == that.quantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderDetailId, orderId, branchesProductsId, quantity);
    }
}
