package com.spring.Service;

import com.spring.DAO.HomeDAO;
import com.spring.model.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsServiceImpl implements ProductsService{
    @Autowired
    private HomeDAO homeDAO = new HomeDAO();
    @Override
    public List<Products> getAllProducts() {
        return homeDAO.getAllProducts();
    }

    @Override
    public List<Products> getProductByCate(int cateId) {
        return homeDAO.getProductByCate(cateId);
    }

    @Override
    public int countProduct() {
        return homeDAO.countProduct();
    }

    @Override
    public List<Products> paginationProduct(int index) {
        return homeDAO.paginationProduct(index);
    }

    @Override
    public List<Products> getFreshVegetable() {
        return homeDAO.getFreshVegetable();
    }

    @Override
    public List<Products> getBestSeller() {
        return homeDAO.getBestSeller();
    }
}
