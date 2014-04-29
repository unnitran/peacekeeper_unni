package hiof.android14.group26.peacekeeper;

import hiof.android14.group26.peacekeeper.database.DataSource;
import hiof.android14.group26.peacekeeper.models.Tasks;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class AddTaskFragment extends Fragment{
	
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
		
		CreateTask createTask = new CreateTask();
		createTask.execute();
		
		
        // Inflate the layout for this fragment
		
        return inflater.inflate(R.layout.activity_task, container, false);
    }
	
	
}
