package io.spring.todoapp.service;

import org.springframework.stereotype.Service;

@Service
public class AuthService {
    
    public boolean authenticate(String name, String password) {
        boolean isValidUserName = name.equals("raghu");
        boolean isValidPassword = password.equals("password");
        return isValidUserName && isValidPassword;
    }
}
