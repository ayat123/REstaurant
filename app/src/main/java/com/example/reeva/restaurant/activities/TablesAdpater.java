package com.example.reeva.restaurant.activities;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import com.example.reeva.restaurant.R;
import com.example.reeva.restaurant.model.TablePojo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Reeva on 9/22/2015.
 */
public class TablesAdpater extends BaseAdapter {

    public List<TablePojo> tablelist = new ArrayList<TablePojo>();
    Context context;
    public TablesAdpater(  Context context,List<TablePojo> tablelist  ) {


this.tablelist=tablelist;
        this.context = context;
    }

    @Override
    public int getCount() {
        return tablelist.size();
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
            row = inflater.inflate(R.layout.activity_custom_view_grid, parent, false);

        } else {
        }


        TextView txttname=(TextView)row.findViewById(R.id.txttblname);

       txttname.setText(tablelist.get(position).getTablename());
        return row;
    }
    }


