package com.spring.Service;

import com.spring.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {
    @Autowired
    public User login(User user);
    public int register(User user);
    public int findAccountbyUsername(String username);
    public int findAccountByEmail(String email);
    public void changePassword(String email, String newPassword);
}
