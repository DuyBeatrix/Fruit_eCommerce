package com.spring.controller;

import com.spring.Service.CheckoutServiceImpl;
import com.spring.model.Checkout;
import com.spring.model.OrderDetail;
import com.spring.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class TrackOrderDetailController
{
    @Autowired
    private CheckoutServiceImpl checkoutService;
    private User loginInfo;
    @RequestMapping(value="/trackorderdetail/{checkoutid}", method = RequestMethod.GET)
    public ModelAndView trackorderdetail(HttpSession session, @PathVariable int checkoutid)
    {
        ModelAndView mv = new ModelAndView("user/trackorderdetail");
        mv.addObject("orderdetail", checkoutService.getOrderDetail(checkoutid));
        OrderDetail orderDetail = checkoutService.getOneOrderDetail(checkoutid);
        mv.addObject("cusName", orderDetail.getCusName());

        List<OrderDetail> orderDetails = checkoutService.getOrderDetail(checkoutid);
        double totalPrice = orderDetails.stream()
                .mapToDouble(item -> item.getProductPrice() * item.getQuantity())
                .sum();
        mv.addObject("totalPrice", totalPrice);

        loginInfo = (User) session.getAttribute("loginInfo");
        List<Checkout> checkouts = checkoutService.getOrder(loginInfo.getId());
        mv.addObject("phone", checkouts.get(0).getPhone());
        mv.addObject("address", checkouts.get(0).getAddress());
        mv.addObject("date", checkouts.get(0).getCreateDay());
        return mv;
    }
}
