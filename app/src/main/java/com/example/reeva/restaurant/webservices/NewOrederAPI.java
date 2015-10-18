package com.example.reeva.restaurant.webservices;

import com.example.reeva.restaurant.model.NewOrderPojo;
import com.example.reeva.restaurant.model.TablePojo;

import java.util.List;

import retrofit.Callback;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

/**
 * Created by Reeva on 9/23/2015.
 */
public interface NewOrederAPI {
    @FormUrlEncoded
    @POST("/startNewOrder.php")
    void getUserPosts(@Field("userid") String userid,
                      @Field("tableid") String tableid , Callback<NewOrderPojo> res);
}
