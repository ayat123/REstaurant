package com.example.reeva.restaurant.model;

/**
 * Created by Reeva on 9/23/2015.
 */
public class InactivTPojo {
    private String id,name,status;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public InactivTPojo(String id, String name, String
            status) {
        this.id = id;

        this.name = name;
        this.status = status;
    }
}
