package com.ncd.storeapplication.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.Objects;

@Getter
@Setter
@Entity
public class Applications {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "applications_id", nullable = false)
    private int applicationsId;
    @Basic
    @Column(name = "full_name", nullable = false, length = 100)
    private String fullName;
    @Basic
    @Column(name = "email", nullable = false, length = 255)
    private String email;
    @Basic
    @Column(name = "phone", nullable = false, length = 15)
    private String phone;
    @Basic
    @Column(name = "resume", nullable = false, length = 255)
    private String resume;
    @Basic
    @Column(name = "application_date", nullable = false)
    private Date applicationDate;
    @Basic
    @Column(name = "status", nullable = false, length = 45)
    private String status;
    @Basic
    @Column(name = "recuitments_id", nullable = false)
    private int recuitmentsId;  

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Applications that = (Applications) o;
        return applicationsId == that.applicationsId && recuitmentsId == that.recuitmentsId && Objects.equals(fullName, that.fullName) && Objects.equals(email, that.email) && Objects.equals(phone, that.phone) && Objects.equals(resume, that.resume) && Objects.equals(applicationDate, that.applicationDate) && Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(applicationsId, fullName, email, phone, resume, applicationDate, status, recuitmentsId);
    }
}
