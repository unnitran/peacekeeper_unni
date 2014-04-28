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
		// prepare the alert box                  
	    AlertDialog.Builder alertbox = new AlertDialog.Builder(this);
	    
	    // Strings used
	    String okBtn = getResources().getString(R.string.ok);
	    String alertBoxContent = getResources().getString(R.string.infoBox);
	     
	    // set the message to display
	    alertbox.setMessage(alertBoxContent);
	     
	    // add a neutral button to the alert box and assign a click listener
	    alertbox.setNeutralButton(okBtn, new DialogInterface.OnClickListener() {
	         
	        // click listener on the alert box
	        public void onClick(DialogInterface arg0, int arg1) {
	            // the button was clicked
	        }
	    });
	     
	    // show it
	    alertbox.show();
	}
	
}
