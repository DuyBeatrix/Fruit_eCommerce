package com.spring.model;

public class Users {
    private int id;
    private String cusName;
    private String username;
    private String password;
    private String cusPhone;
    private String cusEmail;
    private String cusAddress;
    private boolean gender;
    private int roleId;

    public Users() {
    }

    public Users(int id, String cusName, String username, String password, String cusPhone, String cusEmail, String cusAddress, boolean gender, int roleId) {
        this.id = id;
        this.cusName = cusName;
        this.username = username;
        this.password = password;
        this.cusPhone = cusPhone;
        this.cusEmail = cusEmail;
        this.cusAddress = cusAddress;
        this.gender = gender;
        this.roleId = roleId;
    }

    public int getId() {
        return id;
    }

    public String getCusName() {
        return cusName;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getCusPhone() {
        return cusPhone;
    }

    public String getCusEmail() {
        return cusEmail;
    }

    public String getCusAddress() {
        return cusAddress;
    }

    public boolean isGender() {
        return gender;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCusPhone(String cusPhone) {
        this.cusPhone = cusPhone;
    }

    public void setCusEmail(String cusEmail) {
        this.cusEmail = cusEmail;
    }

    public void setCusAddress(String cusAddress) {
        this.cusAddress = cusAddress;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
}
