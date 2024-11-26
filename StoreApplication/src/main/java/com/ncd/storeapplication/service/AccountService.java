package com.ncd.storeapplication.service;

import com.ncd.storeapplication.entity.Users;
import com.ncd.storeapplication.generic.IRepository;
import com.ncd.storeapplication.generic.IService;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AccountService extends IService<Users, Integer>, UserDetailsService {
    IRepository<Users, Integer> getRepository();
}
