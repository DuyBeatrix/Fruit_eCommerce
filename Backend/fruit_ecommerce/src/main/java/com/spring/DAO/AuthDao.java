package com.spring.DAO;

import com.spring.model.User;
import com.spring.model.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AuthDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public User login(User user){
        String sql = "select * from customer where username=?";
        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{user.getUserName()}, new UserMapper());
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
    public int register(User user) {
        String sql = "Insert into customer (cus_email, username, password,role_id,cus_enable) values (?,?,?,2,'Kích hoạt')";
        int result = jdbcTemplate.update(sql,user.getCusEmail(), user.getUserName(),user.getPassword());
        return result;
    }
    public int setupUser(int id, User user) {
        String sql = "Update customer SET cus_name = ?, cus_phone = ?, cus_address = ? where id = ?";
        int result = jdbcTemplate.update(sql, user.getCusName(), user.getCusPhone(),user.getCusAddress(), id);
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
