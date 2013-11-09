package com.example.pic2text;
 

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;

 
public class ConvertPic extends Activity {
int TAKE_PHOTO_CODE = 0;
public static int count=0;

/** Called when the activity is first created. */
@SuppressLint("NewApi")
@Override
public void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);
    setContentView(R.layout.convertpic);
	}
}