package com.spring.controller;

import com.spring.model.Categories;
import com.spring.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping(value = "/{index}")
    public ModelAndView category (@PathVariable(required = false) Integer index, HttpServletRequest request){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin/category");
        int count = categoryService.countCategory();
        int endPage = count/10;
        if(count % 10 != 0) {
            endPage = endPage + 1;
        }
        request.setAttribute("endPage", endPage);
        if(index !=null && index > 0){
            mv.addObject("paginationCategory", categoryService.paginationCategory(index));
        }
        else {
            mv.addObject("paginationCategory", categoryService.paginationCategory(1));
        }
        return mv;
    }
    @GetMapping("/add")
    public ModelAndView addCategory() {
        ModelAndView mv = new ModelAndView("admin/add-category");
        mv.addObject("category", new Categories());
        return mv;
    }

    @PostMapping("/add")
    public ModelAndView addCategory(@ModelAttribute("category") Categories category) {
        ModelAndView mv = new ModelAndView("redirect:/category/1");

        categoryService.addCategory(category);
        return mv;
    }
//    @PostMapping("/add")
//    public ModelAndView addCategory(@ModelAttribute("category") Categories category, @RequestParam("cateImg") MultipartFile file) {
//        ModelAndView mv = new ModelAndView("redirect:/category/1");
//
//        if (!file.isEmpty()) {
//            try {
//                String fileName = file.getOriginalFilename();
//                String uploadDir = "/resource/admin/img/category";
//                File transferFile = new File(uploadDir, fileName);
//                file.transferTo(transferFile);
//                category.setCateImg(fileName);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//        categoryService.addCategory(category);
//        return mv;
//    }
}
