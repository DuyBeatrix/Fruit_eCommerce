package com.spring.service;

import com.spring.model.OrderDetail;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {
    public int countOrder();
    public List<OrderDetail> getAllOrder(int index);
    public void updateDeliveryStatus(int orderDetailId, String deliveryStatus);
}
