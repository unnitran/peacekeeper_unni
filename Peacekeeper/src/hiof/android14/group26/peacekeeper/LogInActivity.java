package hiof.android14.group26.peacekeeper;

import android.os.Bundle;
import android.view.View;
import android.app.Activity;
import android.content.Intent;

public class LogInActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.login_account);
	}
	
	public void startLoggedInActivity(View view) {
		Intent intent = new Intent(this, MainActivity.class);
		
		startActivity(intent);
	}
	
}