package com.spring.DAO;

import com.spring.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CheckoutDAO
{
    @Autowired
    JdbcTemplate jdbcTemplate;

    public int addCheckout(Checkout checkout)
    {
        String sql = "INSERT INTO checkout \n" +
                "(fullname, total_price, total_product, address, desc_order, email, customer_id, phone) \n" +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
        return jdbcTemplate.update(sql, checkout.getFullName(), checkout.getTotal(), checkout.getQuantity(), checkout.getAddress(), checkout.getDesc_order(), checkout.getEmail(), checkout.getUserid(), checkout.getPhone());
    }

    public int getIDLastBill(){
        String sql = "select max(id) from checkout";
        int checkoutid = jdbcTemplate.queryForObject(sql,new Object[]{},Integer.class );
        return checkoutid;
    }

    public int addCheckoutDetail(CheckoutDetail checkoutDetail)
    {
       String sql = "insert into checkoutdetail (product_id, order_id, quantity, total_piad) values(?,?,?,?)";
        return jdbcTemplate.update(sql, checkoutDetail.getProductID(), checkoutDetail.getCheckoutID(), checkoutDetail.getQuantity(), checkoutDetail.getTotal());
    }

    public void updateQuantity(CheckoutDetail checkoutDetail)
    {
        String sql = "UPDATE product SET quantity = quantity - ? WHERE id = ?";
        jdbcTemplate.update(sql, checkoutDetail.getQuantity(), checkoutDetail.getProductID());
    }
    public void updateSellQuantity(CheckoutDetail checkoutDetail)
    {
        String sql = "UPDATE product SET sell_quantity = sell_quantity + ? WHERE id = ?";
        jdbcTemplate.update(sql, checkoutDetail.getQuantity(), checkoutDetail.getProductID());
    }

    public List<Checkout> getOrder(int userID)
    {
        List<Checkout> list = new ArrayList<Checkout>();
        String sql = "select * from checkout where customer_id=?";
        list = jdbcTemplate.query(sql, new Object[]{userID}, new CheckoutMapper());
        return list;
    }

    public List<OrderDetail> getOrderDetail(int checkoutid) {
        String sql = "select fullname, product_img, product_name, product_price,  checkoutdetail.quantity, total_price, checkout.status, checkout.id from checkoutdetail \n" +
                "inner join product on checkoutdetail.product_id = product.id\n" +
                "inner join checkout on checkoutdetail.order_id = checkout.id\n" +
                "where checkout.id = ?";
        return jdbcTemplate.query(sql, new Object[]{checkoutid}, new OrderDetailMapper());
    }

    public OrderDetail getOneOrderDetail(int checkoutid)
    {
        String sql = "select fullname, product_img, product_name, product_price,  checkoutdetail.quantity, total_price, checkout.status, checkout.id from checkoutdetail \n" +
                "inner join product on checkoutdetail.product_id = product.id\n" +
                "inner join checkout on checkoutdetail.order_id = checkout.id\n" +
                "where checkout.id = ? limit 1";
        return jdbcTemplate.queryForObject(sql, new Object[]{checkoutid}, new OrderDetailMapper());
    }

    //===========================================================

    public Checkout findById(int id) {
        String sql = "SELECT * FROM checkout WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new CheckoutMapper());
    }

    public void updateOrderStatus(int id, String status) {
        String sql = "UPDATE checkout SET status = ? WHERE id = ?";
        jdbcTemplate.update(sql, status, id);
    }

    // Thêm phương thức để xóa chi tiết đơn hàng
    public void deleteCheckoutDetails(int checkoutid) {
        String sql = "DELETE FROM checkoutdetail WHERE order_id = ?";
        jdbcTemplate.update(sql, checkoutid);
    }

    // Thêm phương thức để cập nhật số lượng sản phẩm trong kho khi hủy đơn hàng
    public void updateQuantityOnCancel(int productId, int quantity) {
        String sql = "UPDATE product SET quantity = quantity + ? WHERE id = ?";
        jdbcTemplate.update(sql, quantity, productId);
    }

    // Lấy danh sách chi tiết đơn hàng
    public List<CheckoutDetail> getCheckoutDetails(int checkoutid) {
        String sql = "SELECT * FROM checkoutdetail WHERE order_id = ?";
        return jdbcTemplate.query(sql, new Object[]{checkoutid}, new CheckoutDetailMapper());
    }
}
