package com.example.reeva.restaurant.activities;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.reeva.restaurant.R;
import com.example.reeva.restaurant.model.CustDishesPojo;
import com.example.reeva.restaurant.model.DishOrderPojo;
import com.example.reeva.restaurant.view.ImageUtil;
import com.nispok.snackbar.Snackbar;
import com.nispok.snackbar.SnackbarManager;
import com.nispok.snackbar.listeners.ActionClickListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Reeva on 10/12/2015.
 */
public class RecycleViewAdapterNew extends RecyclerView.Adapter<RecycleViewAdapterNew.DataObjectHolder> {
    View view;
    DishOrderPojo custorder;
    int quan;

  /*public  int  quan;*/

    Context mcontext;
    public List<CustDishesPojo> custdisheslist = new ArrayList<CustDishesPojo>();
    private static String LOG_TAG = "MyRecyclerViewAdapter";
    Activity activity;



    public RecycleViewAdapterNew(Activity activity, Context mcontext, List<CustDishesPojo> custdisheslist) {
        this.mcontext = mcontext;
        this.custdisheslist = custdisheslist;
        this.activity = activity;
    }
    public static class DataObjectHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imgdish;
        EditText edtqty;
        TextView txtdname,txtdec,txtprice;
        Button btnadd, imginc, imgdec;



        public DataObjectHolder(View itemView) {
            super(itemView);
            txtdname = (TextView) itemView.findViewById(R.id.txtcustdishname);


            edtqty=(EditText)itemView.findViewById(R.id.edtqty);
            imginc=(Button)itemView.findViewById(R.id.imgdinc);
            imgdec=(Button)itemView.findViewById(R.id.imgddec);
             btnadd=(Button)itemView.findViewById(R.id.custadd);
            txtdec = (TextView) itemView.findViewById(R.id.txtcustdescription);
            txtprice = (TextView) itemView.findViewById(R.id.txtcustdishprice);
            imgdish=(ImageView)itemView.findViewById(R.id.imgdishesimg);



            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

        }
    }


    @Override
    public DataObjectHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_custdishes_list, parent, false);
        // parent.setBackgroundColor(Color.CYAN);
       DataObjectHolder dataobjectholder = new DataObjectHolder(view);


        return dataobjectholder;
    }

    @Override
    public void onBindViewHolder(final DataObjectHolder holder, final int position) {
        holder.txtdname.setText(custdisheslist.get(position).getDishname());

        holder.txtdec.setText(custdisheslist.get(position).getDescription());
        holder.txtprice.setText(AppConst.currency+". "+custdisheslist.get(position).getPrice());


        ImageUtil.displayRoundImage(holder.imgdish, AppConst.URL + custdisheslist.get(position).getDishimage(), null);

      holder.imginc.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              quan = Integer.valueOf(holder.edtqty.getText().toString());

              quan++;
              holder.edtqty.setText(quan + "");

          }

      });
        holder.imgdec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quan = Integer.valueOf(holder.edtqty.getText().toString());
                if (quan == 1) {
                    return;
                } else {
                    quan--;
                    holder.edtqty.setText(quan + "");
                }
            }
        });
        holder.btnadd.setTag("" + position);
        holder.btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                custorder = new DishOrderPojo();
                quan = Integer.valueOf(holder.edtqty.getText().toString());
                int pos = Integer.valueOf(holder.btnadd.getTag().toString());
                String poscustdisid = custdisheslist.get(pos).getDishid();
                String poscustdishname = custdisheslist.get(pos).getDishname();

                custorder.setDishid(poscustdisid);
                custorder.setDishname(poscustdishname);
                custorder.setQty(quan + "");
                custorder.setIsnew(true);
                custorder.setStatus("0");
                if(AppConst.dishorederlist != null) {
                    AppConst.dishorederlist.add(custorder);
                }else
                {
                    AppConst.dishorederlist = new ArrayList<DishOrderPojo>();
                    AppConst.dishorederlist.add(custorder);
                }

                SnackbarManager.show(
                        Snackbar.with(activity) // context
                                .text("Dish added to your order!") // text to display
                                .textColor(Color.YELLOW)
                                .actionLabel("REMOVE")
                                 .actionColor(Color.RED)// action button label
                                .actionListener(new ActionClickListener() {
                                    @Override
                                    public void onActionClicked(com.nispok.snackbar.Snackbar snackbar) {

                                        AppConst.dishorederlist.remove(AppConst.dishorederlist.size()-1);
                                    }


                                }) // action button's ActionClickListener
                        , activity); // activity where it is displayed

                Log.e("pos", poscustdishname + "");
                Log.e("posdishid",poscustdishname+ "");

            }
        });
        Log.e("image1", custdisheslist.get(position).getDishimage() + "");
        Log.e("name", custdisheslist.get(position).getDishname() + "");
        Log.e("type", custdisheslist.get(position).getDishtype() + "");


    }

    @Override
    public int getItemCount() {
        Log.e("dishes",custdisheslist.size()+"");
        return custdisheslist.size();


    }
}
