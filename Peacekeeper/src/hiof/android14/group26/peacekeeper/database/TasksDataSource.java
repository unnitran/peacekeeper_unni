package hiof.android14.group26.peacekeeper.database;

import java.util.ArrayList;
import java.util.List;

import hiof.android14.group26.peacekeeper.models.Tasks;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;


//TODO: add remaining code for tasks (add another method for creating task where responsible is not null?)
//TODO: add code for user, household and householdhastasks (might split this in different methods)

public class TasksDataSource {
	private SQLiteDatabase database;
	private SQLiteHelper dbHelper;
	
	private String[] allTasksColumns = { 
					TaskTable.COLUMN_ID,
					TaskTable.COLUMN_DESCRIPTION,
					TaskTable.COLUMN_PRICE,
					TaskTable.COLUMN_CREATION_DATE,
					TaskTable.COLUMN_DUE_DATE,
					TaskTable.COLUMN_CREATOR,
					TaskTable.COLUMN_RESPONSIBLE};
					
	private String[] allHouseholdHasTasksColumns = {
					HouseholdHasTasksTable.COLUMN_TASK_ID,
					HouseholdHasTasksTable.COLUMN_HOUSEHOLD_ID};

	public TasksDataSource(Context context) {
		dbHelper = new SQLiteHelper(context);
	}
	
	
	//Create task without responsible household member
	public Tasks createTaskNoResponsibleHouseholdMember(String description, double price, String creation_date, String due_date, int creator){
		ContentValues values = new ContentValues();
		
		values.put(TaskTable.COLUMN_DESCRIPTION, description);
		values.put(TaskTable.COLUMN_CREATION_DATE, creation_date);
		values.put(TaskTable.COLUMN_PRICE, price);
		values.put(TaskTable.COLUMN_DUE_DATE, due_date);
		values.put(TaskTable.COLUMN_CREATOR, creator);
		
		long insertId = database.insert(TaskTable.TABLE_TASK, null, values);
		
		return getTask(insertId);
	}
	
	//Create task with responsible household member
	public Tasks createTaskResponsibleHouseholdMember(String description, int price, String creation_date, String due_date, String creator, String responsible){
ContentValues values = new ContentValues();
		
		values.put(TaskTable.COLUMN_DESCRIPTION, description);
		values.put(TaskTable.COLUMN_CREATION_DATE, creation_date);
		values.put(TaskTable.COLUMN_PRICE, price);
		values.put(TaskTable.COLUMN_DUE_DATE, due_date);
		values.put(TaskTable.COLUMN_CREATOR, creator);
		values.put(TaskTable.COLUMN_RESPONSIBLE, responsible);
		
		long insertId = database.insert(TaskTable.TABLE_TASK, null, values);
		
		return getTask(insertId);
	}
	
	
	
	//Get single task
	public Tasks getTask(long id){
	
		Cursor cursor = database.query(TaskTable.TABLE_TASK,
						allTasksColumns,
						TaskTable.COLUMN_ID + " = " + id,
						null, null, null, null);
		
		cursor.moveToFirst();
		Tasks task = cursorToTask(cursor);
		cursor.close();
		
		return task;
	}
	
	//Get all tasks in one household
	//TODO: currently gets all tasks in database, not in household
	//might not be needed, method could be in another class
	public List<Tasks> getAllTasks() {
		List<Tasks> tasks = new ArrayList<Tasks>();
		
		Cursor cursor = database.query(TaskTable.TABLE_TASK, allTasksColumns, null, null, null, null, null);
		
		cursor.moveToFirst();
		while(!cursor.isAfterLast()){
			Tasks task = cursorToTask(cursor);
			tasks.add(task);
			cursor.moveToNext();
		}
		
		cursor.close();
		
		return tasks;
	}
	
	//Delete single task
	public void deleteTask(Tasks task){
		long id = task.getId();
		database.delete(TaskTable.TABLE_TASK, TaskTable.COLUMN_ID + " = " + id, null);
	};
	
	//Convert cursor with data to task-object
	private Tasks cursorToTask(Cursor cursor) {
		Tasks task = new Tasks();
		
		task.setId(cursor.getInt(0));
		task.setDescription(cursor.getString(1));
		task.setCreation_date(cursor.getString(2));
		task.setDue_date(cursor.getString(3));
		task.setCreator_id(cursor.getInt(4));
		
		return task;
	}
	
	public void open() throws SQLException {
		database = dbHelper.getWritableDatabase();
		
		// Enable foreign key constraints
        if (!database.isReadOnly()) {
        	database.execSQL("PRAGMA foreign_keys = ON;");
        }
		
	}

	public void close() {
		dbHelper.close();
	}
	
}




















