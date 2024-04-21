package com.spring.controller;

import com.spring.Service.CategoriesService;
import com.spring.Service.CategoriesServiceImpl;
import com.spring.Service.ProductsService;
import com.spring.Service.ProductsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @Autowired
    public CategoriesServiceImpl categoriesService;
    @Autowired
    public ProductsServiceImpl productsService;
    @RequestMapping(value={"/", "/home"}, method = RequestMethod.GET)
    public ModelAndView home() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("user/homepage");
        mv.addObject("categories", categoriesService.getAllCategories());
        mv.addObject("products", productsService.getAllProducts());

        int count = productsService.countProduct();
        mv.addObject("count", count);
        int endPage = count/4;
        if(count % 4 != 0){
            endPage = endPage + 1;
        }
        mv.addObject("endPage", endPage);
//        mv.addObject("productbycate", productsService.getProductByCate(cateId));

        return mv;
    }
}
