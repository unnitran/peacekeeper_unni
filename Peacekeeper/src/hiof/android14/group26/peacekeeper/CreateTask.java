package hiof.android14.group26.peacekeeper;

import hiof.android14.group26.peacekeeper.models.Tasks;
import android.os.AsyncTask;

public class CreateTask extends AsyncTask<Void, Void, Tasks>{

//	CreateTask(String desc, double price, String creationDate, String dueDate){
//		
//	}
	
	@Override
	protected Tasks doInBackground(Void... params) {
		
		//TODO: pass parameters
		//http://stackoverflow.com/questions/12069669/how-can-you-pass-multiple-primitive-parameters-to-asynctask
		Tasks task = MainActivity.getDatasource().createTaskNoResponsibleHouseholdMember("Toilet paper", 40.0, "28.04.2014", "30.04.2014", 1);
		
		return task;
	}
	
}
