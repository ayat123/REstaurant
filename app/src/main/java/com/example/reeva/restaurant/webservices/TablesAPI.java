package com.example.reeva.restaurant.webservices;

import com.example.reeva.restaurant.model.InactivTPojo;
import com.example.reeva.restaurant.model.TablePojo;

import java.util.List;

import retrofit.Callback;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Part;
import retrofit.http.Path;


/**
 * Created by Reeva on 9/21/2015.
 */
public interface TablesAPI {
    @FormUrlEncoded
    @POST("/getActiveTables.php")
    void getUserPosts(@Field("status") String status,Callback<List<InactivTPojo>> posts);

}
