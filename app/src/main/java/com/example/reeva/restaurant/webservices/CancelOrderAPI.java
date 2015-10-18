package com.example.reeva.restaurant.webservices;

import com.example.reeva.restaurant.model.CancelOrderPojo;
import com.example.reeva.restaurant.model.FeedbackPojo;

import retrofit.Callback;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

/**
 * Created by Reeva on 10/10/2015.
 */
public interface CancelOrderAPI {
    @FormUrlEncoded
    @POST("/orderCancel.php")
    void getUserPosts(@Field("orderid") String orderid,Callback<CancelOrderPojo> posts);


}
