package com.example.testdininghall;

import java.io.IOException;
import java.util.ArrayList;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;

public class MealActivity extends Activity implements OnClickListener{

	Button diningHall_btn, meal_btn, allMenu_btn, favorite_btn, home_btn;
	Button all_btn, breakfast_btn,lunch_btn,dinner_btn;
	MyCustomAdapter dataAdapter = null;
	static MenuDatabase menuDatabase = new MenuDatabase(); 
	getMenu task = new getMenu();

	
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
	@Override
    protected void onCreate(Bundle savedInstanceState) {
		task.execute("all");
		
        super.onCreate(savedInstanceState);
        setContentView(R.layout.meal);

        home_btn=(Button)findViewById(R.id.home_button);
        diningHall_btn=(Button)findViewById(R.id.diningHall_button);
        meal_btn=(Button)findViewById(R.id.meal_button);
//        allMenu_btn=(Button)findViewById(R.id.allMenu_button);
        favorite_btn=(Button)findViewById(R.id.favorite_button);
        all_btn=(Button)findViewById(R.id.all_button);
        breakfast_btn=(Button)findViewById(R.id.breakfast_button);
        lunch_btn=(Button)findViewById(R.id.lunch_button);
        dinner_btn=(Button)findViewById(R.id.dinner_button);
        
        home_btn.setOnClickListener(this);
        diningHall_btn.setOnClickListener(this);
        meal_btn.setOnClickListener(this);
  //      allMenu_btn.setOnClickListener(this);
        favorite_btn.setOnClickListener(this);
        all_btn.setOnClickListener(this);
        breakfast_btn.setOnClickListener(this);
        lunch_btn.setOnClickListener(this);
        dinner_btn.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.dining_hall, menu);
        return true;
    }


	@SuppressLint("ResourceAsColor")
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		int clickedBtnId=arg0.getId();
	    breakfast_btn=(Button)findViewById(R.id.breakfast_button);
	    lunch_btn=(Button)findViewById(R.id.lunch_button);
	    dinner_btn=(Button)findViewById(R.id.dinner_button);
	    all_btn = (Button)findViewById(R.id.all_button);
	    
		if (clickedBtnId == R.id.diningHall_button){
			Intent ToDiningHall = new Intent (this, DiningHallActivity.class);
			startActivity(ToDiningHall);
		}
		
		else if (clickedBtnId == R.id.meal_button){
			Intent ToMeal1 = new Intent (this, MealActivity.class);
			startActivity(ToMeal1);
		}
	/*	
		else if (clickedBtnId == R.id.allMenu_button){
			Intent ToAllMenu = new Intent (this, AllMenuActivity.class);
			startActivity(ToAllMenu);
		}*/
		
		else if (clickedBtnId == R.id.favorite_button){
			Intent ToFavorite = new Intent (this, FavoriteActivity.class);
			startActivity(ToFavorite);
		}
		
		else if (clickedBtnId == R.id.home_button)
		{
			Intent ToHome = new Intent (this, HomeActivity.class);
			startActivity(ToHome);
		}
		
		else if (clickedBtnId == R.id.all_button)
		{
			all_btn.setBackgroundResource(R.color.top_SelectedButtonColor);
	        breakfast_btn.setBackgroundResource(R.color.top_NotSelectedButtonColor);
	        lunch_btn.setBackgroundResource(R.color.top_NotSelectedButtonColor);
	        dinner_btn.setBackgroundResource(R.color.top_NotSelectedButtonColor);
	        displayListView("all");
		}
		
		
		else if (clickedBtnId == R.id.breakfast_button){   //you can see value of those colors at in folder values/style.xml
			all_btn.setBackgroundResource(R.color.top_NotSelectedButtonColor);
			breakfast_btn.setBackgroundResource(R.color.top_SelectedButtonColor);
	        lunch_btn.setBackgroundResource(R.color.top_NotSelectedButtonColor);
	        dinner_btn.setBackgroundResource(R.color.top_NotSelectedButtonColor);
	        displayListView("breakfast");
		}
		
		
		else if (clickedBtnId == R.id.lunch_button){
			all_btn.setBackgroundResource(R.color.top_NotSelectedButtonColor);
	        breakfast_btn.setBackgroundResource(R.color.top_NotSelectedButtonColor);
	        lunch_btn.setBackgroundResource(R.color.top_SelectedButtonColor);
	        dinner_btn.setBackgroundResource(R.color.top_NotSelectedButtonColor);
	        displayListView("lunch");
		}
		
		else if (clickedBtnId == R.id.dinner_button){
			all_btn.setBackgroundResource(R.color.top_NotSelectedButtonColor);
	        breakfast_btn.setBackgroundResource(R.color.top_NotSelectedButtonColor);
	        lunch_btn.setBackgroundResource(R.color.top_NotSelectedButtonColor);
	        dinner_btn.setBackgroundResource(R.color.top_SelectedButtonColor);
	        displayListView("dinner");
		}
	}
	
	
	private void displayListView(String mealTime) {
		
		MenuItem menuItem;	
		//list of items that will be display on the listView
		ArrayList<MenuItem> menuItemList = new ArrayList<MenuItem>();	
		ArrayList<MenuItem> menu = menuDatabase.getDatabase();
		
		//Initial Information for the item object, we will need to read in from database in the future.
		String name = "";
		boolean favorite = false;
		ArrayList<String> breakfast = null;
		ArrayList<String> lunch = null;
		ArrayList<String> dinner = null;
		ArrayList<String> nutInfo = null;
		
		int i;
		
		if(mealTime.equals("all"))
		{
			for(MenuItem m : menu){
				menuItemList.add(m); //display all menu in the database to the screen	
			}
		}
		else if(mealTime.equals("breakfast")) //put breakfast menuItems into menuItemList
		{
			for(MenuItem m : menu){
				if (!m.getBreakfastDiningHall().isEmpty()) //if list of breakfast dining hall is not empty,
					menuItemList.add(m);	 //display all menu in the database to the screen	  //add it to list that will show on the screen
			}
		}
		
		else if(mealTime.equals("lunch"))//put lunch menuItems into menuItemList
		{
			for(MenuItem m : menu){
				if (!m.getLunchDiningHall().isEmpty()) //if list of breakfast dining hall is not empty,
					menuItemList.add(m);	 //display all menu in the database to the screen	  //add it to list that will show on the screen
			}
		}
		
		else if(mealTime.equals("dinner"))//put dinner menuItems into menuItemList
		{
			for(MenuItem m : menu){
				if (!m.getDinnerDiningHall().isEmpty()) //if list of breakfast dining hall is not empty,
					menuItemList.add(m);	 //display all menu in the database to the screen	  //add it to list that will show on the screen
			}
		}

		
		//Create Array Adapter
		dataAdapter = new MyCustomAdapter(this,R.layout.listview_row, menuItemList);
		ListView listView = (ListView) findViewById(R.id.listView1);
		//Assign adapter to ListView
		listView.setAdapter(dataAdapter);
	
		//I can add listener down here to make ListView respond to the click
		
	}
	
	private class getMenu extends AsyncTask<String, Integer, String> {
		boolean create = false;
		@Override
		protected String doInBackground(String... params) {
			try {
				if(!create){
				menuDatabase.createMenu();
				create = true;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			return params[0];
		}
		
		@Override
		protected void onPostExecute(String result){
	        displayListView(result); //default is set to display breakfast page.
		}
		

        
    }
	//Adapter is used to display information in the "List Format" onto the ListView Screen.
	//Normal type like "String" is supported by default adapter but 
	//I need to make custom adapter that can support MenuItem type of object.
	class MyCustomAdapter extends ArrayAdapter<MenuItem>
	{

		private ArrayList<MenuItem> menuList;

		public MyCustomAdapter(Context context, int resourceID,
				ArrayList<MenuItem> newMenuList) 
		{
			super(context, resourceID, newMenuList);
			this.menuList = new ArrayList<MenuItem>();
			this.menuList.addAll(newMenuList);
		}
	
		//This function is why we write custom adapter in the first place.
		//We can design how to display on the screen using this function.
		//For now, it only deal with the checkbox and checkbox text.
		public View getView(int position, View convertView, ViewGroup parent) 
		{
	
			View row=convertView;
			MenuItem item = menuList.get(position);
			//inflater are expensive, 20~30ms, checking for row==null, we can save some time
			if (row==null){
				LayoutInflater inflater=getLayoutInflater();
				row=inflater.inflate(R.layout.listview_row, null);
			}
		
			CheckBox checkbox = (CheckBox) row.findViewById(R.id.listview_row_checkbox);																 
		
			checkbox.setChecked(item.isFavorite());
			checkbox.setText(item.getName());
			Button info_button = (Button) row.findViewById(R.id.listview_row_button); 																 
			
			info_button.setTag(item.getName()); //let tag of button be name of menu so we can take appropriate response
			//when button is clicked by looking at the tag


			info_button.setOnClickListener(new View.OnClickListener()
			{
				@Override
				public void onClick(View v) {
					Button btn = (Button) v;
					String menuName = (String) btn.getTag();
					Bundle basket = new Bundle();
					basket.putString("name", menuName);
					Intent ToMenuInfo = new Intent (MealActivity.this, MenuInfoActivity.class);
					ToMenuInfo.putExtras(basket);
					startActivity(ToMenuInfo);
				}			
			});
			return row;			
		}

	}


    
}
