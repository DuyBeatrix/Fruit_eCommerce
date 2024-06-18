package com.spring.service;

import com.spring.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UserService {
    public List<User> getAllUser(int index);
    public int countUser();
    public void deleteUser(int id);
}
