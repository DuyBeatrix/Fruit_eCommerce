package com.spring.DAO;

import com.spring.model.Product;
import com.spring.model.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SearchDAO
{
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Product> findAllProduct(String text)
    {
        List<Product> productList = new ArrayList<Product>();
        //String sql = "SELECT * FROM product WHERE 1 = 1 AND (product_name like '%"+text+"%')";
        //String sql = "select *, cate_name from product inner join category on category.cate_id = product.cate_id WHERE product_name like \'%"+text+"%\'";
//        Object[] params = new Object[]{text};
//        //String sql = "select *, cate_name from product inner join category on category.cate_id = product.cate_id WHERE product_name like \'%"+text+"%\'";
//        productList = jdbcTemplate.query(sql, params, new ProductMapper());
        String sql = "select *, cate_name from product inner join category on category.cate_id = product.cate_id WHERE product_name like ?";
        productList = jdbcTemplate.query(sql, new Object[]{"%" + text + "%"}, new ProductMapper());

        return productList;
    }
}
