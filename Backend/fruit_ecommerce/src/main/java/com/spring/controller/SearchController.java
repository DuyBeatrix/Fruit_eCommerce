package com.spring.controller;

import com.spring.Service.SearchServiceImpl;
import com.spring.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class SearchController
{
    @Autowired
    private SearchServiceImpl searchService = new SearchServiceImpl();

//    @RequestMapping(value = "/search")
//    public ModelAndView search(){
//        ModelAndView mv = new ModelAndView("user/search");
//        return mv;
//    }

//    @RequestMapping(value = "/search")
//    public String search(HttpSession session, Model model, @RequestParam("freeText") String freeText)
//    {
//        int id = (Integer)session.getAttribute("id");
//        model.addAttribute("search", searchService.findAllProducts(id, freeText));
//        return "user/search";
//    }

//        @RequestMapping(value = "/search", method = RequestMethod.GET)
//        public String search(@RequestParam("freeText") String freeText, HttpSession session, Model model) {
//            model.addAttribute("search", searchService.findAllProducts(freeText));
//            return "user/search";
//        }
    @RequestMapping(value = "/search/{freeText}", method = RequestMethod.GET)
    public ModelAndView search(@PathVariable String freeText, HttpSession session, Model model) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("freeText", freeText);
//        if(freeText == null || freeText.equals("")) {
//            mv.setViewName("user/search");
//        }
        mv.setViewName("user/search");
        mv.addObject("searchResult", searchService.findAllProducts(freeText));
        return mv;
    }
}
