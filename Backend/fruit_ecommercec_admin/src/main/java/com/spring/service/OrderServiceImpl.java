package com.spring.service;

import com.spring.dao.OrderDao;
import com.spring.model.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    private OrderDao orderDao;
    @Override
    public int countOrder() {
        return orderDao.countOrder();
    }

    @Override
    public List<OrderDetail> getAllOrder(int index) {
        return orderDao.getAllOrder(index);
    }

    @Override
    public void updateDeliveryStatus(int orderDetailId, String deliveryStatus) {
        orderDao.updateDeliveryStatus(orderDetailId,deliveryStatus);
    }
}
