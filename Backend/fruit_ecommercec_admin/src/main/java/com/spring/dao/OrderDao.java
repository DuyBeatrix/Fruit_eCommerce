package com.spring.dao;

import com.spring.model.OrderDetail;
import com.spring.model.OrderDetailMapper;
import com.spring.model.Orders;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.annotation.Order;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int countOrder(){
        String sql = "select count(*) from checkoutdetail";
        int count = jdbcTemplate.queryForObject(sql, new Object[]{},Integer.class);
        return count;
    }
    public List<OrderDetail> getAllOrder(int index){
        List<OrderDetail> list = new ArrayList<OrderDetail>();
        String sql = "SELECT * FROM checkoutdetail od JOIN checkout o ON od.order_id = o.id limit 10 offset ?";
        int page = (index-1) * 10;
        Object[] params = new Object[]{page};
        list = jdbcTemplate.query(sql,params,new OrderDetailMapper());
        return list;
    }
    public void updateDeliveryStatus(int orderDetailId, String deliveryStatus) {
        String sql = "UPDATE checkoutdetail SET status = ? WHERE id = ?";
        jdbcTemplate.update(sql, deliveryStatus, orderDetailId);
    }
}
