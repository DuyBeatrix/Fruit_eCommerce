package com.spring.dao;

import com.spring.model.User;
import com.spring.model.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int countUser(){
        String sql = "select count(*) from customer";
        int count = jdbcTemplate.queryForObject(sql, new Object[]{}, Integer.class);
        return count;
    }
    public List<User> getAllUser(int index){
        List<User> list = new ArrayList<User>();
        String sql = "Select * from customer LIMIT 10 OFFSET ?";
        int page = (index-1) * 10;
        Object[] params = new Object[]{page};
        list = jdbcTemplate.query(sql,params, new UserMapper());
        return list;
    }
    public void deleteUser(int id) {
        String sql = "delete from customer where id=?";
        jdbcTemplate.update(sql,id);
    }
}
