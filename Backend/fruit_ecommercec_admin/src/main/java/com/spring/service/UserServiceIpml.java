package com.spring.service;

import com.spring.dao.UserDao;
import com.spring.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceIpml implements UserService{
    @Autowired
    private UserDao userDao;
    @Override
    public List<User> getAllUser(int index) {
        return userDao.getAllUser(index);
    }

    @Override
    public int countUser() {
        return userDao.countUser();
    }

    @Override
    public void deleteUser(int id) {
        userDao.deleteUser(id);
    }
}
