package com.spring.controller;

import com.spring.model.Categories;
import com.spring.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/{index}")
    public ModelAndView category(@PathVariable(required = false) Integer index, HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin/category");
        int count = categoryService.countCategory();
        int endPage = count / 10;
        if (count % 10 != 0) {
            endPage = endPage + 1;
        }
        request.setAttribute("endPage", endPage);
        if (index != null && index > 0) {
            mv.addObject("paginationCategory", categoryService.paginationCategory(index));
        } else {
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

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        Categories categories = categoryService.getCategoryByID(id);
        model.addAttribute("categories", categories);
        return "admin/edit-category"; // Change to your actual view name for editing categories
    }

    @PostMapping("/edit/{id}")
    public String updateCategory(@PathVariable int id, @ModelAttribute Categories categories) {
        categories.setCateId(id);
        categoryService.editCategory(categories);
        return "redirect:/category/1"; // Redirect to the first page after updating
    }

    @GetMapping("/delete/{id}")
    public String deleteCategory(@PathVariable int id, Model model) {
        try {
            categoryService.deleteCategory(id);
            model.addAttribute("message","Xóa thành công");
            return "redirect:/category/1"; // Redirect to the first page after deleting

        } catch (DataIntegrityViolationException e) {
            model.addAttribute("message", "Không thể xóa");
            return "forward:/category/1";
        }
    }
}
