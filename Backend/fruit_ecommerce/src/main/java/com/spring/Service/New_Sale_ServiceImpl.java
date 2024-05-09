package com.spring.Service;

import com.spring.DAO.NewSaleDAO;
import com.spring.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class New_Sale_ServiceImpl implements New_Sale_Service
{
    @Autowired
    private NewSaleDAO new_sale_DAO = new NewSaleDAO();

    @Override
    public List<Product> getAllProduct()
    {
        return new_sale_DAO.getProduct();
    }

    @Override
    public int countProduct() {
        return new_sale_DAO.countProduct();
    }


}
