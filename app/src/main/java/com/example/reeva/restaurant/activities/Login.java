package com.example.reeva.restaurant.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.example.reeva.restaurant.R;
import com.example.reeva.restaurant.model.ConnectionDetector;
import com.example.reeva.restaurant.model.LoginModel;
import com.example.reeva.restaurant.model.M;
import com.example.reeva.restaurant.webservices.APIService;
import com.example.reeva.restaurant.webservices.AuthenticationAPI;

import java.util.ArrayList;

import retrofit.Callback;
import retrofit.RetrofitError;

/**
 * Created by Reeva on 9/21/2015.
 */
public class Login extends AppCompatActivity implements OnClickListener {
    EditText etusername, etpassword;
    Button btnlogin;
    String username, password;
    ConnectionDetector connectionDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        connectionDetector = new ConnectionDetector(this);
        btnlogin = (Button) findViewById(R.id.btnlogin);

        etusername = (EditText) findViewById(R.id.etusername);
        etpassword = (EditText) findViewById(R.id.etpassword);

        btnlogin.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnlogin) {
            username = etusername.getText().toString().trim();
            password = etpassword.getText().toString().trim();
            if (username.length() <= 2) {
                etusername.setError("Invalid Username");
            } else if (password.length() <= 5) {
                etpassword.setError("Invalid Password");
            } else {
                login();
            }
        }
    }



    public void login()
    {
        if(connectionDetector.isConnectingToInternet()) {
            M.showLoadingDialog(this);
            AuthenticationAPI mAuthenticationAPI = APIService.createService(AuthenticationAPI.class);
            mAuthenticationAPI.login(username, password, new Callback<LoginModel>() {
                @Override
                public void success(LoginModel loginModel, retrofit.client.Response response) {
                    M.hideLoadingDialog();

                    System.out.println(" test response---" + response.getUrl());


                    if (loginModel.getSuccess().equals("1")) {

                        M.setID(loginModel.getUserid(), Login.this);
                       Log.e("uid", loginModel.getUserid() + "");
                        M.setPassword(password, Login.this);
                        M.setUsername(username, Login.this);
                        Intent mIntent = new Intent(Login.this, GetAllTables.class);

                        startActivity(mIntent);
                        finish();
                    } else {
                        M.showToast(Login.this, "Username or Password Invalid");
                    }

                }

                @Override
                public void failure(RetrofitError error) {


                    M.hideLoadingDialog();
                    M.T(Login.this, getString(R.string.ServerError));
                    M.T(Login.this, ""+error.getMessage());
                }
            });
        }else
        {
            M.showToast(Login.this, "No Internet Connection");
        }
    }



}
