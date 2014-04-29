package hiof.android14.group26.peacekeeper;

import hiof.android14.group26.peacekeeper.database.DataSource;
import hiof.android14.group26.peacekeeper.models.Tasks;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddTaskFragment extends Fragment implements OnClickListener{
	
	private String description;
	private double price;
	private String creationDate;
	private String dueDate;
	private String responsible;
	
	private EditText addTaskDescription, addTaskPrice, addTaskDueDate, addTaskResponsible;
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
		
		// Inflate the layout for this fragment
		View view = inflater.inflate(R.layout.activity_task, container, false);
		
		Button b = (Button) view.findViewById(R.id.buttonAddTask);
		b.setOnClickListener(this);
		
		addTaskDescription = (EditText)view.findViewById(R.id.addTaskDescriptionEditText);
		addTaskPrice = (EditText)view.findViewById(R.id.addTaskPriceEditText);
		addTaskDueDate = (EditText)view.findViewById(R.id.addTaskDueDateEditText);
		addTaskResponsible = (EditText)view.findViewById(R.id.addTaskResponsibleEditText);
		
        return view;//inflater.inflate(R.layout.activity_task, container, false);
    }
	

	@Override
	public void onClick(View v) {
		
		//TODO: add error handling
		description = addTaskDescription.getText().toString();
		price = Double.parseDouble(addTaskPrice.getText().toString());
		dueDate = addTaskDueDate.getText().toString();
		responsible = addTaskResponsible.getText().toString();
		
		Toast.makeText(getActivity(),description,Toast.LENGTH_SHORT).show();
	}
	
	
}
