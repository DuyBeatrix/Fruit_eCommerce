package com.spring.model;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderDetailMapper implements RowMapper<OrderDetail>
{

    @Override
    public OrderDetail mapRow(ResultSet rs, int rowNum) throws SQLException {
        OrderDetail order = new OrderDetail();
        order.setCusName(rs.getString("fullname"));
        order.setProductImg(rs.getString("product_img"));
        order.setProductName(rs.getString("product_name"));
        order.setProductPrice(rs.getDouble("product_price"));
        order.setQuantity((rs.getInt("quantity")));
        order.setTotalPrice((rs.getDouble("total_price")));
        order.setStatus((rs.getString("status")));
        return order;
    }
}
