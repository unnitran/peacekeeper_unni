package hiof.android14.group26.peacekeeper;

import hiof.android14.group26.peacekeeper.models.User;
import android.os.AsyncTask;

public class CreateUser extends AsyncTask<Void, Void, User>{

	@Override
	protected User doInBackground(Void... params) {
		// TODO Auto-generated method stub
		
		User user = MainActivity.getDatasource().createUser(
				"Per Edvard", "Volla", "test@test.no", "12345678", 1);
		
		return user;
	}
	

}
