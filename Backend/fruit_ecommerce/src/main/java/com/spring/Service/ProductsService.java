package com.spring.Service;

import com.spring.model.Products;

import java.util.List;

public interface ProductsService {
    public List<Products> getAllProducts();
    public List<Products> getProductByCate(int cateId);
    public int countProduct();
    public List<Products> paginationProduct(int index);
    public List<Products> getFreshVegetable();
    public List<Products> getBestSeller();
}
