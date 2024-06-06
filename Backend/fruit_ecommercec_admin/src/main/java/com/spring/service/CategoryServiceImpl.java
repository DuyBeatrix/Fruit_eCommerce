package com.spring.service;

import com.spring.dao.CategoryDao;
import com.spring.model.Categories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    private CategoryDao categoryDao;
    @Override
    public List<Categories> getCategories() {
        return categoryDao.getCategories();
    }
}
