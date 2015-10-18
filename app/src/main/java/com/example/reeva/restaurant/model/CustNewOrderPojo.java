package com.example.reeva.restaurant.model;

/**
 * Created by Reeva on 10/12/2015.
 */
public class CustNewOrderPojo {
    private String tableid,orderid,dishid,cusineid,dishname,dishtype,description,price,dishimage;

    public String getTableid() {
        return tableid;
    }

    public void setTableid(String tableid) {
        this.tableid = tableid;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getDishid() {
        return dishid;
    }

    public void setDishid(String dishid) {
        this.dishid = dishid;
    }

    public String getCusineid() {
        return cusineid;
    }

    public void setCusineid(String cusineid) {
        this.cusineid = cusineid;
    }

    public String getDishname() {
        return dishname;
    }

    public void setDishname(String dishname) {
        this.dishname = dishname;
    }

    public String getDishtype() {
        return dishtype;
    }

    public void setDishtype(String dishtype) {
        this.dishtype = dishtype;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDishimage() {
        return dishimage;
    }

    public void setDishimage(String dishimage) {
        this.dishimage = dishimage;
    }

    public CustNewOrderPojo(String tableid, String orderid, String dishid, String cusineid, String dishname, String dishtype, String description, String dishimage, String price) {
        this.tableid = tableid;
        this.orderid = orderid;
        this.dishid = dishid;
        this.cusineid = cusineid;
        this.dishname = dishname;

        this.dishtype = dishtype;
        this.description = description;
        this.dishimage = dishimage;
        this.price = price;
    }
}
