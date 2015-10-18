package com.example.reeva.restaurant.model;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.util.Patterns;
import android.widget.Toast;

import com.example.reeva.restaurant.R;
import com.example.reeva.restaurant.activities.AppConst;


public class M {
    static ProgressDialog pDialog;
    private static SharedPreferences mSharedPreferences;

    public static void showLoadingDialog(Context mContext) {
        pDialog = new ProgressDialog(mContext);
        pDialog.setMessage(mContext.getString(R.string.please_wait));
        pDialog.setIndeterminate(true);
        pDialog.setCancelable(false);
        pDialog.show();
    }

    public static void hideLoadingDialog() {
        if (pDialog.isShowing()) {
            pDialog.dismiss();
        }
    }

    public static void showToast(Context mContext, String message) {

      Toast.makeText(mContext, message, Toast.LENGTH_LONG).show();

    }

    public static void T(Context mContext, String Message) {
        Toast.makeText(mContext, Message, Toast.LENGTH_SHORT).show();
    }

    public static void L(String Message) {
        Log.e(AppConst.TAG, Message);
    }



    public static boolean setpush(boolean ispushON, Context mContext) {
        mSharedPreferences = mContext.getSharedPreferences("ispushON", 0);
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putBoolean("ispushON", ispushON);
        return editor.commit();
    }

    public static boolean ispushON(Context mContext) {
        mSharedPreferences = mContext.getSharedPreferences("ispushON", 0);
        return mSharedPreferences.getBoolean("ispushON", true);
    }


    public static boolean setUsername(String username, Context mContext) {
        mSharedPreferences = mContext.getSharedPreferences("username", 0);
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString("username", username);
        return editor.commit();
    }

    public static String getUsername(Context mContext) {
        mSharedPreferences = mContext.getSharedPreferences("username", 0);
        return mSharedPreferences.getString("username", null);
    }

    public static boolean setPassword(String password, Context mContext) {
        mSharedPreferences = mContext.getSharedPreferences("password", 0);
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString("password", password);
        return editor.commit();
    }

    public static String getPassword(Context mContext) {
        mSharedPreferences = mContext.getSharedPreferences("password", 0);
        return mSharedPreferences.getString("password", null);
    }

    public static void logOut(Context mContext) {
        setID("", mContext);

        setPassword(null, mContext);
        setUsername(null, mContext);
        setGCM(mContext);
    }

    public static boolean setID(String ID, Context mContext) {
        mSharedPreferences = mContext.getSharedPreferences("settings", 0);
        SharedPreferences.Editor editor = mSharedPreferences.edit();

        editor.putString("userid", ID);
        return editor.commit();
    }

    public static String getID(Context mContext) {
        mSharedPreferences = mContext.getSharedPreferences("settings", 0);
        return mSharedPreferences.getString("userid", "");
    }


    public static boolean setCountryid(int ID, Context mContext) {
        mSharedPreferences = mContext.getSharedPreferences("countryid", 0);
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        System.out.println("countryid--"+ID);
        editor.putInt("countryid", ID);
        return editor.commit();
    }

    public static int getCountryid(Context mContext) {
        mSharedPreferences = mContext.getSharedPreferences("countryid", 0);
        return mSharedPreferences.getInt("countryid", 0);
    }

    public static boolean isValidUrl(String text) {
        return Patterns.WEB_URL.matcher(text).matches();
    }


//
//    public static void setAsWallpaper(Context mContext, Bitmap bitmap) {
//        try {
//            WallpaperManager wm = WallpaperManager.getInstance(mContext);
//
//            wm.setBitmap(bitmap);
//            T(mContext, mContext.getString(R.string.set_as_wallpaper));
//        } catch (Exception e) {
//            e.printStackTrace();
//            T(mContext, e.getMessage());
//        }
//    }
//    public static Uri getLocalBitmapUri(ImageView imageView) {
//        // Extract Bitmap from ImageView drawable
//        Drawable drawable = imageView.getDrawable();
//        Bitmap bmp = null;
//        if (drawable instanceof BitmapDrawable){
//            bmp = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
//        } else {
//            return null;
//        }
//        // Store image to default external storage directory
//        Uri bmpUri = null;
//        try {
//            File file =  new File(Environment.getExternalStoragePublicDirectory(
//                    Environment.DIRECTORY_DOWNLOADS), "share_image_" + System.currentTimeMillis() + ".png");
//            file.getParentFile().mkdirs();
//            FileOutputStream out = new FileOutputStream(file);
//            bmp.compress(Bitmap.CompressFormat.PNG, 90, out);
//            out.close();
//            bmpUri = Uri.fromFile(file);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return bmpUri;
//    }
    public static void showNotification(Context mContext, Intent resultIntent, String title, String text, int id) {
        PendingIntent resultPendingIntent = PendingIntent.getActivity(mContext, 0,
                resultIntent, PendingIntent.FLAG_ONE_SHOT);

        if(M.getUsername(mContext) != null) {
            NotificationCompat.Builder mNotifyBuilder;
            NotificationManager mNotificationManager;

            mNotificationManager = (NotificationManager) mContext.getSystemService(Context.NOTIFICATION_SERVICE);
            long when = System.currentTimeMillis();
            mNotifyBuilder = new NotificationCompat.Builder(mContext)
                    .setContentTitle(title)
                    .setContentText(text)
                    .setWhen(when)
                    .setSmallIcon(R.mipmap.ic_launcher);

            mNotifyBuilder.setContentIntent(resultPendingIntent);

            int defaults = 0;
            defaults = defaults | Notification.DEFAULT_LIGHTS;
            defaults = defaults | Notification.DEFAULT_VIBRATE;
            defaults = defaults | Notification.DEFAULT_SOUND;

            mNotifyBuilder.setDefaults(defaults);
            mNotifyBuilder.setAutoCancel(true);

            mNotificationManager.notify(id, mNotifyBuilder.build());
        }
    }

    public static SharedPreferences.Editor editSharedPref(Context mContext) {
        mSharedPreferences = mContext.getSharedPreferences("settings", 0);
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        return editor;
    }
    public static SharedPreferences getSharedPref(Context mContext) {
        return  mContext.getSharedPreferences("settings", 0);
    }

    public static boolean setGCM(Context mContext) {
        mSharedPreferences = mContext.getSharedPreferences("GCMregistered", 0);
        SharedPreferences.Editor editor = mSharedPreferences.edit();

        editor.putBoolean("GCMregistered", false);
        return editor.commit();
    }



}
