package com.spring.Service;

import com.spring.DAO.AuthDao;
import com.spring.model.User;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService{
    @Autowired
    private AuthDao authDao;
    @Override
    public User login(User user) {
        String password = user.getPassword();
        user = authDao.login(user);
        if(user != null) {
            if(BCrypt.checkpw(password,user.getPassword())){
                return user;
            }
        }
        return  null;
    }

    @Override
    public int register(User user) {
        user.setPassword(BCrypt.hashpw(user.getPassword(),BCrypt.gensalt(12)));
        return authDao.register(user);
    }

    @Override
    public int setupUser(int id, User user) {
        return 0;
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
