package com.example.reeva.restaurant.webservices;

import com.example.reeva.restaurant.model.InactivTPojo;
import com.example.reeva.restaurant.model.OrderByOrderidPojo;

import java.util.List;

import retrofit.Callback;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

/**
 * Created by Reeva on 9/29/2015.
 */
public interface GetOrderByOrderIDAPI {
    @FormUrlEncoded
    @POST("/getOrderByOrderId.php")
    void getUserPosts(@Field("orderid") String orderid, Callback<List<OrderByOrderidPojo>> posts);
}
