
package com.example.reeva.restaurant.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.reeva.restaurant.R;
import com.example.reeva.restaurant.model.CustCuisineListPojo;
import com.example.reeva.restaurant.model.DishiesPojo;
import com.example.reeva.restaurant.model.M;
import com.example.reeva.restaurant.webservices.APIService;
import com.example.reeva.restaurant.webservices.CustCuisineListAPI;
import com.example.reeva.restaurant.webservices.GetAllDishesAPI;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class CustCuisine extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter recycleradapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public static String cuiposid;
    public List<CustCuisineListPojo> cuisinelist = new ArrayList<CustCuisineListPojo>();
    ArrayList<String> cuisineidlist = new ArrayList<String>();
    ArrayList<String> cuisinenamelist = new ArrayList<String>();
    ArrayList<String> cuisineimglist = new ArrayList<String>();

    CustCuisineAdapter custcuisineadapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cust_cuisini_list);
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        getCustCuisine();

    }



    // get custcuisinelist

    private void getCustCuisine() {

        M.showLoadingDialog(CustCuisine.this);
        CustCuisineListAPI mCommentsAPI = APIService.createService(CustCuisineListAPI.class);

        mCommentsAPI.getUserPosts(new Callback<List<CustCuisineListPojo>>() {



            @Override
            public void success(List<CustCuisineListPojo> custCuisineListPojos, Response response) {
                if (custCuisineListPojos != null) {


                    cuisinelist = custCuisineListPojos;


                    for (CustCuisineListPojo cuisinedata : cuisinelist) {
                        String cuisineid=cuisinedata.getCusineid();
                        String cuisinename=cuisinedata.getCusinename();
                        String cuisineimg=cuisinedata.getCusineimage();
                        cuisineidlist.add(cuisineid);
                        cuisinenamelist.add(cuisinename);
                        cuisineimglist.add(cuisineimg);
                        Log.e("cuisineid", cuisineid);
                        Log.e("cuisinename",cuisinename);
                        Log.e("cuisineimg",cuisineimg);

                        //db.addTables(new TablePojo(id,tblname,tblstatus));

                    }
                }
                recycleradapter=new RecycleCuisineAdapter(cuisinelist,cuisinenamelist,cuisineimglist,CustCuisine.this);
                mRecyclerView.setAdapter(recycleradapter);


                M.hideLoadingDialog();
            }

            @Override
            public void failure(RetrofitError error) {

                M.hideLoadingDialog();
                Log.e("error", error.getMessage());

            }
        });
    }

    @Override
    public void onBackPressed()
    {
        Intent i = new Intent(this, GetDishies.class);
        finish();
        startActivity(i);
    }

}

