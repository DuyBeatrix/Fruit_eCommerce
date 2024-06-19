package com.spring.controller;

import com.spring.model.Products;
import com.spring.service.CategoryServiceImpl;
import com.spring.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RequestMapping("/product")
@Controller
public class ProductController
{
    @Autowired
    public ProductServiceImpl productService;
    @Autowired
    public CategoryServiceImpl categoryService;

    @GetMapping(value = "/{index}")
    public ModelAndView product(@PathVariable(required = false) Integer index, HttpServletRequest request){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin/product");
        int count = productService.countProduct();
        int endPage = count/10;
        if(count % 10 != 0) {
            endPage = endPage + 1;
        }
        request.setAttribute("endPage", endPage);
        if(index !=null && index > 0){
            mv.addObject("paginationProduct", productService.paginationProduct(index));
        }
        else {
            mv.addObject("paginationProduct", productService.paginationProduct(1));
        }
       return mv;
    }
    @GetMapping(value = "/delete/{id}")
    public ModelAndView deleteProduct(@PathVariable(required = false) Integer id){
        ModelAndView mv = new ModelAndView();
        try {
            productService.deleteProduct(id);
            mv.setViewName("redirect:/product/1");
        } catch (DataIntegrityViolationException e) {
            mv.addObject("msg", "Cannot delete product with id " + id + " because it has related data in other tables.");
            mv.setViewName("forward:/product/1");
        }
        return mv;
    }
    @GetMapping(value = "/addproduct")
    public ModelAndView addProduct(){
        ModelAndView mv = new ModelAndView();
        Products product = new Products();
        mv.setViewName("admin/addproduct");
        mv.addObject("product", product);
        mv.addObject("category", categoryService.getCategories());
        return mv;
    }
    @PostMapping(value = "/addproduct")
    public ModelAndView addProduct(@ModelAttribute("product") Products product) {
        productService.addProduct(product);
        return new ModelAndView("redirect:/product/1");
    }
@GetMapping(value = "/updateProduct")
public ModelAndView update(@RequestParam("productId") int productId) {
    ModelAndView mv = new ModelAndView();
    Products product = productService.getProductById(productId);
    mv.setViewName("admin/updateproduct");
    mv.addObject("product", product);
    mv.addObject("category", categoryService.getCategories());
    return mv;
}
    @PostMapping(value = "/updateProduct")
    public ModelAndView updateProduct(@ModelAttribute("product") Products product) {
        productService.updateProduct(product);
        return new ModelAndView("redirect:/product/1");
    }
}
