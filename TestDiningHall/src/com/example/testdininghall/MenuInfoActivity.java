package com.example.testdininghall;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MenuInfoActivity extends Activity implements OnClickListener{

	Button diningHall_btn;
	Button meal_btn;
	Button allMenu_btn;
	Button favorite_btn;
	Button back_btn;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menuinfo);
      
        MenuItem menuItem= new MenuItem();
		MenuDatabase menuDatabase = new MenuDatabase(); //fake database that return hard coded data
        String menuName;
        ArrayList<String> nutInfoList;
        String menuInfo ="";
        CheckBox menuInfo_checkbox = (CheckBox) findViewById(R.id.info_checkbox);
        TextView menuInfo_textView= (TextView) findViewById(R.id.info_textView);
        
        
        
        diningHall_btn=(Button)findViewById(R.id.diningHall_button);
        diningHall_btn.setOnClickListener(this);
        
        meal_btn=(Button)findViewById(R.id.meal_button);
        meal_btn.setOnClickListener(this);
        
        allMenu_btn=(Button)findViewById(R.id.allMenu_button);
        allMenu_btn.setOnClickListener(this);
        
        favorite_btn=(Button)findViewById(R.id.favorite_button);
        favorite_btn.setOnClickListener(this);
        
        back_btn=(Button)findViewById(R.id.back_button);
        back_btn.setOnClickListener(this);
      
        //receive name of the menu that we want to display on the screen
        Bundle gotBasket = getIntent().getExtras();
        menuName = gotBasket.getString("name");
        
        int i;
		for(i=0; i<menuDatabase.getDatabaseSize();i++){
			menuItem = menuDatabase.getMenuItem(i);
			//find menu information by looking up by name, if found, break out for loop
			if (menuName.equals(menuItem.getName()))			
				break;
		 }
		menuInfo_checkbox.setText(menuName); 					//type name
		menuInfo_checkbox.setChecked(menuItem.isFavorite()); 	//check if it's favorite menu
		
		
		// Printing out which dining hall is offerring this menu and at what time period.
		ArrayList<String> bfList = menuItem.getBreakfastDiningHall();
		ArrayList<String> lunchList = menuItem.getLunchDiningHall();
		ArrayList<String> dinnerList = menuItem.getDinnerDiningHall();
		
		menuInfo = menuInfo + "Breakfast: ";
		for(i=0; i<bfList.size();i++){
			menuInfo = menuInfo + bfList.get(i);
			if (i+1<bfList.size()) //if there is still another dining hall, put comma
				menuInfo= menuInfo + ", ";
		}
		menuInfo = menuInfo +"\n";
		menuInfo = menuInfo +"Lunch: ";
		for(i=0; i<lunchList.size();i++){
			menuInfo = menuInfo + lunchList.get(i);
			if (i+1<lunchList.size()) //if there is still another dining hall, put comma
				menuInfo= menuInfo + ", ";
		}
		menuInfo = menuInfo +"\n";
		menuInfo = menuInfo +"Dinner: ";
		for(i=0; i<dinnerList.size();i++){
			menuInfo = menuInfo + dinnerList.get(i);
			if (i+1<dinnerList.size()) //if there is still another dining hall, put comma
				menuInfo= menuInfo + ", ";
		}
		menuInfo = menuInfo +"\n\n";
		
		nutInfoList = menuItem.getNutInfo();
		String nutInfo = "";
		for(int j=0; j<nutInfoList.size();j++){
			nutInfo = nutInfo + nutInfoList.get(j);
			nutInfo = nutInfo + '\n';
		}
		menuInfo = menuInfo + nutInfo; 			//put Dining hall information and nut information together
		menuInfo_textView.setText(menuInfo); 	//print them out to screen
  
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

		if (clickedBtnId == R.id.diningHall_button)
		{
			Intent ToDiningHall = new Intent (this, DiningHallActivity.class);
			startActivity(ToDiningHall);
		}
		
		else if (clickedBtnId == R.id.meal_button)
		{
			Intent ToMeal1 = new Intent (this, MealActivity.class);
			startActivity(ToMeal1);
		}
		
		else if (clickedBtnId == R.id.allMenu_button)
		{
			Intent ToAllMenu = new Intent (this, AllMenuActivity.class);
			startActivity(ToAllMenu);
		}
		
		else if (clickedBtnId == R.id.favorite_button)
		{
			Intent ToFavorit = new Intent (this, FavoriteActivity.class);
			startActivity(ToFavorit);
		}
		
		else if (clickedBtnId == R.id.back_button){ //return button
			MenuInfoActivity.this.finish();
		}
		
		
		
	}
    
}
