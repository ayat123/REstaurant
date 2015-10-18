package com.example.reeva.restaurant.activities;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.reeva.restaurant.R;
import com.example.reeva.restaurant.model.DishOrderPojo;
import com.example.reeva.restaurant.model.InactivTPojo;
import com.example.reeva.restaurant.model.M;
import com.example.reeva.restaurant.model.NewOrderPojo;
import com.example.reeva.restaurant.model.OrderByOrderidPojo;
import com.example.reeva.restaurant.model.TablePojo;
import com.example.reeva.restaurant.webservices.APIService;
import com.example.reeva.restaurant.webservices.ActiveTableWithOrderAPI;
import com.example.reeva.restaurant.webservices.GetOrderByOrderIDAPI;
import com.example.reeva.restaurant.webservices.NewOrederAPI;
import com.example.reeva.restaurant.webservices.TablesAPI;
import com.melnykov.fab.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Reeva on 9/21/2015.
 */
public class GetAllTables extends AppCompatActivity {
    public static String actorderdetailid;
    public static String activetblorderid;
    public static String acttblid;
    public static String orderid;
    public List<OrderByOrderidPojo> orderidbyorderidlist = new ArrayList<>();
    public List<InactivTPojo> inatablelist = new ArrayList<InactivTPojo>();
    public List<TablePojo> tablelist = new ArrayList<TablePojo>();
    public List<DishOrderPojo> dishorederlist = new ArrayList<DishOrderPojo>();
    GridView grd;
    String tblstatus, tableid, userid;
    ArrayList<String> oorderdetailidlist=new ArrayList<>();
    ArrayList<String> ostatuslist=new ArrayList<>();
    ArrayList<String> odishidlist = new ArrayList<String>();
    ArrayList<String> odishnamelist = new ArrayList<String>();
    ArrayList<String> oquantitylist = new ArrayList<String>();
    ArrayList<String> opricelist = new ArrayList<String>();
    ArrayList<String> tblidlistina = new ArrayList<String>();
    ArrayList<String> tblnamelistina = new ArrayList<String>();
    ArrayList<String> tblstatuslistina = new ArrayList<>();
    ArrayList<String> orderidlist = new ArrayList<String>();
    ArrayList<String> tblidlist = new ArrayList<String>();
    ArrayList<String> tblnamelist = new ArrayList<String>();
    String status1 = "0";
    TextView txttable;
    private TablesAdpater tbladapter;
    private InactivetableAdapter inactivetableadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_all_tables);



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        grd = (GridView) findViewById(R.id.grd1);
        fab.attachToListView(grd);
        fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                final Dialog dialog = new Dialog(GetAllTables.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);

                dialog.getWindow().setLayout(LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT);
                dialog.setContentView(R.layout.dialog_new_order);
                dialog.getWindow().setBackgroundDrawable(
                        new ColorDrawable(android.graphics.Color.TRANSPARENT));

                txttable = (TextView) dialog.findViewById(R.id.txttable);

                txttable.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        selecttale();
                    }
                });

                dialog.show();
                getInactiveTables();
                Button btnButton = (Button) dialog.findViewById(R.id.btnorder);
                btnButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        M m = new M();
                        if(AppConst.dishorederlist !=null) {
                            AppConst.dishorederlist.clear();
                        }
                        userid = M.getID(GetAllTables.this);
                        Log.e("userid", M.getID(GetAllTables.this));
                        getOrderId();
                        dialog.dismiss();
                    }
                });

            }
        });


        getTables();




    }

    void getOrderId() {
        M.showLoadingDialog(GetAllTables.this);
        NewOrederAPI mCommentsAPI = APIService.createService(NewOrederAPI.class);
        mCommentsAPI.getUserPosts(userid, tableid, new Callback<NewOrderPojo>() {

            @Override
            public void success(NewOrderPojo newOrderPojo, Response response) {
                M.hideLoadingDialog();
                Log.e("tableid", tableid);
                AppConst.currentorderid = newOrderPojo.getOrderid().toString();

                Intent intent = new Intent(getApplicationContext(), GetDishies.class);
                finish();
                startActivity(intent);

                Log.e("response", response.toString());
            }

            @Override
            public void failure(RetrofitError error) {
                M.hideLoadingDialog();
                Log.e("error", error.getMessage());
            }
        });


    }


    //Get Inactive tables list

    public void selecttale() {
        final ArrayAdapter<String> adapter;
        final Dialog myDialog = new Dialog(GetAllTables.this);
        myDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        myDialog.getWindow().setLayout(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        myDialog.setContentView(R.layout.custom_spinner_dialog);
        myDialog.getWindow().setBackgroundDrawable(
                new ColorDrawable(android.graphics.Color.TRANSPARENT));

        TextView txtheader = (TextView) myDialog.findViewById(R.id.txtheader);

        txtheader.setText("Select table");


        final ListView listview = (ListView) myDialog
                .findViewById(R.id.spinnerlist);

        adapter = new ArrayAdapter<String>(GetAllTables.this,
                android.R.layout.select_dialog_item, tblnamelistina);

        listview.setAdapter(adapter);

        if (tblidlistina.size() > 0) {
            tableid = tblidlistina.get(0).toString();
            listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, View view,
                                        int position, long id) {
                    // TODO Auto-generated method stub
                    myDialog.dismiss();


                    tableid = tblidlistina.get(position).toString();
                    txttable.setText(tblnamelistina.get(position).toString());
                    Log.e("tablesize", tblidlistina.size() + "");

                    Log.e("tableid", tableid);
                }
            });
        }
        myDialog.show();

    }


