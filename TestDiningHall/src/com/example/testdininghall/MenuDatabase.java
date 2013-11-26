package com.example.testdininghall;

import java.io.IOException;
import java.util.ArrayList;

public class MenuDatabase {
	ArrayList<MenuItem> menuDatabase;
	int dataBaseSize; //number of menuItem in the database
    DiningHall dininghall;
	
	//default constructor
	public MenuDatabase(){
        dininghall = new DiningHall();
        try {
			dininghall.createMenu();
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.menuDatabase = (ArrayList<MenuItem>) dininghall.getMenu();
		this.dataBaseSize=dininghall.getSize(); //*****************************this value need to match with # of times in getMenuItem()
							  //dataBaseSize = last item number + 1
	}
	
	public ArrayList<MenuItem> getDatabase(){ //this return empty database for now
		return this.menuDatabase; //For future, I should be able to pass entire Database
	}
	
	public int getDatabaseSize(){ 
		return this.dataBaseSize;
	}
	
	//get MenuItem in given index position, for now, data is fixed.
	public MenuItem getMenuItem(int index){
		return menuDatabase.get(index);
	}

}
