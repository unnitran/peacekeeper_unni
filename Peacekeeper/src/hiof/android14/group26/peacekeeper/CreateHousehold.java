package hiof.android14.group26.peacekeeper;

import android.os.AsyncTask;
import hiof.android14.group26.peacekeeper.models.Household;

public class CreateHousehold extends AsyncTask<Void, Void, Household>{

	@Override
	protected Household doInBackground(Void... params) {

		Household house = MainActivity.getDatasource().createHousehold("Skeiva");
		
		return house;
	}

}
