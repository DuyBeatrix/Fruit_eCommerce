package com.spring.DAO;

import com.spring.model.Product;
import com.spring.model.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class NewSaleDAO
{
    @Autowired
    JdbcTemplate jdbcTemplate;

    // getProduct By New and Sale
    public List<Product> getSellingProduct()
    {
        List<Product> productList = new ArrayList<Product>();
        String sql = "select *, cate_name from product inner join category on category.cate_id = product.cate_id where product.product_hot = 1";
        productList = jdbcTemplate.query(sql, new ProductMapper());
        return productList;
    }
    public List<Product> getDiscountProduct()
    {
        List<Product> productList = new ArrayList<>();
        String sql = "select *, cate_name from product inner join category on category.cate_id = product.cate_id where product.product_sales > 0";
        productList = jdbcTemplate.query(sql, new ProductMapper());
        return productList;
    }
    public int countProduct()
    {
        String sql = "select count(*) from product";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }
}
