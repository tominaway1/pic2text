package com.example.pic2text;
 
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
 
public class TakePicture extends Activity {
int TAKE_PHOTO_CODE = 0;
public static int count=0;
protected static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 0;


/** Called when the activity is first created. */
@SuppressLint("NewApi")
@Override
public void onCreate(Bundle savedInstanceState)
{
    super.onCreate(savedInstanceState);
    setContentView(R.layout.takepicture);

//here,we are making a folder named picFolder to store pics taken by the camera using this application
        final String dir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES) + "/picFolder/"; 
        File newdir = new File(dir); 
        newdir.mkdirs();
    Button convert = (Button) findViewById(R.id.convertF);
    convert.setOnClickListener(new View.OnClickListener() {
    	
    	 @Override
         public void onClick(View v) {
             // TODO Auto-generated method stub
             startActivity(new Intent("com.tutorial.CONVERT"));
         }
     });
    
    
    
    Button capture = (Button) findViewById(R.id.btnCapture);
    capture.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            // here,counter will be incremented each time,and the picture taken by camera will be stored as 1.jpg,2.jpg and likewise.
            count++;
            String file = dir+count+".jpg";
            File newfile = new File(file);
            try {
                newfile.createNewFile();
            } catch (IOException e) {}       

            Uri outputFileUri = Uri.fromFile(newfile);

            Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE); 
            cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, outputFileUri);

            startActivityForResult(cameraIntent, TAKE_PHOTO_CODE);
        }
    });
}

@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    //
//    if (requestCode == TAKE_PHOTO_CODE && resultCode == RESULT_OK) {
//    	Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
//        ImageView image = (ImageView) findViewById(R.id.returnedPic);  
//        image.setImageBitmap(thumbnail);  
//
//        String pathToImage = mImageCaptureUri.getPath();
//
//        // pathToImage is a path you need. 
//
//        // If image file is not in there, 
//        //  you can save it yourself manually with this code:
//        File file = new File(mImageCaptureUri.getPath());
//        FileOutputStream fOut = new FileOutputStream(file);
//        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fOut); // You can choose any format you want
//	}
    Intent imageIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
    String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
    File imagesFolder = new File(Environment.getExternalStorageDirectory(), "MyImages");
    imagesFolder.mkdirs();
    String filePath = "/MyImages/QR_" + timeStamp + ".png" ;
    File image = new File(imagesFolder, "QR_" + timeStamp + ".png");
    Uri uriSavedImage = Uri.fromFile(image);

    imageIntent.putExtra(MediaStore.EXTRA_OUTPUT, uriSavedImage);
    startActivityForResult(imageIntent, CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);
}
}