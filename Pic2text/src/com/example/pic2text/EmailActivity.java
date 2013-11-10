package com.example.pic2text;
 
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
 
public class EmailActivity extends Activity {
	private Mail m;
	/** Called when the activity is first created. */
	@Override 
	public void onCreate(Bundle savedInstanceState) { 
		super.onCreate(savedInstanceState); 
		setContentView(R.layout.main); 
		m = new Mail("hackprinceton", "cookies"); 
	}
 
	public void sendEmail(View view){
		String[] toArr = {"ti2181@columbia.edu"}; // This is an array, you can add more emails, just separate them with a coma
		m.setTo(toArr); // load array to setTo function
		m.setFrom("barack@whitehouse.gov"); // who is sending the email 
		
		m.setSubject("We need change!"); 
		m.setBody(ResultsActivity.myText); 
 
		try { 
			//m.addAttachment("");  // path to file you want to attach
			if(m.send()) { 
				// success
				Toast.makeText(EmailActivity.this, "Email was sent successfully.", Toast.LENGTH_LONG).show(); 
			} else { 
				// failure
				Toast.makeText(EmailActivity.this, "Email was not sent.", Toast.LENGTH_LONG).show(); 
			} 
		} catch(Exception e) { 
			// some other problem
			e.printStackTrace();
			Toast.makeText(EmailActivity.this, "There was a problem sending the email.", Toast.LENGTH_LONG).show(); 
		} 
 
	}
}