package com.spring.controller;

import com.spring.service.UserServiceIpml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
@RequestMapping("/user")
@Controller
public class UserController {
    @Autowired
    private UserServiceIpml serviceIpml;
    @GetMapping(value = "/{index}")
    public ModelAndView user(@PathVariable(required = false) Integer index, HttpServletRequest request){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin/user");
        int count = serviceIpml.countUser();
        int endPage = count/10;
        if(count % 10 != 0) {
            endPage = endPage + 1;
        }
        request.setAttribute("endPage", endPage);
        if(index !=null && index > 0){
            mv.addObject("allUser", serviceIpml.getAllUser(index));
        }
        else {
            mv.addObject("allUser", serviceIpml.getAllUser(1));
        }
        return mv;
    }
    @GetMapping(value = "/delete/{id}")
    public ModelAndView deleteProduct(@PathVariable(required = false) Integer id){
        ModelAndView mv = new ModelAndView();
        serviceIpml.deleteUser(id);
        mv.setViewName("redirect:/user/1");
        return mv;
    }
}