//get ActiveTables list

    private void getInactiveTables() {

        M.showLoadingDialog(GetAllTables.this);
        TablesAPI mCommentsAPI = APIService.createService(TablesAPI.class);
        mCommentsAPI.getUserPosts(status1, new Callback<List<InactivTPojo>>() {

            @Override
            public void success(List<InactivTPojo> inactivTPojos, Response response) {
                inatablelist.clear();
                Log.e("table", inatablelist.size() + "");
                if (inactivTPojos != null) {


                    inatablelist = inactivTPojos;


                    for (InactivTPojo tabledata : inatablelist) {

                        String id = tabledata.getId();
                        String tblname = tabledata.getName();
                        tblstatus = (tabledata.getStatus());
                        Log.e("statusin", tblstatus + "");


                        tblidlistina.add(id);
                        Log.e("tblinid", tabledata.getId() + "");
                        Log.e("tblinname", tabledata.getName() + "");
                        tblnamelistina.add(tblname);
                        tblstatuslistina.add(tblstatus);



                    }
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

    // get orderid by order id

    private void getTables() {

        M.showLoadingDialog(GetAllTables.this);
        ActiveTableWithOrderAPI mCommentsAPI = APIService.createService(ActiveTableWithOrderAPI.class);
        mCommentsAPI.getUserPosts(new Callback<List<TablePojo>>() {
            @Override
            public void success(List<TablePojo> tablePojos, Response response) {
                tablelist.clear();
                Log.e("table", tablelist.size() + "");
                if (tablePojos != null) {


                    tablelist = tablePojos;


                    for (TablePojo tabledata : tablelist) {
                         String orderid = tabledata.getOrderid();
                         String tblid = tabledata.getTableid();
                         String tblname = tabledata.getTablename();


                         orderidlist.add(orderid);
                         tblidlist.add(tblid);
                         tblnamelist.add(tblname);

                        Log.e("activeorderid", tabledata.getOrderid() + "");
                        Log.e("tblid", tabledata.getTableid() + "");
                        Log.e("tblname", tabledata.getTablename() + "");



                    }
                }


                tbladapter = new TablesAdpater(getApplicationContext(), tablelist);

                grd.setAdapter(tbladapter);
                grd.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        AppConst.currentorderid=orderidlist.get(position).toString();
                        AppConst.tableid=tblidlist.get(position).toString();

                        GetAllTables.activetblorderid=activetblorderid;
                        Log.e("acorderid",orderidlist.get(position).toString());
                        Log.e("actbl",tblidlist.get(position).toString());

                        getorderidByorderid();
                        Log.e("orderidsize", orderidbyorderidlist.size() + "");

                    }
                });


                M.hideLoadingDialog();
            }

            @Override
            public void failure(RetrofitError error) {
                M.hideLoadingDialog();

                Log.e("error", error.getMessage());
            }


        });
    }

    private void getorderidByorderid() {

        M.showLoadingDialog(GetAllTables.this);
        GetOrderByOrderIDAPI mCommentsAPI = APIService.createService(GetOrderByOrderIDAPI.class);
        mCommentsAPI.getUserPosts( AppConst.currentorderid, new Callback<List<OrderByOrderidPojo>>() {


            @Override
            public void success(List<OrderByOrderidPojo> orderByOrderidPojos, Response response) {
                Log.e("table", orderidbyorderidlist.size() + "");
                if (orderByOrderidPojos != null) {


                    orderidbyorderidlist = orderByOrderidPojos;

                    if( AppConst. dishorederlist!=null) {
                        AppConst.dishorederlist.clear();
                    }
                    for (OrderByOrderidPojo orderdata : orderidbyorderidlist) {
                        String orderdetailid=orderdata.getOrderdetailid();
                        String ostatus=orderdata.getStatus();

                        Log.e("status",ostatus);
                        String odishid = orderdata.getDishid();
                        String odishname=orderdata.getDishname();
                        String oquantity = orderdata.getQuantity();
                        String oprice = orderdata.getPrice();
                        oorderdetailidlist.add(orderdetailid);

                        ostatuslist.add(ostatus);

                        odishidlist.add(odishid);
                        odishnamelist.add(odishname);
                        oquantitylist.add(oquantity);
                        opricelist.add(oprice);
                        Log.e("odishid", orderdata.getDishid() + "");
                        Log.e("odishname", orderdata.getDishname() + "");
                        Log.e("oquantity", orderdata.getQuantity() + "");
                        Log.e("oprice", orderdata.getPrice() + "");

                        DishOrderPojo order=new DishOrderPojo();
                        order.setDishid(odishid);
                        order.setDishname(odishname);
                        order.setQty(oquantity);
                        order.setOrderdetailid(orderdetailid);
                        order.setStatus(ostatus);

                        order.setIsnew(false);



                        dishorederlist.add(order);


                        AppConst.dishorederlist=dishorederlist;

                        Intent intent=new Intent(getApplicationContext(),GetDishies.class);
                        finish();
                        startActivity(intent);




                    }
                }


                M.hideLoadingDialog();
            }

            @Override
            public void failure(RetrofitError error) {
                M.hideLoadingDialog();

                Intent intent=new Intent(getApplicationContext(),GetDishies.class);
                finish();
                startActivity(intent);
                Log.e("error", error.getMessage());
            }
        });
    }
}



