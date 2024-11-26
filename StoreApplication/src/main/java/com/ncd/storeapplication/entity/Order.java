package com.ncd.storeapplication.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Objects;

@Setter
@Getter
@Entity
public class Order {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "order_id", nullable = false)
    private int orderId;
    @Basic
    @Column(name = "time", nullable = false)
    private Timestamp time;
    @Basic
    @Column(name = "total_price", nullable = false, precision = 0)
    private double totalPrice;
    @Basic
    @Column(name = "users_id", nullable = false)
    private int usersId;
    @Basic
    @Column(name = "status_id", nullable = false)
    private int statusId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return orderId == order.orderId && Double.compare(totalPrice, order.totalPrice) == 0 && usersId == order.usersId && statusId == order.statusId && Objects.equals(time, order.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, time, totalPrice, usersId, statusId);
    }
}
