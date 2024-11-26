package com.ncd.storeapplication.service.impl;

import com.ncd.storeapplication.entity.Users;
import com.ncd.storeapplication.exception.ErrorHandler;
import com.ncd.storeapplication.generic.IRepository;
import com.ncd.storeapplication.repository.UsersRepository;
import com.ncd.storeapplication.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public IRepository<Users, Integer> getRepository() {
        return usersRepository;
    }

    @Override
    public void save(Users users) {
        try {
            users.setRoleId(1);
            users.setPassword(passwordEncoder.encode(users.getPassword()));
            usersRepository.save(users);
        } catch (Exception e) {
            throw new ErrorHandler(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @Override
    public void delete(Integer integer) {

    }

    @Override
    public Iterator<Users> findAll() {
        return null;
    }

    @Override
    public Users findOne(Integer integer) {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Users> account = usersRepository.findByUsername(username);
        return account.orElseThrow(() -> new ErrorHandler(HttpStatus.UNAUTHORIZED, "Account not exist"));
    }



}