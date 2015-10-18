package com.example.reeva.restaurant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.reeva.restaurant.activities.GetAllTables;
import com.example.reeva.restaurant.activities.Login;
import com.example.reeva.restaurant.model.ConnectionDetector;
import com.example.reeva.restaurant.model.LoginModel;
import com.example.reeva.restaurant.model.M;
import com.example.reeva.restaurant.webservices.APIService;
import com.example.reeva.restaurant.webservices.AuthenticationAPI;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class SplashActivity extends AppCompatActivity {

    String username, password;
    ConnectionDetector connectionDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ImageLoader imageLoader = ImageLoader.getInstance();
        if (!imageLoader.isInited()) {
            imageLoader.init(ImageLoaderConfiguration.createDefault(this));
        }
        connectionDetector = new ConnectionDetector(this);
        if (!connectionDetector.isConnectingToInternet()) {

            M.showToast(this, "No Internet Connection");
            finish();
        } else {


            if (M.getUsername(this) == null) {
                Intent mIntent = new Intent(this, Login.class);
                startActivity(mIntent);
                finish();
            } else {

                username = M.getUsername(this);
                password = M.getPassword(this);
                checkuser();
            }
        }
    }

    public void checkuser() {
        AuthenticationAPI mAuthenticationAPI = APIService.createService(AuthenticationAPI.class);
        mAuthenticationAPI.login(username, password, new Callback<LoginModel>() {
            @Override
            public void success(LoginModel loginModel, Response response) {
                System.out.println("response===" + loginModel.getUserid());
                if (loginModel.getSuccess().equals("1")) {

                    M.setID(loginModel.getUserid(), SplashActivity.this);

                    Intent mIntent = new Intent(SplashActivity.this, GetAllTables.class);
                    startActivity(mIntent);
                    finish();
                } else {
                    Intent mIntent = new Intent(SplashActivity.this, Login.class);
                    startActivity(mIntent);
                    finish();
                }
            }

            @Override
            public void failure(RetrofitError error) {
                Intent mIntent = new Intent(SplashActivity.this, Login.class);
                startActivity(mIntent);
                finish();

            }
        });
    }
}
