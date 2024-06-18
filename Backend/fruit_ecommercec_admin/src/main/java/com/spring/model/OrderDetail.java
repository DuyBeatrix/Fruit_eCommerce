package com.spring.model;

public class OrderDetail {
    private int id;
    private double totalPiad;
    private String deliveryStatus;
    private int orderID;
    private Orders order;

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

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
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

    public OrderDetail() {
    }

    public OrderDetail(int id, double totalPiad, String deliveryStatus, int orderID, Orders order) {
        this.id = id;
        this.totalPiad = totalPiad;
        this.deliveryStatus = deliveryStatus;
        this.orderID = orderID;
        this.order = order;
    }
}
