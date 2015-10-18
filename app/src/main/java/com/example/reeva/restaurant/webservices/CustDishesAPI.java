package com.example.reeva.restaurant.webservices;

import com.example.reeva.restaurant.model.CustDishesPojo;
import com.example.reeva.restaurant.model.OrderByOrderidPojo;

import java.util.List;

import retrofit.Callback;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

/**
 * Created by Reeva on 10/10/2015.
 */
public interface CustDishesAPI {
    @FormUrlEncoded
    @POST("/getDishByCusineId.php")
    void getUserPosts(@Field("cusineid") String cusineid, Callback<List<CustDishesPojo>> posts);
}
