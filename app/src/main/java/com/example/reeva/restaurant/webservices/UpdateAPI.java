package com.example.reeva.restaurant.webservices;

import com.example.reeva.restaurant.activities.Order;
import com.example.reeva.restaurant.model.TablePojo;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

/**
 * Created by Reeva on 9/25/2015.
 */
public interface UpdateAPI {

    @POST("/updateorder.php")
    void getUserPosts(@Body List<Order> orderlist, Callback<JSONObject> posts);

}
