package com.example.reeva.restaurant.webservices;


import android.support.annotation.VisibleForTesting;

import com.example.reeva.restaurant.model.LoginModel;


import retrofit.Callback;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

/**
 * Created by SmartCoder on 17/04/2015.
 */
public interface AuthenticationAPI {
@FormUrlEncoded
    @POST("/userLogin.php")
    void login(@Field("username") String username,
               @Field("password") String userpwd,
               Callback<LoginModel> response);


//    @Multipart
//    @POST("/register")
//    void register(@Part("image") TypedFile image,
//                  @Part("username") String username,
//                  @Part("password") String Password,
//                  @Part("email") String email,
//                  @Part("countryid") String countryid,
//                  @Part("logintype") String logintype,
//                  Callback<ResponseModel> response);
//
//
//    @Multipart
//    @POST("/register")
//    void fbregister(@Part("username") String username,
//                    @Part("password") String Password,
//                    @Part("email") String email,
//                    @Part("countryid") String countryid,
//                    @Part("logintype") String logintype,
//                    @Part("name") String name,
//                    Callback<ResponseModel> response);
}
