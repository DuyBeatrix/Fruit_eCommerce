package com.spring.service;

import com.spring.model.Categories;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    public List<Categories> getCategories();
}
