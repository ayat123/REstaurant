package com.example.reeva.restaurant.activities;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.reeva.restaurant.model.CustDishesPojo;
import com.example.reeva.restaurant.model.DishOrderPojo;
import com.example.reeva.restaurant.model.DishiesPojo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Reeva on 9/21/2015.
 */
public class DbRestaurant extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Dbrestaurant";
    public static final int DATABASE_VERSION = 1;
    public static final String TBL_DISH = "tblDishes";
    public static final String KEY_ID = "id";
    public static final String KEY_CUSINEID = "cusineid";
    public static final String KEY_DNAME = "dishnmae";
    public static final String KEY_DTYPE = "dishtype";
    public static final String KEY_DIS = "discription";
    public static final String KEY_PRICE = "price";
    public static final String KEY_DIMG = "dishimage";


    ;

    public DbRestaurant(Context c) {
        super(c, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_DISHES = "CREATE TABLE " + TBL_DISH + "("
                + KEY_ID + " INTEGER PRIMARY KEY, " + KEY_CUSINEID + " TEXT, " + KEY_DNAME + " TEXT, " +
                KEY_DTYPE + " TEXT, " + KEY_DIS + " TEXT, " + KEY_PRICE + " TEXT," + KEY_DIMG + " TEXT" + ")";

        db.execSQL(CREATE_DISHES);

    }



    public void addDishes(DishiesPojo data) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(KEY_CUSINEID, data.getDishid());
        values.put(KEY_DNAME,data.getDishname());
        values.put(KEY_DTYPE,data.getDishtype());
        values.put(KEY_DIS,data.getDescription());
        values.put(KEY_PRICE,data.getPrice());
        values.put(KEY_DIMG,data.getDishimage());

        db.insert(TBL_DISH, null, values);
        db.close(); // Closing database connection
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public List<DishiesPojo> getTempPhotos() {
        List<DishiesPojo> dishdetaillist = new ArrayList<DishiesPojo>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TBL_DISH ;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {

                DishiesPojo data = new DishiesPojo();

                data.setDishid(cursor.getString(cursor
                        .getColumnIndexOrThrow(KEY_CUSINEID)));
               data.setDishname((cursor.getString(cursor.getColumnIndexOrThrow(KEY_DNAME))));
                data.setDishimage((cursor.getString(cursor.getColumnIndexOrThrow(KEY_DIMG))));
                data.setDescription((cursor.getString(cursor.getColumnIndexOrThrow(KEY_DIS))));
                data.setDishtype((cursor.getString(cursor.getColumnIndexOrThrow(KEY_DTYPE))));
                data.setPrice((cursor.getString(cursor.getColumnIndexOrThrow(KEY_PRICE))));
                dishdetaillist.add(data);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        // return contact list
        return dishdetaillist;
    }

}
