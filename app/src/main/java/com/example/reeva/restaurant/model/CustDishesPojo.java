package com.example.reeva.restaurant.model;

/**
 * Created by Reeva on 10/10/2015.
 */
public class CustDishesPojo {
    private String dishid,cusineid,dishname,dishtype,description,price,dishimage;

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

    public CustDishesPojo(String dishid, String cusineid, String dishname, String dishtype, String description, String price, String dishimage) {
        this.dishid = dishid;
        this.cusineid = cusineid;
        this.dishname = dishname;

        this.dishtype = dishtype;
        this.description = description;
        this.price = price;
        this.dishimage = dishimage;
    }
}
