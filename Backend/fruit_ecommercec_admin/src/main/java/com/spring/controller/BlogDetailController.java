package com.spring.controller;

import com.spring.model.BlogDetail;
import com.spring.service.BlogDetailService;
import com.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;

@Controller
@RequestMapping("/blogdetails")
public class BlogDetailController {

    @Autowired
    private BlogDetailService blogDetailService;
    @Autowired
    private UserService userService;


    @GetMapping(value = "/{index}")
    public ModelAndView blogDetails(@PathVariable(required = false) Integer index, HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin/blogdetails");
        int count = blogDetailService.countBlog();
        int endPage = count / 10;
        if (count % 10 != 0) {
            endPage = endPage + 1;
        }
        request.setAttribute("endPage", endPage);
        if (index != null && index > 0) {
            mv.addObject("paginationBlogDetails", blogDetailService.paginationBlogDetails(index));
        } else {
            mv.addObject("paginationBlogDetails", blogDetailService.paginationBlogDetails(1));
        }
        return mv;
    }

    @GetMapping(value = "/add")
    public ModelAndView addBlogDetailForm() {
        ModelAndView mv = new ModelAndView();
        BlogDetail detail = new BlogDetail();
        mv.setViewName("admin/add-blog");
        mv.addObject("blogDetail", detail);
        mv.addObject("customers", userService.getAllUsers());
        mv.addObject("blogTypes", blogDetailService.getAllBlogTypes());

        return mv;
    }



    @PostMapping(value = "/add")
    public ModelAndView addBlogDetail(@ModelAttribute("blogDetail") BlogDetail blogDetail) {
        ModelAndView mv = new ModelAndView();
        Date currentDate = new Date();
        blogDetail.setCreateAt(currentDate);
//        if (!file.isEmpty()) {
//            try {
//                String fileName = file.getOriginalFilename();
//                String uploadDir = "/resource/admin/img/blog";
//                File transferFile = new File(uploadDir, fileName);
//                file.transferTo(transferFile);
//
//                // Set the image path to the blog detail
//                blogDetail.setBlogImg(fileName);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }

        blogDetailService.addBlogDetail(blogDetail);
        mv.setViewName("redirect:/blogdetails/1");
        return mv;
    }

    @GetMapping(value = "/edit/{id}")
    public ModelAndView editBlogDetailForm(@PathVariable("id") int id) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin/edit-blog");
        mv.addObject("blogDetail", blogDetailService.getBlogDetailById(id));
        return mv;
    }

    @PostMapping(value = "/edit")
    public String editBlogDetail(@ModelAttribute BlogDetail blogDetail) {
        blogDetailService.updateBlogDetail(blogDetail);
        return "redirect:/blogdetails/1";
    }

    @GetMapping(value = "/delete/{id}")
    public String deleteBlogDetail(@PathVariable("id") int id) {
        blogDetailService.deleteBlogDetail(id);
        return "redirect:/blogdetails/1";
    }
}
