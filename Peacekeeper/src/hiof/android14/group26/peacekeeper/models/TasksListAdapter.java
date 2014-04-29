package hiof.android14.group26.peacekeeper.models;

import hiof.android14.group26.peacekeeper.MainActivity;
import hiof.android14.group26.peacekeeper.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class TasksListAdapter extends ArrayAdapter<Tasks>{

	public TasksListAdapter(Context context, int resource) {
		super(context, resource);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		View view = convertView;
		
		if(view == null){
			LayoutInflater viewInflater = LayoutInflater.from(getContext());
			view = viewInflater.inflate(R.layout.task_list, null);
		}
		
		Tasks task = getItem(position);
		
		if(task != null){
			TextView desc = (TextView) view.findViewById(R.id.task_desc);
			TextView due_date = (TextView) view.findViewById(R.id.due_date);
			TextView responsible = (TextView) view.findViewById(R.id.responsible);
			
			if(desc != null){
				desc.setText(task.getDescription());
			}
			if(due_date != null){
				due_date.setText(task.getDue_date());
			}
			if(responsible != null){
				responsible.setText(MainActivity.getDatasource().getUser(task.getId()).getFname()+"");
			}
		}
		
		return view;
	}

}
