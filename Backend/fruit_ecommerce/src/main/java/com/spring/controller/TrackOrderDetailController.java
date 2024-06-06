package com.spring.controller;

import com.spring.Service.CheckoutServiceImpl;
import com.spring.model.OrderDetail;
import com.spring.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TrackOrderDetailController
{
    @Autowired
    private CheckoutServiceImpl checkoutService;

    @RequestMapping(value="/trackorderdetail/{checkoutid}", method = RequestMethod.GET)
    public ModelAndView trackorderdetail(@PathVariable int checkoutid)
    {
        ModelAndView mv = new ModelAndView("user/trackorderdetail");
        mv.addObject("orderdetail", checkoutService.getOrderDetail(checkoutid));
        OrderDetail orderDetail = checkoutService.getOneOrderDetail(checkoutid);
        mv.addObject("cusName", orderDetail.getCusName());
        return mv;
    }
}
