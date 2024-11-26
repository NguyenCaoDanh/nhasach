package com.ncd.storeapplication.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Objects;

@Setter
@Getter
@Entity
public class Voucher {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "voucher_id", nullable = false)
    private int voucherId;
    @Basic
    @Column(name = "code", nullable = false, length = 45)
    private String code;
    @Basic
    @Column(name = "discount", nullable = false, precision = 0)
    private double discount;
    @Basic
    @Column(name = "time_start", nullable = false)
    private Timestamp timeStart;
    @Basic
    @Column(name = "time_end", nullable = false)
    private Timestamp timeEnd;
    @Basic
    @Column(name = "number", nullable = true)
    private Integer number;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Voucher voucher = (Voucher) o;
        return voucherId == voucher.voucherId && Double.compare(discount, voucher.discount) == 0 && Objects.equals(code, voucher.code) && Objects.equals(timeStart, voucher.timeStart) && Objects.equals(timeEnd, voucher.timeEnd) && Objects.equals(number, voucher.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(voucherId, code, discount, timeStart, timeEnd, number);
    }
}
