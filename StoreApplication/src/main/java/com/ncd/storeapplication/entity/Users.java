package com.ncd.storeapplication.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

@Setter
@Getter
@Entity
public class Users implements UserDetails {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "users_id", nullable = false)
    private int usersId;
    @Basic
    @Column(name = "username", nullable = false, length = 45)
    private String username;
    @Basic
    @Column(name = "password", nullable = false, length = 255)
    private String password;
    @Basic
    @Column(name = "avatar", nullable = true, length = 225)
    private String avatar;
    @Basic
    @Column(name = "email", nullable = true, length = 100)
    private String email;
    @Basic
    @Column(name = "phone", nullable = true, length = 45)
    private String phone;
    @Basic
    @Column(name = "full_name", nullable = true, length = 255)
    private String fullName;
    @Basic
    @Column(name = "role_id", nullable = false)
    private int roleId;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Bạn có thể trả về quyền người dùng từ cột role_id
        return Collections.emptyList();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
