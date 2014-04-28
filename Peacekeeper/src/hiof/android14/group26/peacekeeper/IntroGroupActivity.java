package hiof.android14.group26.peacekeeper;

import android.os.Bundle;
import android.view.View;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;

public class IntroGroupActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.intro_group);
			
	}
	
	public void startCreateGroupActivity(View view) {
		Intent intent = new Intent(this, CreateGroupActivity.class);
		
		startActivity(intent);
	}
	
	public void startJoinGroupActivity(View view) {
		Intent intent = new Intent(this, JoinGroupActivity.class);
		
		startActivity(intent);
	}
	
	public void showInfo(View view){
		// Getting the alert box for use later on                 
	    AlertDialog.Builder alertbox = new AlertDialog.Builder(this);
	    
	    // Strings used
	    String okBtn = getResources().getString(R.string.ok);
	    String alertBoxContent = getResources().getString(R.string.infoBox);
	     
	    // Set the message to display
	    alertbox.setMessage(alertBoxContent);
	     
	    // Add a neutral button to the alert box and assign a click listener
	    alertbox.setNeutralButton(okBtn, new DialogInterface.OnClickListener() {
	         
	        // Click listener on the alert box
	        public void onClick(DialogInterface arg0, int arg1) {
	            // The button was clicked - alert box closes.	        	
	        }
	    });
	     
	    // show it
	    alertbox.show();
	}
	
}
