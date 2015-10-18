package com.example.reeva.restaurant.activities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.reeva.restaurant.R;
import com.example.reeva.restaurant.model.InactivTPojo;
import com.example.reeva.restaurant.model.TablePojo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Reeva on 9/23/2015.
 */
public class InactivetableAdapter extends BaseAdapter {
    public List<InactivTPojo> inatablelist = new ArrayList<InactivTPojo>();
    Context context;

    public InactivetableAdapter(Context context,List<InactivTPojo> inatablelist)
    {
        this.context = context;

    this.inatablelist=inatablelist;
    }

    @Override
    public int getCount() {
        return inatablelist.size();
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

        txttname.setText(inatablelist.get(position).getName());
        return row;
    }
}



