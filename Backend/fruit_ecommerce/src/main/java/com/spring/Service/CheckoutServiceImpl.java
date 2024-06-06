package com.spring.Service;

import com.spring.DAO.CheckoutDAO;
import com.spring.model.Cart;
import com.spring.model.Checkout;
import com.spring.model.CheckoutDetail;
import com.spring.model.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CheckoutServiceImpl implements CheckoutService
{
    @Autowired
    CheckoutDAO checkoutDAO;

    @Override
    public int addCheckout(Checkout checkout) {
        return checkoutDAO.addCheckout(checkout);
    }

    @Override
    public void addCheckoutDetail(HashMap<Integer, Cart> carts)
    {
        int checkoutid = checkoutDAO.getIDLastBill();
        for(Map.Entry<Integer, Cart> itemCart : carts.entrySet())
        {
            CheckoutDetail checkoutDetail = new CheckoutDetail();
            checkoutDetail.setCheckoutID(checkoutid);
            checkoutDetail.setProductID(itemCart.getValue().getProduct().getId());
            checkoutDetail.setQuantity(itemCart.getValue().getQuantity());
            checkoutDetail.setTotal(itemCart.getValue().getTotalPrice());
            checkoutDAO.addCheckoutDetail(checkoutDetail);
            checkoutDAO.updateQuantity(checkoutDetail);
            checkoutDAO.updateSellQuantity(checkoutDetail);
        }
    }

    @Override
    public List<Checkout> getOrder(int userID) {
        return checkoutDAO.getOrder(userID);
    }
    @Override
    public List<OrderDetail> getOrderDetail(int checkoutid) {
        return checkoutDAO.getOrderDetail(checkoutid);
    }

    @Override
    public OrderDetail getOneOrderDetail(int checkoutid) {
        return checkoutDAO.getOneOrderDetail(checkoutid);
    }
}
