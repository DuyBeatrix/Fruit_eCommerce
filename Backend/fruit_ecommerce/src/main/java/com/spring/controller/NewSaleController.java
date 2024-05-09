package com.spring.controller;

import com.spring.Service.New_Sale_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NewSaleController
{
    @Autowired
    public New_Sale_Service new_sale_Service;

    @RequestMapping(value={"/newsale"}, method = RequestMethod.GET)
    public ModelAndView newSale() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("user/newsale");
        mv.addObject("product", new_sale_Service.getAllProduct());
        int count = new_sale_Service.countProduct();
        mv.addObject("count", count);
        return mv;
    }

}
