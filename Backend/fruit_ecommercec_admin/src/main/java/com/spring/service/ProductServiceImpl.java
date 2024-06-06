package com.spring.service;

import com.spring.dao.ProductsDao;
import com.spring.model.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductsDao proDao;
    @Override
    public int countProduct() {

        return proDao.countProduct();
    }

    @Override
    public List<Products> paginationProduct(int index) {
        return proDao.paginationProduct(index);
    }

    @Override
    public Products getProductById(int id) {
        return proDao.getProductById(id);
    }

    @Override
    public void deleteProduct(int id) {
        proDao.deleteProduct(id);
    }

    @Override
    public void addProduct(Products product) {
        proDao.addProduct(product);
    }
}
