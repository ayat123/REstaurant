package com.example.reeva.restaurant.model;

/**
 * Created by Reeva on 10/10/2015.
 */
public class CancelOrderPojo {
    private String success;

    public CancelOrderPojo(String success) {
        this.success = success;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }
}
