package com.spring.controller;

import com.spring.model.Users;
import com.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("/user")
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/{index}")
    public ModelAndView user(@PathVariable(required = false) Integer index, HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin/user"); // Change to your actual view name for users
        int count = userService.countUsers();
        int endPage = count / 10;
        if (count % 10 != 0) {
            endPage = endPage + 1;
        }
        request.setAttribute("endPage", endPage);
        if (index != null && index > 0) {
            mv.addObject("paginationUsers", userService.paginationUsers(index));
        } else {
            mv.addObject("paginationUsers", userService.paginationUsers(1));
        }
        return mv;
    }
    @GetMapping("/add")
    public String showAddForm() {
        return "admin/add-user"; // Change to your actual view name for adding users
    }

    @PostMapping("/add")
    public String addUser(@ModelAttribute Users user) {
        userService.addUser(user);
        return "redirect:/user/1"; // Redirect to the first page after adding
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable int id, HttpServletRequest request) {
        Users user = userService.getUserById(id);
        request.setAttribute("user", user);
        return "admin/edit-user"; // Change to your actual view name for editing users
    }

    @PostMapping("/edit/{id}")
    public String updateUser(@PathVariable int id, @ModelAttribute Users user) {
        user.setId(id);
        userService.updateUser(user);
        return "redirect:/user/1"; // Redirect to the first page after updating
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
        return "redirect:/user/1"; // Redirect to the first page after deleting
    }
}
