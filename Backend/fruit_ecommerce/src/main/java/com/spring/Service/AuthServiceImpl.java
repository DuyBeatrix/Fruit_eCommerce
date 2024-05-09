package com.spring.Service;

import com.spring.DAO.AuthDao;
import com.spring.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService{
    @Autowired
    private AuthDao authDao;
    @Override
    public User login(User user) {

        user = authDao.login(user);
        if(user != null) {
            return user;
        }
        return  null;
    }

    @Override
    public int register(User user) {
        return authDao.register(user);
    }

    @Override
    public int findAccountbyUsername(String username) {
        return authDao.findAccountbyUsername(username);
    }

    @Override
    public int findAccountByEmail(String email) {
        return authDao.findAccountByEmail(email);
    }

    @Override
    public void changePassword(String email, String newPassword){
        authDao.changePassword(email, newPassword);
    }

}
