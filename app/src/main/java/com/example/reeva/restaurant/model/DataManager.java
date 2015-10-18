package com.example.reeva.restaurant.model;


import java.io.File;
import java.util.ArrayList;

import android.os.Environment;


	
public class DataManager {

	public static String status = "";
	public static String message = "";

	
		public static String url = "http://swiftomatics.in/FortinRecipe/";
	
	public static String cusinename = "";

	public static String photourl = "http://swiftomatics.in/FortinRecipe/upload/";
	public static int fragmentposition = 0;
	
	public static ArrayList<CuisinePojo> cuisinelist;
	
	public static ArrayList<TagPojo> taglist;
	
	public static ArrayList<RecipePojo> recipelist;
	
	public static int selectedposition =0;
	
	public static String path = Environment.getExternalStorageDirectory()+File.separator;
	
	public static String admobbanner = "ca-app-pub-3531258678473823/9262714881";
	public static String admobfullscreen = "ca-app-pub-3531258678473823/4692914482";
}