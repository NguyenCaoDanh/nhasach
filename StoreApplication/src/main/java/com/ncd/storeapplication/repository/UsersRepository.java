package com.ncd.storeapplication.repository;

import com.ncd.storeapplication.entity.Users;
import com.ncd.storeapplication.generic.IRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends IRepository<Users,Integer> {
    Optional<Users> findByUsername(String username);
}
