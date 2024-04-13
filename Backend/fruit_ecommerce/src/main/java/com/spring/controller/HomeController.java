package com.spring.controller;

import com.spring.Service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @Autowired
    public CategoriesService categoriesService;
    @RequestMapping(value={"/", "/home"}, method = RequestMethod.GET)
    public ModelAndView home() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("user/homepage");
        mv.addObject("categories", categoriesService.getAllCategories());
        return mv;
    }
}
