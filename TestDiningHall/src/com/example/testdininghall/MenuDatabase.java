package com.example.testdininghall;

import java.util.ArrayList;

public class MenuDatabase {
	ArrayList<MenuItem> menuDatabase;
	int dataBaseSize; //number of menuItem in the database
	
	//default constructor
	public MenuDatabase(){
		this.menuDatabase = null;
		this.dataBaseSize=10; //*****************************this value need to match with # of times in getMenuItem()
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
		MenuItem menuItem = new MenuItem();
		
		//List of Menu(semi-fake data) (add name here to keep track of what we already have added)
		// ***Also when you add more items to this method, you need to change dataBaseSize to X+1 where Item #X is last item
		// #0 Oatmeal
		// #1 Cheese Pizza
		// #2 Bruin Burger
		// #3 Baked Red Rose Potato
		// #4 Egg White Omelet
		// #5 Pepperoni Pizza
		// #6 Korean Bibimbap Flatbread
		// #7 Apple Pie
		// #8 Grilled Kalbi Beef Burger
		// #9 Tofu & Vegetable Stir Fry
		
		if (index==0) //Item #0 - Oatmeal
		{
			menuItem.setName("Oatmeal");				//name of menu
			menuItem.setFavorite(false);				//is this favorite menu for user?
			menuItem.addBreakfastDiningHall("Covel");	//add this dining hall to the list of dining halls that offer this menu in breakfast
			menuItem.addBreakfastDiningHall("Bruin Plate");
			//adding nutrition information
			menuItem.addNutInfo("Nutrition Facts"+ "\n"+  //you can add it by make it in one long string with new line char
								"Serving Size 4 ozl"+ "\n"+
								"Amount Per Serving"+ "\n"+
								"Calories 106 Fat Cal. 17"+ "\n"+
								"% Daily Value*"+ "\n"+
								"Total Fat 1.9g 3%"+ "\n"+
								"Saturated Fat 0.4g 2%"+ "\n"+
								"Trans Fat 0g "+ "\n"+
								"Cholesterol 0mg 0%"+ "\n"+
								"Sodium 108.2mg 7%"+ "\n"+
								"Total Carbohydrate 20.4g 16%"+ "\n"+
								"Dietary Fiber 3g 8%"+ "\n"+
								"Sugars 0g "+ "\n"+
								"Protein 4.5g"+ "\n"+
								"Vitamin A 0% \t Vitamin C 0%"+ "\n"+ 
								"Calcium 2% \t Iron 15%"+ "\n"+
								"*Percent Daily Values (DV) are based on a 2,000 calorie diet.");
		}
		else if(index==1) //Item #1 - Cheese Pizza
		{
			menuItem.setName("Cheese Pizza");
			menuItem.setFavorite(false);
			menuItem.addLunchDiningHall("Covel");
			menuItem.addLunchDiningHall("De Neve");
			menuItem.addLunchDiningHall("Reiber");
			menuItem.addDinnerDiningHall("De Neve");	
			menuItem.addNutInfo("Nutrition Facts");	//or you can add nutrition info one line by one line
			menuItem.addNutInfo("Serving Size 1/10 pizza");
			menuItem.addNutInfo("Amount Per Serving");
			menuItem.addNutInfo("Calories 224 Fat Cal. 86");
			menuItem.addNutInfo("% Daily Value*");
			menuItem.addNutInfo("Total Fat 9.5g 15%");
			menuItem.addNutInfo("Cholesterol 11.2mg 4%");
			menuItem.addNutInfo("Sodium 247.5mg 17%");
			menuItem.addNutInfo("Total Carbohydrate 27.5g 21%"+ "\n"+ 
								"Dietary Fiber 1.2g 3%"+ "\n"+ 
								"Sugars 0.9g "+ "\n"+ 
								"Protein 6.9g"+ "\n"+  
								"Vitamin A 3% \t Vitamin C 2%"+ "\n"+  
								"Calcium 8% \t Iron 12% "+ "\n"+ 
								"*Percent Daily Values (DV) are based on a 2,000 calorie diet.");
		}
		
		else if (index==2) // Item #2 - Bruin Burger
		{
			menuItem.setName("Bruin Burger");
			menuItem.setFavorite(true);
			menuItem.addDinnerDiningHall("Covel");
			menuItem.addDinnerDiningHall("Hedrick");
			menuItem.addNutInfo("Nutrition Facts"+ "\n"+
								"Serving Size 1 each"+ "\n"+
								"Amount Per Serving"+ "\n"+
								"Calories 463 Fat Cal. 224"+ "\n"+
								"% Daily Value*"+ "\n"+
								"Total Fat 24.8g 38%"+ "\n"+
								"Saturated Fat 10.8g 54%"+ "\n"+
								"Trans Fat 0.1g "+ "\n"+
								"Cholesterol 110.4mg 37%"+ "\n"+
								"Sodium 469.5mg 31%"+ "\n"+
								"Total Carbohydrate 32.7g 25%"+ "\n"+
								"Dietary Fiber 1.5g 4%"+ "\n"+
								"Sugars 4.7g "+ "\n"+
								"Protein 26g "+ "\n"+
								"Vitamin A 30% \t Vitamin C 10% "+ "\n"+
								"Calcium 5% \t Iron 27% "+ "\n"+
								"*Percent Daily Values (DV) are based on a 2,000 calorie diet."+ "\n");
		}
		
		else if (index==3) // Item #3 - Baked Red Rose Potato
		{
			menuItem.setName("Baked Red Rose Potato");
			menuItem.setFavorite(false);
			menuItem.addBreakfastDiningHall("Reiber");
			menuItem.addLunchDiningHall("Hedrick");
			menuItem.addDinnerDiningHall("Covel");
			menuItem.addNutInfo("Nutrition Facts"+ "\n"+
								"Serving Size 3 oz"+ "\n"+
								"Amount Per Serving"+ "\n"+
								"Calories 78 Fat Cal. 4"+ "\n"+
								"% Daily Value*"+ "\n"+
								"Total Fat 0.4g 1%"+ "\n"+
								"Saturated Fat 0.1g 0%"+ "\n"+
								"Trans Fat --g "+ "\n"+
								"Cholesterol 0mg 0%"+ "\n"+
								"Sodium 10.2mg 1%"+ "\n"+
								"Total Carbohydrate 16.7g 13%"+ "\n"+
								"Dietary Fiber 1.5g 4%"+ "\n"+
								"Sugars 1.2g "+ "\n"+
								"Protein 2g "+ "\n"+
								"Vitamin A 0% \t Vitamin C 18% "+ "\n"+
								"Calcium 1% \t Iron 3% "+ "\n"+
								"*Percent Daily Values (DV) are based on a 2,000 calorie diet.");
		}
		else if(index==4) //Item #4 Egg White Omelet
		{
			menuItem.setName("Egg White Omelet");
			menuItem.setFavorite(true);
			menuItem.addBreakfastDiningHall("Covel");
			menuItem.addLunchDiningHall("De Neve");
			menuItem.addNutInfo("Nutrition Facts"+ "\n"+
								"Serving Size 1 each"+"\n"+
								"Amount Per Serving"+"\n"+
								"Calories 13 Fat Cal. 0"+"\n"+
								"% Daily Value*"+"\n"+
								"Total Fat 0g 0%"+"\n"+
								"Saturated Fat 0g 0%"+"\n"+
								"Trans Fat 0g"+"\n"+ 
								"Cholesterol 0mg 0%"+"\n"+
								"Sodium 44.8mg 3%"+"\n"+
								"Total Carbohydrate 0.3g 0%"+"\n"+
								"Dietary Fiber 0g 0%"+"\n"+
								"Sugars --g"+"\n"+ 
								"Protein 2.8g"+"\n"+ 
								"Vitamin A 0% \t Vitamin C 0%"+"\n"+ 
								"Calcium 0% \t Iron 0%"+"\n"+
								"*Percent Daily Values (DV) are based on a 2,000 calorie diet.");
		}
		else if (index==5) //Item #5 Pepperoni Pizza
		{
			menuItem.setName("Pepperoni Pizza");
			menuItem.setFavorite(true);
//			menuItem.addBreakfastDiningHall("Covel");
			menuItem.addLunchDiningHall("De Neve");
			menuItem.addDinnerDiningHall("Covel");
			menuItem.addNutInfo("Nutrition Facts"+"\n"+
								"Serving Size 1/10 pizza"+"\n"+								
								"Amount Per Serving"+"\n"+								
								"Calories 263 Fat Cal. 116"+"\n"+
								"% Daily Value*"+"\n"+							
								"Total Fat 12.9g 20%"+"\n"+
								"Saturated Fat 3.9g 20%"+"\n"+
								"Trans Fat 0.1g "+"\n"+							
								"Cholesterol 19.4mg 6%"+"\n"+
								"Sodium 376.4mg 25%"+"\n"+
								"Total Carbohydrate 27.5g 21%"+"\n"+
								"Dietary Fiber 1.2g 3%"+"\n"+
								"Sugars 0.9g "+"\n"+							
								"Protein 8.7g "+"\n"+								
								"Vitamin A 3% \t Vitamin C 3%"+"\n"+ 
								"Calcium 9% \t Iron 12% "+"\n"+
								"*Percent Daily Values (DV) are based on a 2,000 calorie diet.");
		}
			
			else if (index==6) //Item #6 Korean Bibimbap Flatbread
			{
				menuItem.setName("Korean Bibimbap Flatbread");
				menuItem.setFavorite(false);
				menuItem.addBreakfastDiningHall("Reiber");
				menuItem.addLunchDiningHall("Bruin Plate");
				menuItem.addDinnerDiningHall("Hedrick");
				menuItem.addDinnerDiningHall("Covel");
				menuItem.addNutInfo("Nutrition Facts"+"\n"+
									"Serving Size 1 piece"+"\n"+
									"Amount Per Serving"+"\n"+
									"Calories 120 Fat Cal. 49"+"\n"+
									"% Daily Value*"+"\n"+
									"Total Fat 5.4g 8%"+"\n"+
									"Saturated Fat 0.9g 4%"+"\n"+
									"Trans Fat 0g "+"\n"+
									"Cholesterol 12.1mg 4%"+"\n"+
									"Sodium 518.1mg 35%"+"\n"+
									"Total Carbohydrate 15.2g 12%"+"\n"+
									"Dietary Fiber 1.6g 4%"+"\n"+
									"Sugars 3.8g"+"\n"+ 
									"Protein 3.5g"+"\n"+ 
									"Vitamin A 56% \t Vitamin C 5%"+"\n"+ 
									"Calcium 3% \t Iron 5% "+"\n"+
									"*Percent Daily Values (DV) are based on a 2,000 calorie diet.");
			}
				
							
			else if (index==7) //Item #7 Apple Pie
			{
				menuItem.setName("Applie Pie");
				menuItem.setFavorite(true);
				menuItem.addBreakfastDiningHall("Hedrick");
				menuItem.addLunchDiningHall("Bruin Plate");
	//			menuItem.addDinnerDiningHall("Reiber");
				menuItem.addNutInfo("Nutrition Facts"+"\n"+ 
									"Serving Size 1 piece"+"\n"+ 
									"Amount Per Serving"+"\n"+ 								
									"Calories 296 Fat Cal. 124"+"\n"+ 
									"% Daily Value*"+"\n"+ 									
									"Total Fat 13.8g 21%"+"\n"+ 
									"Saturated Fat 4.7g 24%"+"\n"+ 
									"Trans Fat --g "+"\n"+									
									"Cholesterol 0mg 0%"+"\n"+ 
									"Sodium 332.5mg 22%"+"\n"+ 
									"Total Carbohydrate 42.5g 33%"+"\n"+ 
									"Dietary Fiber 2g 5%"+"\n"+ 
									"Sugars --g "+"\n"+ 									
									"Protein 2.4g "+"\n"+ 									
									"Vitamin A 3% \t Vitamin C 7%"+"\n"+  
									"Calcium 1% \t Iron 8% "+"\n"+ 
									"*Percent Daily Values (DV) are based on a 2,000 calorie diet.");
			}
		
			else if (index==8) // Item #8 Grilled Kalbi Beef Burger
			{
				menuItem.setName("Grilled Kalbi Beef Burger");
				menuItem.setFavorite(true);
				menuItem.addBreakfastDiningHall("Hedrick");
				menuItem.addLunchDiningHall("Bruin Plate");
				menuItem.addDinnerDiningHall("Reiber");
				menuItem.addDinnerDiningHall("De Neve");
				menuItem.addNutInfo("Nutrition Facts"+"\n"+ 
									"Serving Size 1 each"+"\n"+ 									
									"Amount Per Serving"+"\n"+ 									
									"Calories 558 Fat Cal. 298"+"\n"+ 
									"% Daily Value*"+"\n"+ 								
									"Total Fat 33g 51%"+"\n"+ 
									"Saturated Fat 9.6g 48%"+"\n"+ 
									"Trans Fat 1g "+"\n"+ 									
									"Cholesterol 108.5mg 36%"+"\n"+ 
									"Sodium 511.4mg 34%"+"\n"+ 
									"Total Carbohydrate 38.7g 30%"+"\n"+ 
									"Dietary Fiber 1.3g 3%"+"\n"+ 
									"Sugars 7.2g "+"\n"+ 									
									"Protein 25.4g"+"\n"+  									
									"Vitamin A 14% \t Vitamin C 4%"+"\n"+  
									"Calcium 6% \t Iron 22% "+"\n"+ 
									"*Percent Daily Values (DV) are based on a 2,000 calorie diet.");
			}
		
			else if (index==9) // Item #9 Tofu & Vegetable Stir Fry
			{
				menuItem.setName("Tofu & Vegetable Stir Fry");
				menuItem.setFavorite(false);
				menuItem.addBreakfastDiningHall("Hedrick");
				menuItem.addLunchDiningHall("Bruin Plate");
				menuItem.addDinnerDiningHall("Reiber");
				menuItem.addNutInfo("Nutrition Facts"+"\n"+ 
									"Serving Size 3 oz"+"\n"+ 
									"Amount Per Serving"+"\n"+ 
									"Calories 148 Fat Cal. 34"+"\n"+ 
									"% Daily Value*"+"\n"+ 
									"Total Fat 3.8g 6%"+"\n"+ 
									"Saturated Fat 0.5g 3%"+"\n"+ 
									"Trans Fat 0g "+"\n"+ 
									"Cholesterol 0mg 0%"+"\n"+ 
									"Sodium 175mg 12%"+"\n"+ 
									"Total Carbohydrate 27.6g 21%"+"\n"+ 
									"Dietary Fiber 2.7g 7%"+"\n"+ 
									"Sugars 6.8g "+"\n"+ 
									"Protein 2g"+"\n"+  
									"Vitamin A 79% \t Vitamin C 11%"+"\n"+  
									"Calcium 3% \t Iron 5%"+"\n"+  
									"*Percent Daily Values (DV) are based on a 2,000 calorie diet.");			
			}
			
		
		
		//more items will look better on the demo
		
		
		return menuItem;
	}

}
