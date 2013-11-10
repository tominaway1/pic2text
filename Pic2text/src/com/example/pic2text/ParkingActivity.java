package com.example.pic2text;
 
import java.util.Date; 

import android.app.Activity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Toast;
 
public class ParkingActivity extends Activity {
	private Mail m;
	/** Called when the activity is first created. */
	@Override 
	public void onCreate(Bundle savedInstanceState) { 
		super.onCreate(savedInstanceState); 
		setContentView(R.layout.main); 
		m = new Mail("hackprinceton", "cookies"); 
	}
 
	@SuppressWarnings("deprecation")
	public void sendEmail(View view) throws InterruptedException{
		String temp = ResultsActivity.myText;
		String message = "You have 30 minutes left before your parking expires";
		if (temp.contains("6 AM")) {
			//message = "You will receive an email from us 30 minutes before your meter expires reminding you to move your car.";
			Date d = new Date(); 
			long diff = d.getTime();
			System.out.println(diff);
			Thread.sleep(1000);
			long diff1 = d.getTime(); 
			while(diff != diff1) {}
		}	
		else
			message = "We were unable to read the time from your pic!"; 
		String[] toArr = {"ti2181@columbia.edu"}; // This is an array, you can add more emails, just separate them with a coma
		m.setTo(toArr); // load array to setTo function
		m.setFrom("barack@whitehouse.gov"); // who is sending the email 
		
		m.setSubject("Reminder"); 
		m.setBody(message); 
		 

		try { 
			//m.addAttachment("");  // path to file you want to attach
			if(m.send()) { 
				// success
				Toast.makeText(ParkingActivity.this, "Email was sent successfully.", Toast.LENGTH_LONG).show(); 
			} else { 
				// failure
				Toast.makeText(ParkingActivity.this, "Email was not sent.", Toast.LENGTH_LONG).show(); 
			} 
		} catch(Exception e) { 
			// some other problem
			e.printStackTrace();
			Toast.makeText(ParkingActivity.this, "There was a problem sending the email.", Toast.LENGTH_LONG).show(); 
		} 
 
	}
}