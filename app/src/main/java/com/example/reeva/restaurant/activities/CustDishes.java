
package com.example.reeva.restaurant.activities;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.example.reeva.restaurant.R;
import com.example.reeva.restaurant.model.CustCuisineListPojo;
import com.example.reeva.restaurant.model.CustDishesPojo;
import com.example.reeva.restaurant.model.DishOrderPojo;
import com.example.reeva.restaurant.model.M;
import com.example.reeva.restaurant.model.OrderByOrderidPojo;
import com.example.reeva.restaurant.webservices.APIService;
import com.example.reeva.restaurant.webservices.CustDishesAPI;
import com.example.reeva.restaurant.webservices.GetOrderByOrderIDAPI;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class CustDishes extends AppCompatActivity {
    private RecyclerView mRecyclerView1;
    private RecyclerView.Adapter recycleradapternew;
    Button btncheckorder;
    private RecyclerView.LayoutManager mLayoutManager;
    Handler handler;
    private RecyclerView.Adapter mAdapter;
    public List<CustDishesPojo> custdisheslist = new ArrayList<CustDishesPojo>();
    ArrayList<String> custdishidlist = new ArrayList<String>();

    ArrayList<String> custcuiidlist = new ArrayList<String>();
    ArrayList<String> custdnamelist = new ArrayList<String>();
    ArrayList<String> custdtypelist = new ArrayList<String>();
    ArrayList<String> custdeslist = new ArrayList<String>();
    ArrayList<String> custdpricelist = new ArrayList<String>();
    ArrayList<String> custimglist = new ArrayList<String>();
    public String cuisineid=CustCuisine.cuiposid;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cust_dishes);
        mRecyclerView1 = (RecyclerView) findViewById(R.id.my_recycler_view1);
        mRecyclerView1.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView1.setLayoutManager(mLayoutManager);
        btncheckorder = (Button)findViewById(R.id.btncheckorder);

        btncheckorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(CustDishes.this, GetDishies.class);
                finish();
                startActivity(i);
            }
        });

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Table Name: " + AppConst.tablename);
        getSupportActionBar().setSubtitle("Order By: " + M.getUsername(this));


        getCustDishes();
    }


    //get cust dishes


    private void getCustDishes() {
        M.showLoadingDialog(CustDishes.this);
        CustDishesAPI mCommentsAPI = APIService.createService(CustDishesAPI.class);
        mCommentsAPI.getUserPosts(cuisineid, new Callback<List<CustDishesPojo>>() {


            @Override
            public void success(List<CustDishesPojo> custDishesPojos, Response response) {
                Log.e("response", response.toString());
                Log.e("getdishes",custdisheslist.size()+"");
                if (custDishesPojos != null) {


                    custdisheslist = custDishesPojos;


                    for (CustDishesPojo custdishesdata : custdisheslist) {
                        String cstdishid=custdishesdata.getDishid();
                        String cstcuiid=custdishesdata.getCusineid();

                        String cstdishname=custdishesdata.getDishname();

                        String cstdishtype=custdishesdata.getDishtype();

                        String cstdes=custdishesdata.getDescription();

                        String cstprice=custdishesdata.getPrice();

                        String cstdimg=custdishesdata.getDishimage();
                        custdishidlist.add(cstdishid);
                        custcuiidlist.add(cstcuiid);
                        custdnamelist.add(cstdishname);
                        custdtypelist.add(cstdishtype);
                        custdeslist.add(cstdes);
                        custdpricelist.add(cstprice);
                        custimglist.add(cstdimg);


                        Log.e("cuiid", cstcuiid + "");
                        Log.e("did", cstdishid + "");
                        Log.e("dname", cstdishname );
                        Log.e("dtype", cstdishtype+"");
                        Log.e("des", cstdes);
                        Log.e("pri", cstprice);
                        Log.e("img", cstdimg);

                    }
                    recycleradapternew = new RecycleViewAdapterNew(CustDishes.this, getApplicationContext(), custdisheslist);
                  Log.e("dnmae",custdnamelist+"");
                    Log.e("dishlist",custdisheslist+"");
                    mRecyclerView1.setAdapter(recycleradapternew);

                }
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
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_cust_dishes, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == android.R.id.home) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed()
    {
       finish();
    }
}

