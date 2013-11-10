package com.example.pic2text;
 
import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
 
public class menuActivity extends Activity {
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        
        Button button3 = (Button) findViewById(R.id.Button03);
        button3.setOnClickListener(new View.OnClickListener() {
             
            @Override
            public void onClick(View v) {
                 //TODO Auto-generated method stub
                startActivity(new Intent("com.tutorial.LOCAT"));
            }
        });
        
        Button button1 = (Button) findViewById(R.id.Button01);
        button1.setOnClickListener(new View.OnClickListener() {
             
            @Override
            public void onClick(View v) {
                 //TODO Auto-generated method stub
                startActivity(new Intent("com.tutorial.PARKING"));
            }
        });
        
        Button button2 = (Button) findViewById(R.id.Button02);
        button2.setOnClickListener(new View.OnClickListener() {
             
            @Override
            public void onClick(View v) {
                 //TODO Auto-generated method stub
                startActivity(new Intent("com.tutorial.EMAIL"));
            }
        });
        
        
    }
 
}