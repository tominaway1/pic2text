package com.example.pic2text;
 
import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
 
public class OptionActivity extends Activity {
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.option);
        
        Button button1 = (Button) findViewById(R.id.Button01);
        button1.setOnClickListener(new View.OnClickListener() {
             
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                startActivity(new Intent("com.tutorial.TAKE_PICTURE"));
            }
        });
    }
 
}