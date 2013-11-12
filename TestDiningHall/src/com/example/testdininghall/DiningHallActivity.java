package com.example.testdininghall;

import java.util.ArrayList;

import com.example.testdininghall.MealActivity.MyCustomAdapter;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;

public class DiningHallActivity extends Activity implements OnClickListener{

	Button diningHall_btn, meal_btn, allMenu_btn, favorite_btn, home_btn;
	Button covelCommons_btn, deNeve_btn, bruinPlate_btn, reiber_btn, hedrick_btn;
	MyCustomAdapter dataAdapter = null;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dininghall);
        displayListView("Covel Commons");
        
        
        
        
        home_btn=(Button)findViewById(R.id.home_button);
        diningHall_btn=(Button)findViewById(R.id.diningHall_button);
        meal_btn=(Button)findViewById(R.id.meal_button);
//        allMenu_btn=(Button)findViewById(R.id.allMenu_button);
        favorite_btn=(Button)findViewById(R.id.favorite_button);
        covelCommons_btn=(Button)findViewById(R.id.covelCommons_button);
        deNeve_btn=(Button)findViewById(R.id.deNeve_button);
        bruinPlate_btn=(Button)findViewById(R.id.bruinPlate_button);
        reiber_btn=(Button)findViewById(R.id.reiber_button);
        hedrick_btn=(Button)findViewById(R.id.hedrick_button);
        
        home_btn.setOnClickListener(this);
        diningHall_btn.setOnClickListener(this);
        meal_btn.setOnClickListener(this);
  //      allMenu_btn.setOnClickListener(this);
        favorite_btn.setOnClickListener(this);
        covelCommons_btn.setOnClickListener(this);
        deNeve_btn.setOnClickListener(this);
        bruinPlate_btn.setOnClickListener(this);
        reiber_btn.setOnClickListener(this);
        hedrick_btn.setOnClickListener(this);
    
    }
    


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.dining_hall, menu);
        return true;
    }


	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		int clickedBtnId=arg0.getId();
		//get button information of 5 dining hall buttons so I can change their background color
        covelCommons_btn=(Button)findViewById(R.id.covelCommons_button);
        deNeve_btn=(Button)findViewById(R.id.deNeve_button);
        bruinPlate_btn=(Button)findViewById(R.id.bruinPlate_button);
        reiber_btn=(Button)findViewById(R.id.reiber_button);
        hedrick_btn=(Button)findViewById(R.id.hedrick_button);

		if (clickedBtnId == R.id.diningHall_button)
		{
			Intent ToDiningHall = new Intent (this, DiningHallActivity.class); //Intent is how we switch between screens (Activities)
			startActivity(ToDiningHall);
		}
		
		else if (clickedBtnId == R.id.meal_button)
		{
			Intent ToMeal1 = new Intent (this, MealActivity.class);
			startActivity(ToMeal1);
		}
