package com.spring.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderMapper implements RowMapper<Orders> {

    @Override
    public Orders mapRow(ResultSet rs, int i) throws SQLException {
        Orders orders = new Orders();
        orders.setId(rs.getInt("id"));
        orders.setOrderDate(rs.getDate("createDay "));
        orders.setTotalPrice(rs.getDouble("total_price"));
        orders.setTotalProduct(rs.getDouble("total_product"));
        orders.setAddress(rs.getString("address"));
        orders.setDescOrder(rs.getString("desc_order"));
        orders.setPhone(rs.getString("phone"));
        orders.setEmail(rs.getString("email"));
        orders.setCusId(rs.getInt("customer_id"));
        orders.setDelivery(rs.getDouble("delivery"));
        orders.setProductId(rs.getInt("product_id"));
        return orders;
    }
}
