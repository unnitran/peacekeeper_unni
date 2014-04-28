package hiof.android14.group26.peacekeeper;

import hiof.android14.group26.peacekeeper.models.Tasks;
import android.os.AsyncTask;

public class CreateTask extends AsyncTask<Void, Void, Tasks>{

	
	@Override
	protected Tasks doInBackground(Void... params) {
		
		Tasks task = MainActivity.getDatasource().createTaskNoResponsibleHouseholdMember("Toilet paper", 40.0, "28.04.2014", "30.04.2014", 1);
		
		return task;
	}
	
}
