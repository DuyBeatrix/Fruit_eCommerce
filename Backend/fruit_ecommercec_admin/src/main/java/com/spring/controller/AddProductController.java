package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class AddProductController {
    @GetMapping(value = "/addproduct")
    public String addProduct(){
        return "admin/addproduct";
    }
}
