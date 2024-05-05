package com.spring.DAO;

import com.spring.model.User;
import com.spring.model.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AuthDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public User login(User user){
        String sql = "select * from customer where username=?";
        User result = jdbcTemplate.queryForObject(sql, new Object[]{user.getUserName()}, new UserMapper());
        return result;
    }
    public int register(User user) {
        String sql = "Insert into customer (cus_email, username, password) values (?,?,?)";
        int result = jdbcTemplate.update(sql,user.getCusEmail(), user.getUserName(),user.getPassword());
        return result;
    }
    public int findAccountbyUsername(String username) {
        String sql = "SELECT COUNT(*) FROM customer WHERE username=?";
        int result = jdbcTemplate.queryForObject(sql, Integer.class, username);
        return result;
    }
    public int findAccountByEmail(String email){
        String sql = "SELECT COUNT(*) FROM customer WHERE cus_email=?";
        int result = jdbcTemplate.queryForObject(sql, Integer.class, email);
        return result;
    }
//    public User changePassword(User user){
//        String sql = "UPDATE customer SET password = ? WHERE cus_email = ?";
//        return jdbcTemplate.queryForObject(sql, new Object[]{user.getUserName(), user.getPassword()}, new UserMapper());
//    }
    public void changePassword(String email, String newPassword) {
        String sql = "UPDATE customer SET password = ? WHERE cus_email = ?";
        jdbcTemplate.update(sql, newPassword, email);
    }
}
