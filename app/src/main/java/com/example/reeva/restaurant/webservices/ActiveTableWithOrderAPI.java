package com.example.reeva.restaurant.webservices;

import com.example.reeva.restaurant.model.TablePojo;

import java.util.List;

import retrofit.Callback;
import retrofit.http.Field;
import retrofit.http.GET;
import retrofit.http.POST;

/**
 * Created by Reeva on 9/29/2015.
 */
public interface ActiveTableWithOrderAPI {
    @GET("/activeTablesWithOrderId.php")
    void getUserPosts(Callback<List<TablePojo>> posts);

}
