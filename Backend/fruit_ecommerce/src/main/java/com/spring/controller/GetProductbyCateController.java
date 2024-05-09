package com.spring.controller;

import com.spring.Service.ProductsService;
import com.spring.Service.ProductsServiceImpl;
import com.spring.model.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = "productbycate")
public class GetProductbyCateController {
    @Autowired
    private ProductsServiceImpl productsService;

    @RequestMapping(value = "/{cateId}", method = RequestMethod.GET)
    public ModelAndView getProductsByCategory(@PathVariable int cateId, HttpServletRequest request ) {

        ModelAndView mv = new ModelAndView();
        boolean ajaxRequest = isAjaxRequest(request);
        request.setAttribute("ajaxRequest", ajaxRequest);
        mv.addObject("cateId", cateId);
        System.out.println("cateId: "+ cateId);
        mv.setViewName("user/productbycategory");
        mv.addObject("probycate", productsService.getProductByCate(cateId));
        return mv;
    }
    private boolean isAjaxRequest(HttpServletRequest request) {
        return "XMLHttpRequest".equals(request.getHeader("X-Requested-With"));
    }

}
