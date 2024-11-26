package com.ncd.storeapplication.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.Objects;

@Getter
@Setter
@Entity
public class Recuitments {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "recuitments_id", nullable = false)
    private int recuitmentsId;
    @Basic
    @Column(name = "title", nullable = false, length = 225)
    private String title;
    @Basic
    @Column(name = "description", nullable = false, length = -1)
    private String description;
    @Basic
    @Column(name = "start_date", nullable = false)
    private Date startDate;
    @Basic
    @Column(name = "end_date", nullable = false)
    private Date endDate;
    @Basic
    @Column(name = "status", nullable = false, length = 45)
    private String status;
    @Basic
    @Column(name = "branches_id", nullable = false)
    private int branchesId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recuitments that = (Recuitments) o;
        return recuitmentsId == that.recuitmentsId && branchesId == that.branchesId && Objects.equals(title, that.title) && Objects.equals(description, that.description) && Objects.equals(startDate, that.startDate) && Objects.equals(endDate, that.endDate) && Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recuitmentsId, title, description, startDate, endDate, status, branchesId);
    }
}
