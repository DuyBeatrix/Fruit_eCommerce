package com.spring.model;

public class OrderDetail {
    private int id;
    private double totalPiad;
    private int orderID;
    private Orders order;
    private int productId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTotalPiad() {
        return totalPiad;
    }

    public void setTotalPiad(double totalPiad) {
        this.totalPiad = totalPiad;
    }



    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public OrderDetail() {
    }

    public OrderDetail(int id, double totalPiad, int orderID, Orders order, int productId) {
        this.id = id;
        this.totalPiad = totalPiad;
        this.orderID = orderID;
        this.order = order;
        this.productId = productId;
    }
}
