package com.ncd.storeapplication.controller;

import com.ncd.storeapplication.DTO.RequestResponse;
import com.ncd.storeapplication.DTO.request.LoginDTO;
import com.ncd.storeapplication.DTO.response.Token;
import com.ncd.storeapplication.entity.Users;
import com.ncd.storeapplication.exception.ExceptionResponse;
import com.ncd.storeapplication.generic.GenericController;
import com.ncd.storeapplication.generic.IService;
import com.ncd.storeapplication.jwt.JwtService;
import com.ncd.storeapplication.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/account")
public class AccountController extends GenericController<Users, Integer> {
    @Autowired
    private AccountService accountService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtService jwtService;

    @Override
    public IService<Users, Integer> getService() {
        return accountService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginDTO.getUsername(),
                            loginDTO.getPassword()));
            if (authentication.isAuthenticated()) {
                return ResponseEntity
                        .status(HttpStatus.OK)
                        .body(
                                new RequestResponse(
                                        new Token(jwtService.generateToken(loginDTO.getUsername()))));
            } else
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ExceptionResponse("Invalid username or password"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionResponse(e.getMessage()));
        }
    }

    @PostMapping("/regis")
    public ResponseEntity<?> add(@RequestBody Users account) {
        accountService.save(account);
        return ResponseEntity.status(HttpStatus.OK).body(new RequestResponse("Register successfully"));
    }
}
