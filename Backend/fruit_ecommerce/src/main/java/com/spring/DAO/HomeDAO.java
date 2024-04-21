package com.spring.DAO;

import com.spring.model.Categories;
import com.spring.model.CategoriesMapper;
import com.spring.model.Products;
import com.spring.model.ProductsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class HomeDAO {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Categories> getCategories() {
        List<Categories> categoriesList = new ArrayList<Categories>();
        String sql = "select * from category";
        categoriesList = jdbcTemplate.query(sql, new CategoriesMapper());
        return categoriesList;
    }

    public List<Products> getAllProducts() {
        List<Products> productsList  = new ArrayList<Products>();
        String sql = "select *, cate_name from product inner join category on product.cate_id = category.cate_id";
        productsList = jdbcTemplate.query(sql, new ProductsMapper());

        return productsList;
    }
    public List<Products> getProductByCate(int cateId) {
        List<Products> products = new ArrayList<Products>();
        String sql = "SELECT p.*, c.cate_name FROM product p inner join category c on p.cate_id = c.cate_id where c.cate_id=?";
        products =  jdbcTemplate.query(sql, new Object[]{cateId}, new ProductsMapper());
        return  products;
    }
    public int countProduct(){
        String sql = "select count(*) from product";
        int count = jdbcTemplate.queryForObject(sql, new Object[]{}, Integer.class);
        return count;
    }
    //pagination product
    public List<Products> paginationProduct(int index){
        List<Products> products = new ArrayList<Products>();
        String sql = "SELECT p.*, c.cate_name FROM product p inner join category c on p.cate_id = c.cate_id LIMIT 4 OFFSET ?";
        int page = (index-1) * 4;
        Object[] params = new Object[]{page};
        products = jdbcTemplate.query(sql,params, new ProductsMapper());
        return  products;
    }
//    public static void main(String[] args) {
//        HomeDAO homeDAO = new HomeDAO();
//        List<Products> list = homeDAO.paginationProduct(1);
//        for (Products products: list){
//            System.out.println(products);
//        }
//    }
}
