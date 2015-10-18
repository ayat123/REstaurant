package com.example.reeva.restaurant.webservices;

import com.example.reeva.restaurant.model.FinishorderPojo;
import com.example.reeva.restaurant.model.OrderByOrderidPojo;

import java.util.List;

import retrofit.Callback;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

/**
 * Created by Reeva on 9/29/2015.
 */
public interface FinishOrderAPI {
    @FormUrlEncoded
    @POST("/finishOrder.php")
    void getUserPosts(@Field("orderid") String orderid,
                      @Field("tableid") String tableid ,Callback<FinishorderPojo> posts);
}
