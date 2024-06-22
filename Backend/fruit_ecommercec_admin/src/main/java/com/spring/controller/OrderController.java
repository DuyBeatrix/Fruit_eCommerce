package com.spring.controller;

import com.spring.service.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
@RequestMapping(value = "/order")
@Controller
public class OrderController {
    @Autowired
    private OrderServiceImpl orderService;

    @GetMapping(value = "/{index}")
    public ModelAndView order(@PathVariable(required = false) Integer index, HttpServletRequest request){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin/order");
        int count = orderService.countOrder();
        int endPage = count/10;
        if(count % 10 != 0) {
            endPage = endPage + 1;
        }
        request.setAttribute("endPage", endPage);
        if(index !=null && index > 0){
            mv.addObject("listOrder", orderService.getAllOrder(index));
        }
        else {
            mv.addObject("listOrder", orderService.getAllOrder(1));
        }
        return mv;
    }
//    @GetMapping(value = "/delete/{id}")
//    public ModelAndView deleteFeedBack(@PathVariable(required = false) Integer id){
//        ModelAndView mv = new ModelAndView();
//        feedbackService.deleteFeedback(id);
//        mv.setViewName("redirect:/feedback/1");
//        return mv;
//    }
    @PostMapping("/updateDeliveryStatus")
    public ModelAndView updateDeliveryStatus(@RequestParam("orderDetailId") int orderDetailId, @RequestParam("deliveryStatus") String deliveryStatus) {
    orderService.updateDeliveryStatus(orderDetailId, deliveryStatus);
    return new ModelAndView("redirect:/order/1");
}
}
