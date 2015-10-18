package com.example.reeva.restaurant.model;

/**
 * Created by Reeva on 9/23/2015.
 */
public class NewOrderPojo {
    private String orderid;

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public NewOrderPojo(String orderid) {

        this.orderid = orderid;
    }
}
