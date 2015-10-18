package com.example.reeva.restaurant.model;

/**
 * Created by Reeva on 9/21/2015.
 */
public class TablePojo {
    private String orderid,tableid,tablename;

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getTableid() {
        return tableid;
    }

    public void setTableid(String tableid) {
        this.tableid = tableid;
    }

    public String getTablename() {
        return tablename;
    }

    public void setTablename(String tablename) {
        this.tablename = tablename;
    }

    public TablePojo(String orderid, String tableid, String tablename) {
        this.orderid = orderid;
        this.tableid = tableid;

        this.tablename = tablename;
    }
}
