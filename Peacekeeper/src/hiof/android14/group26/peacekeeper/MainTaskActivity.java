package hiof.android14.group26.peacekeeper;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainTaskActivity extends Activity {

	private Button buttonClick;
	 
    public void onCreate(Bundle savedInstanceState) {
    	
    	final Context context = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_task);
 
        buttonClick = (Button) findViewById(R.id.buttonAlert);
 
        // add listener to button 
        buttonClick.setOnClickListener(new OnClickListener() {
        	
        	AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
    				context);
 
            @Override
            public void onClick(View arg0) {
 
                // Create custom dialog object
                final Dialog dialog = new Dialog(MainTaskActivity.this);
                // Include dialog.xml file
                dialog.setContentView(R.layout.task_price_alert);
                // Set dialog title
                dialog.setTitle("Custom Dialog");
 
                // set values for custom dialog components - text, image and button
                TextView text = (TextView) dialog.findViewById(R.id.price);
                text.setText("Custom dialog Android example.");
 
             // set title
    			alertDialogBuilder.setTitle("Your Title");
     
    			// set dialog message
    			alertDialogBuilder
    				.setMessage("Click yes to exit!")
    				.setCancelable(false)
    				.setPositiveButton("Yes",new DialogInterface.OnClickListener() {
    					public void onClick(DialogInterface dialog,int id) {
    						// if this button is clicked, close
    						// current activity
    						MainTaskActivity.this.finish();
    					}
    				  })
    				.setNegativeButton("No",new DialogInterface.OnClickListener() {
    					public void onClick(DialogInterface dialog,int id) {
    						// if this button is clicked, just close
    						// the dialog box and do nothing
    						dialog.cancel();
    					}
    				});
     
    				// create alert dialog
    				AlertDialog alertDialog = alertDialogBuilder.create();
     
    				// show it
    				alertDialog.show();
    			}
    		});
 
    }
 
}