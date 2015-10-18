package com.example.reeva.restaurant.model;

import java.util.ArrayList;

/**
 * Created by Reeva on 9/24/2015.
 */
public class DishOrderPojo extends ArrayList<CharSequence> {
    private String dishid,dishname,qty,price,orderdetailid,status;
    //,custdishid,custdishname,custqty;
    private boolean isnew;

    public String getDishid() {
        return dishid;
    }

    public void setDishid(String dishid) {
        this.dishid = dishid;
    }

//    public String getCustdishid() {
//        return custdishid;
//    }
//
//    public void setCustdishid(String custdishid) {
//        this.custdishid = custdishid;
//    }
//
//    public String getCustdishname() {
//        return custdishname;
//    }
//
//    public void setCustdishname(String custdishname) {
//        this.custdishname = custdishname;
//    }
//
//    public String getCustqty() {
//        return custqty;
//    }

//    public void setCustqty(String custqty) {
//        this.custqty = custqty;
//    }

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

    public String getDishname() {
        return dishname;
    }

    public void setDishname(String dishname) {
        this.dishname = dishname;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public boolean isnew() {
        return isnew;
    }

    public void setIsnew(boolean isnew) {
        this.isnew = isnew;
    }
}
