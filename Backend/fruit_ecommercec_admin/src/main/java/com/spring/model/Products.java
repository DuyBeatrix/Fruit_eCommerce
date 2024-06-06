package com.spring.model;

import java.util.Date;

public class Products {
    private int productId;
    private String productName;
    private String productDesc;
    //private String shortDesc;
    private double productPrice;
    private int quantity;
    private double sale;
    private int hot;
    private Date expDate;
    private Date createDate;
    private String productImg;
    private int cateId;
    private String cateName;
    private int sellQuantity;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getSale() {
        return sale;
    }

    public void setSale(double sale) {
        this.sale = sale;
    }

    public int getHot() {
        return hot;
    }

    public void setHot(int hot) {
        this.hot = hot;
    }

    public Date getExpDate() {
        return expDate;
    }

    public void setExpDate(Date expDate) {
        this.expDate = expDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getProductImg() {
        return productImg;
    }

    public void setProductImg(String productImg) {
        this.productImg = productImg;
    }

    public int getCateId() {
        return cateId;
    }

    public void setCateId(int cateId) {
        this.cateId = cateId;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public int getSellQuantity() {
        return sellQuantity;
    }

    public void setSellQuantity(int sellQuantity) {
        this.sellQuantity = sellQuantity;
    }

    public Products() {
    }

    public Products(int productId, String productName, String productDesc, double productPrice, int quantity, double sale, int hot, Date expDate, Date createDate, String productImg, int cateId, String cateName, int sellQuantity) {
        this.productId = productId;
        this.productName = productName;
        this.productDesc = productDesc;
        this.productPrice = productPrice;
        this.quantity = quantity;
        this.sale = sale;
        this.hot = hot;
        this.expDate = expDate;
        this.createDate = createDate;
        this.productImg = productImg;
        this.cateId = cateId;
        this.cateName = cateName;
        this.sellQuantity = sellQuantity;
    }
}
