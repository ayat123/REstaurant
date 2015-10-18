package com.example.reeva.restaurant.webservices;

import com.example.reeva.restaurant.model.CustCuisineListPojo;
import com.example.reeva.restaurant.model.DishiesPojo;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by Reeva on 10/10/2015.
 */
public interface CustCuisineListAPI {

    @GET("/getAllCusine.php")
    void getUserPosts(Callback<List<CustCuisineListPojo>> posts);

}
