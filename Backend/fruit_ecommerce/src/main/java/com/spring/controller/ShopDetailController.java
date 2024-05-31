package com.spring.controller;

import com.spring.Service.CategoriesService;
import com.spring.Service.FeedbackServices;
import com.spring.Service.ProductsService;
import com.spring.Service.ShopDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ShopDetailController {
    @Autowired
    public CategoriesService categoriesService;
    @Autowired
    public ShopDetailService shopDetailService;
    @Autowired
    public FeedbackServices feedbackServices;

    @RequestMapping(value={ "/shop-detail/{id}"}, method = RequestMethod.GET)
    public ModelAndView shopDetail (@PathVariable int id) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("user/shop-detail");
        mv.addObject("productSales",shopDetailService.getProductSales());
        mv.addObject("categories", categoriesService.getAllCategories());
        mv.addObject("productById", shopDetailService.getProductById(id));
        int idCategory = shopDetailService.getProductById(id).get(0).getCateId();
        mv.addObject("similarProducts",shopDetailService.getSimilarProductsByCate(idCategory));
        mv.addObject("feedbacks", feedbackServices.getListFeedback());


        return mv;
    }
}
