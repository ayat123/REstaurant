package com.example.reeva.restaurant.model;

/**
 * Created by Reeva on 9/23/2015.
 */
public class DishiesPojo  {
    private String id, dishid,dishname,dishtype,description,price,dishimage;
    private boolean isnew;

    public DishiesPojo() {
    }
    public DishiesPojo(boolean isnew) {
        this.isnew = isnew;
    }

    /* public String getSuccess() {
            return success;
        }

        public void setSuccess(String success) {

            this.success = success;
        }
    */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDishid() {
        return dishid;
    }

    public void setDishid(String dishid) {
        this.dishid = dishid;
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

    public DishiesPojo( String dishid, String dishname, String dishtype, String description, String price, String dishimage) {
       /* this.success = success;*/

        this.dishid = dishid;
        this.dishname = dishname;
        this.dishtype = dishtype;
        this.description = description;

        this.price = price;
        this.dishimage = dishimage;
    }


}
