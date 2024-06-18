package com.spring.service;

import com.spring.model.Products;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ProductService {
    public int countProduct();
    public List<Products> paginationProduct(int index);
    public Products getProductById(int id);
    public void deleteProduct(int id);
    public void addProduct(Products product);
}