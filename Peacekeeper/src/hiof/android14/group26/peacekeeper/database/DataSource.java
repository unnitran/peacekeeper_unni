package hiof.android14.group26.peacekeeper.database;

import java.util.ArrayList;
import java.util.List;

import hiof.android14.group26.peacekeeper.models.Tasks;
import hiof.android14.group26.peacekeeper.models.User;
import hiof.android14.group26.peacekeeper.models.Household;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;


//TODO: add remaining code for tasks (add another method for creating task where responsible is not null?)
//TODO: add code for user, household and householdhastasks (might split this in different methods)

public class DataSource {
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
					
	private String[] allUsersColumns = {
					UserTable.COLUMN_ID,
					UserTable.COLUMN_FIRST_NAME,
					UserTable.COLUMN_LAST_NAME,
					UserTable.COLUMN_EMAIL,
					UserTable.COLUMN_PASSWORD,
					UserTable.COLUMN_HOUSEHOLD_ID};
	
	private String[] allHouseholdColumns = {
					HouseholdTable.COLUMN_ID,
					HouseholdTable.COLUMN_NAME
	};
	
	private String[] allHouseholdHasTasksColumns = {
					HouseholdHasTasksTable.COLUMN_TASK_ID,
					HouseholdHasTasksTable.COLUMN_HOUSEHOLD_ID};

	public DataSource(Context context) {
		dbHelper = new SQLiteHelper(context);
	}
	
	/*
	 * Methods for handling tasks
	 */
	
	//Create task without responsible household member
	public Tasks createTaskNoResponsibleHouseholdMember(String description, double price, String creation_date, String due_date, int creator){
		ContentValues values = new ContentValues();
		
		values.put(TaskTable.COLUMN_DESCRIPTION, description);
		values.put(TaskTable.COLUMN_PRICE, price);
		values.put(TaskTable.COLUMN_CREATION_DATE, creation_date);
		values.put(TaskTable.COLUMN_DUE_DATE, due_date);
		values.put(TaskTable.COLUMN_CREATOR, creator);
		values.put(TaskTable.COLUMN_RESPONSIBLE, creator);
		
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
		task.setPrice(cursor.getFloat(2));
		task.setCreation_date(cursor.getString(3));
		task.setDue_date(cursor.getString(4));
		task.setCreator_id(cursor.getInt(5));
		task.setResponsible_id(cursor.getInt(6));
		
		return task;
	}
	
	/*
	 * Methods for handling users
	 */
	
	//Create user
	public User createUser(String fname, String lname, String email, String password, int household){
		
		ContentValues values = new ContentValues();
		
		values.put(UserTable.COLUMN_FIRST_NAME, fname);
		values.put(UserTable.COLUMN_LAST_NAME, lname);
		values.put(UserTable.COLUMN_EMAIL, email);
		values.put(UserTable.COLUMN_PASSWORD, password);
		values.put(UserTable.COLUMN_HOUSEHOLD_ID, household);
		
		long insertId = database.insert(UserTable.TABLE_USER, null, values);
		
		return getUser(insertId);
	}
	
	//Get user
	public User getUser(long id){
		Cursor cursor = database.query(
				UserTable.TABLE_USER,
				allUsersColumns, 
				UserTable.COLUMN_ID + " = " + id, 
				null, null, null, null, null);
		
		cursor.moveToFirst();
		User user = cursorToUser(cursor);
		cursor.close();
		
		return user;
	}
	
	//Cursor to user
	private User cursorToUser(Cursor cursor){
		User user = new User();
		
		user.setId(cursor.getInt(0));
		user.setFname(cursor.getString(1));
		user.setLname(cursor.getString(2));
		user.setEmail(cursor.getString(3));
		user.setPassword(cursor.getString(4));
		user.setHousehold_id(cursor.getInt(5));
		
		return user;
	}
	
	/*
	 * Methods for handling households
	 */
	
	//Create household
	public Household createHousehold(String name){
		ContentValues values = new ContentValues();
		
		values.put(HouseholdTable.COLUMN_NAME, name);
		
		long insertId = database.insert(HouseholdTable.TABLE_HOUSEHOLD, null, values);
		
		return getHousehold(insertId);
	}
	
	//Get household
	public Household getHousehold(long id){
		Cursor cursor = database.query(
				HouseholdTable.TABLE_HOUSEHOLD,
				allHouseholdColumns, 
				HouseholdTable.COLUMN_ID + " = " + id, 
				null, null, null, null, null);
		
		cursor.moveToFirst();
		Household household = cursorToHousehold(cursor);
		cursor.close();
		
		return household;
	}
	
	//Cursor to household
	private Household cursorToHousehold(Cursor cursor){
		Household house = new Household();
		
		house.setId(cursor.getInt(0));
		house.setName(cursor.getString(1));
		
		return house;
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




















