package com.example.reeva.restaurant.webservices;

import com.example.reeva.restaurant.activities.AppConst;


import retrofit.RestAdapter;

/**
 * Created by SmartCoder on 17/04/2015.
 */
public class APIService {
    public APIService() {

    }



    public static <S> S createService(Class<S> serviceClass) {
        RestAdapter.Builder builder = new RestAdapter.Builder()
                .setEndpoint(AppConst.MAIN);
        RestAdapter adapter = builder.build();

        return adapter.create(serviceClass);
    }
}
