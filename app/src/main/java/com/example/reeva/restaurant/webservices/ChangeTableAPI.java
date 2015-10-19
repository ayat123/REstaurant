package com.example.reeva.restaurant.webservices;

import com.example.reeva.restaurant.model.NewOrderPojo;

import java.util.List;

import retrofit.Callback;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

/**
 * Created by Reeva on 9/23/2015.
 */
public interface ChangeTableAPI {
    @FormUrlEncoded
    @POST("/changeTable.php")
    void changeTable(@Field("orderid") String orderid,
                      @Field("tableid") String tableid, Callback<String> res);
}
