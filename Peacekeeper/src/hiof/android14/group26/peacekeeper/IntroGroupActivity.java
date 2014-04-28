package hiof.android14.group26.peacekeeper;

import android.os.Bundle;
import android.view.View;
import android.app.Activity;
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
}