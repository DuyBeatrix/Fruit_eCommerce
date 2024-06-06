package com.spring.Service;

import com.spring.model.Categories;
import com.spring.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface New_Sale_Service
{
    // By New and sale
    public List<Product> getSellingProduct();
    public List<Product> getDiscountProduct();
    public int countProduct();
}
