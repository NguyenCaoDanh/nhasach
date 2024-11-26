package com.ncd.storeapplication.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Setter
@Getter
@Entity
@Table(name = "apply_voucher", schema = "nhasach", catalog = "")
public class ApplyVoucher {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "apply_voucher_id", nullable = false)
    private int applyVoucherId;
    @Basic
    @Column(name = "min_order_price", nullable = false, precision = 0)
    private double minOrderPrice;
    @Basic
    @Column(name = "voucher_id", nullable = false)
    private int voucherId;
    @Basic
    @Column(name = "order_id", nullable = false)
    private int orderId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ApplyVoucher that = (ApplyVoucher) o;
        return applyVoucherId == that.applyVoucherId && Double.compare(minOrderPrice, that.minOrderPrice) == 0 && voucherId == that.voucherId && orderId == that.orderId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(applyVoucherId, minOrderPrice, voucherId, orderId);
    }
}
