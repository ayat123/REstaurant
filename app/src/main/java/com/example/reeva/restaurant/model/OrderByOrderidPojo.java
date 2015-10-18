package com.example.reeva.restaurant.model;

import android.content.Context;

/**
 * Created by Reeva on 9/29/2015.
 */
public class OrderByOrderidPojo {
    private String dishid,dishname,quantity,price,orderdetailid,status;



    public String getDishid() {
        return dishid;
    }

    public String getDishname() {
        return dishname;
    }

    public void setDishname(String dishname) {
        this.dishname = dishname;
    }

    public void setDishid(String dishid) {
        this.dishid = dishid;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public String getOrderdetailid() {
        return orderdetailid;
    }

    public void setOrderdetailid(String orderdetailid) {
        this.orderdetailid = orderdetailid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public OrderByOrderidPojo(String dishid,String dishname, String quantity, String price,String orderdetailid, String status) {
        this.dishid = dishid;
        this.dishname = dishname;

        this.quantity = quantity;
        this.price = price;
        this.orderdetailid = orderdetailid;
        this.status = status;
    }
}
