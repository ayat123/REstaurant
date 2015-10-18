package com.example.reeva.restaurant.activities;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.reeva.restaurant.R;
import com.example.reeva.restaurant.model.CustCuisineListPojo;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Reeva on 10/10/2015.
 */
public class CustCuisineAdapter extends BaseAdapter {
   public List<CustCuisineListPojo> cuisinelist = new ArrayList<CustCuisineListPojo>();
    ArrayList<String> cuisinenamelist = new ArrayList<String>();
    ArrayList<String> cuisineimglist = new ArrayList<>();
    Context context;

    public CustCuisineAdapter(  List<CustCuisineListPojo> cuisinelist, ArrayList<String> cuisinenamelist, ArrayList<String> cuisineimglist, Context context) {
       this.cuisinelist=cuisinelist;
        this.cuisinenamelist = cuisinenamelist;
        this.cuisineimglist = cuisineimglist;
        this.context = context;
    }

   /* public CustCuisineAdapter(Context context,List<CustCuisineListPojo> cuisinelist,List) {
        this.context=context;

        this.cuisinelist = cuisinelist;
    }*/


    @Override
    public int getCount() {
        return cuisinelist.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row = convertView;
        // parent.setBackgroundColor(Color.CYAN);


        if(row==null)
        {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.custom_list_custcuisinelist, parent, false);

        } else {
        }


        TextView txtcuisinename=(TextView)row.findViewById(R.id.txtcustcuisinename);

        txtcuisinename.setText(cuisinelist.get(position).getCusinename());
        ImageView imgcuisineimg=(ImageView)row.findViewById(R.id.imgcustcuisineimg);
      Picasso.with(context)
                .load(AppConst.URL+cuisinelist.get(position).getCusineimage())
                .into(imgcuisineimg);

        Log.e("image",cuisinelist.get(position).getCusineimage()+"");
        return row;
    }
}
