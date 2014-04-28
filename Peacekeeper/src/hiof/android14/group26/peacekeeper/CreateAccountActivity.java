package hiof.android14.group26.peacekeeper;

import android.os.Bundle;
import android.view.View;
import android.app.Activity;
import android.content.Intent;

public class CreateAccountActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.create_account);
	}
	
	public void startIntroGroupActivity(View view) {
		Intent intent = new Intent(this, IntroGroupActivity.class);
		
		startActivity(intent);
	}
}