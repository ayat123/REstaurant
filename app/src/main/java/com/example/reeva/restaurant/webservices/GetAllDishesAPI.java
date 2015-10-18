package com.example.reeva.restaurant.webservices;

import com.example.reeva.restaurant.model.DishiesPojo;

import java.util.List;

import retrofit.Callback;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;

/**
 * Created by Reeva on 9/23/2015.
 */
public interface GetAllDishesAPI {

    @GET("/getAllDish.php")
    void getUserPosts(Callback<List<DishiesPojo>> posts);
}
