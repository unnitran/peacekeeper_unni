package hiof.android14.group26.peacekeeper;

import java.util.List;

import hiof.android14.group26.peacekeeper.models.Tasks;
import hiof.android14.group26.peacekeeper.models.TasksListAdapter;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class AllTasksFragment extends ListFragment{
	public void onCreate(Bundle savedInstanceBundle){
		super.onCreate(savedInstanceBundle);

		
		TasksListAdapter adapter = new TasksListAdapter(getActivity(), android.R.layout.simple_list_item_1);
		List<Tasks> tasks = MainActivity.getDatasource().getAllTasks();
		
		//TODO: get data from database and fill list here
		String[] values = new String[] {"Open Task 1", "Chosen Task 2", "Closed Task 3", "Closed Task 4"};
		//String[] values = new String[] {" "};

//		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
//		        R.layout.fragment_all_tasks,R.id.label, values);

		setListAdapter(adapter);
		adapter.addAll(tasks);
	}

	@Override
	  public void onListItemClick(ListView l, View v, int position, long id) {
	    //TODO: do something with the data
	  }
}
