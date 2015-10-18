package com.example.reeva.restaurant.model;

/**
 * Created by Reeva on 9/30/2015.
 */
public class DeletePojo {
    private String success,message;

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DeletePojo(String success, String message) {
        this.success = success;
        this.message = message;
    }


}
