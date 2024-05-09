package com.spring.Service;

import com.spring.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SearchService
{
    public List<Product> findAllProducts(String text);
}
