package com.spring.DAO;

import com.spring.model.Categories;
import com.spring.model.CategoriesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class HomeDAO
{
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Categories> getCategories()
    {
        List<Categories> categoriesList = new ArrayList<Categories>();
        String sql = "select * from category";
        categoriesList = jdbcTemplate.query(sql, new CategoriesMapper());
        return categoriesList;
    }
}