/*		
		else if (clickedBtnId == R.id.allMenu_button)
		{
			Intent ToAllMenu = new Intent (this, AllMenuActivity.class);
			startActivity(ToAllMenu);
		}
		*/
		else if (clickedBtnId == R.id.favorite_button)
		{
			Intent ToFavorite = new Intent (this, FavoriteActivity.class);
			startActivity(ToFavorite);
		}
		
		else if (clickedBtnId == R.id.home_button)
		{
			Intent ToHome = new Intent (this, HomeActivity.class);
			startActivity(ToHome);
		}
		
		else if (clickedBtnId == R.id.covelCommons_button){  //you can see value of those colors at in folder values/style.xml
		      covelCommons_btn.setBackgroundResource(R.color.top_SelectedButtonColor);
		      deNeve_btn.setBackgroundResource(R.color.top_NotSelectedButtonColor);
		      bruinPlate_btn.setBackgroundResource(R.color.top_NotSelectedButtonColor);
		      reiber_btn.setBackgroundResource(R.color.top_NotSelectedButtonColor);
		      hedrick_btn.setBackgroundResource(R.color.top_NotSelectedButtonColor);
		      displayListView("Covel Commons");
		}
		
		else if (clickedBtnId == R.id.deNeve_button){
		      covelCommons_btn.setBackgroundResource(R.color.top_NotSelectedButtonColor);
		      deNeve_btn.setBackgroundResource(R.color.top_SelectedButtonColor);
		      bruinPlate_btn.setBackgroundResource(R.color.top_NotSelectedButtonColor);
		      reiber_btn.setBackgroundResource(R.color.top_NotSelectedButtonColor);
		      hedrick_btn.setBackgroundResource(R.color.top_NotSelectedButtonColor);
		      displayListView("De Neve");
		}
		
		else if (clickedBtnId == R.id.bruinPlate_button){
		      covelCommons_btn.setBackgroundResource(R.color.top_NotSelectedButtonColor);
		      deNeve_btn.setBackgroundResource(R.color.top_NotSelectedButtonColor);
		      bruinPlate_btn.setBackgroundResource(R.color.top_SelectedButtonColor);
		      reiber_btn.setBackgroundResource(R.color.top_NotSelectedButtonColor);
		      hedrick_btn.setBackgroundResource(R.color.top_NotSelectedButtonColor);
		      displayListView("Bruin Plate");
		}
		
		else if (clickedBtnId == R.id.reiber_button){
		      covelCommons_btn.setBackgroundResource(R.color.top_NotSelectedButtonColor);
		      deNeve_btn.setBackgroundResource(R.color.top_NotSelectedButtonColor);
		      bruinPlate_btn.setBackgroundResource(R.color.top_NotSelectedButtonColor);
		      reiber_btn.setBackgroundResource(R.color.top_SelectedButtonColor);
		      hedrick_btn.setBackgroundResource(R.color.top_NotSelectedButtonColor); 
		      displayListView("Reiber");
		}
		
		else if (clickedBtnId == R.id.hedrick_button){
		      covelCommons_btn.setBackgroundResource(R.color.top_NotSelectedButtonColor);
		      deNeve_btn.setBackgroundResource(R.color.top_NotSelectedButtonColor);
		      bruinPlate_btn.setBackgroundResource(R.color.top_NotSelectedButtonColor);
		      reiber_btn.setBackgroundResource(R.color.top_NotSelectedButtonColor);
		      hedrick_btn.setBackgroundResource(R.color.top_SelectedButtonColor);    
		      displayListView("Hedrick");
		}
	}
	
	
	
	private void displayListView(String diningHall) {
		
		MenuItem menuItem;
		ArrayList<MenuItem> menuItemList = new ArrayList<MenuItem>();  //list to display on the screen
		MenuDatabase menuDatabase = new MenuDatabase(); //fake database that return hard coded data
		
		//Initial Information for the item object, we will need to read in from database in the future.
		boolean favorite = false;
		ArrayList<String> breakfast = null;
		ArrayList<String> lunch = null;
		ArrayList<String> dinner = null;
		ArrayList<String> nutInfo = null;
		int i;
		
		if(diningHall.equals("Covel Commons")) //put Covel Common's menu into menuItemList
		{
			for(i=0; i<menuDatabase.getDatabaseSize();i++){
				menuItem = menuDatabase.getMenuItem(i);
				//if it contain Covel as dining hall offering this menu add it to list that will show on the screen
				if (menuItem.getBreakfastDiningHall().contains("Covel") || 
						menuItem.getLunchDiningHall().contains("Covel") || menuItem.getDinnerDiningHall().contains("Covel") ) 
					menuItemList.add(menuItem);					 
			}
		}
		
		else if(diningHall.equals("De Neve"))//put De neve's menu into menuItemList
		{
			for(i=0; i<menuDatabase.getDatabaseSize();i++){
				menuItem = menuDatabase.getMenuItem(i);
				//if it contain De Neve as dining hall offering this menu, add it to list that will show on the screen
				if (menuItem.getBreakfastDiningHall().contains("De Neve") || 
						menuItem.getLunchDiningHall().contains("De Neve") || menuItem.getDinnerDiningHall().contains("De Neve") ) 
					menuItemList.add(menuItem);		
			}
		}
		
		else if(diningHall.equals("Bruin Plate"))//put Bruin Plate's menu into menuItemList
		{
			for(i=0; i<menuDatabase.getDatabaseSize();i++){
				menuItem = menuDatabase.getMenuItem(i);
				//if it contain Bruin Plate as dining hall offering this menu, add it to list that will show on the screen
				if (menuItem.getBreakfastDiningHall().contains("Bruin Plate") || 
						menuItem.getLunchDiningHall().contains("Bruin Plate") || menuItem.getDinnerDiningHall().contains("Bruin Plate") ) 
					menuItemList.add(menuItem);		
			}
		}
		
		else if(diningHall.equals("Reiber"))//put Reiber's menu into menuItemList
		{
			for(i=0; i<menuDatabase.getDatabaseSize();i++){
				menuItem = menuDatabase.getMenuItem(i);
				//if it contain Reiber as dining hall offering this menu, add it to list that will show on the screen
				if (menuItem.getBreakfastDiningHall().contains("Reiber") || 
						menuItem.getLunchDiningHall().contains("Reiber") || menuItem.getDinnerDiningHall().contains("Reiber") ) 
					menuItemList.add(menuItem);		
			}
		}
		
		else if(diningHall.equals("Hedrick"))//put Hedrick menu into menuItemList
		{
			for(i=0; i<menuDatabase.getDatabaseSize();i++){
				menuItem = menuDatabase.getMenuItem(i);
				//if it contain Hedrick as dining hall offering this menu, add it to list that will show on the screen
				if (menuItem.getBreakfastDiningHall().contains("Hedrick") || 
						menuItem.getLunchDiningHall().contains("Hedrick") || menuItem.getDinnerDiningHall().contains("Hedrick") ) 
					menuItemList.add(menuItem);		
			}
		}
		
		//extra rows in the menu list
		for(i=0; i<13; i++){
			String name = "Menu "+i;
			menuItem = new MenuItem(name, favorite, breakfast, lunch, dinner, nutInfo);
			menuItemList.add(menuItem);
		}
		
		//Create Array Adapter
		dataAdapter = new MyCustomAdapter(this,R.layout.listview_row, menuItemList);
		ListView listView = (ListView) findViewById(R.id.listView1);
		//Assign adapter to ListView
		listView.setAdapter(dataAdapter);
	
		//I can add listener down here to make ListView respond to the click
		
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
		//For now, it only deal with the checkbox text.
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

			//listener for the button at right side of each row
			info_button.setOnClickListener(new View.OnClickListener()
			{
				@Override
				public void onClick(View v) {
					Button btn = (Button) v;
					String menuName = (String) btn.getTag(); //tag is name of menu assigned above
					Bundle basket = new Bundle();			//bundle is just way to pass data between Activities 
					basket.putString("name", menuName); 	//we will pass name of menu that user clicked
					Intent ToMenuInfo = new Intent (DiningHallActivity.this, MenuInfoActivity.class);
					ToMenuInfo.putExtras(basket);
					startActivity(ToMenuInfo); //Go to MenuInfo Screen
				}			
			});
			
			return row;			
		}

	}//end of class MyCustomAdapter


    
}//end of DiningHall Activity
