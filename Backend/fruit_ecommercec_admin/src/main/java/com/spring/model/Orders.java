package com.spring.model;

import java.util.Date;

public class Orders {
    private int id;
    private Date orderDate;
    private double totalPrice;
    private double totalProduct;
    private String address;
    private String phone;
    private String descOrder;
    private String email;
    private int cusId;
    private double delivery;
    private int productId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public String getDescOrder() {
        return descOrder;
    }

    public void setDescOrder(String descOrder) {
        this.descOrder = descOrder;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public double getTotalProduct() {
        return totalProduct;
    }

    public void setTotalProduct(double totalProduct) {
        this.totalProduct = totalProduct;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCusId() {
        return cusId;
    }

    public void setCusId(int cusId) {
        this.cusId = cusId;
    }

    public double getDelivery() {
        return delivery;
    }

    public void setDelivery(double delivery) {
        this.delivery = delivery;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public Orders() {
    }

    public Orders(int id, Date orderDate, double totalPrice, double totalProduct, String address, String phone, String descOrder, String email, int cusId, double delivery, int productId) {
        this.id = id;
        this.orderDate = orderDate;
        this.totalPrice = totalPrice;
        this.totalProduct = totalProduct;
        this.address = address;
        this.phone = phone;
        this.descOrder = descOrder;
        this.email = email;
        this.cusId = cusId;
        this.delivery = delivery;
        this.productId = productId;
    }
}
