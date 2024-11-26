package com.ncd.storeapplication.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Setter
@Getter
@Entity
public class Status {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "status_id", nullable = false)
    private int statusId;
    @Basic
    @Column(name = "status", nullable = false, length = 45)
    private String status;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Status status1 = (Status) o;
        return statusId == status1.statusId && Objects.equals(status, status1.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(statusId, status);
    }
}
