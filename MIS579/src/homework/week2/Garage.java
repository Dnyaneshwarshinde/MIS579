package homework.week2;

import java.util.ArrayList;


/*
 * Matt Wolff
 * MIS579 iLab / Week 2 / Problem 1
 * Requirements:A parking garage charges a two dollar minimum fee to park for up to three hours. 
 * The garage charges an additional $0.50 per hour for each hour or part thereof in excess of 3 
 * hours. The maximum charge for any given 24 hour period is $10. Assume that no car parks for 
 * longer than 24 hours at a time. Write an application that calculates and displays the parking 
 * charges for each customer who parked in the garage yesterday. You should enter the hours parked 
 * for each customer. The program should display the charge for the current customer and should 
 * calculate and display the running total of yesterday's receipts. It should use the method 
 * calculateCharges to determine the charge for each customer.
 * 
 */
public class Garage {
	
	//Minimum charge
	private static final double MINIMUM_FEE = 2.0;
	//Minimum hours
	private static final int MINIMUM_HOURS = 3;
	//Maximum fee for parking
	private static final double MAXIMUM_FEE = 10.0;
	//Hourly rate for parking after minimum hours
	private static final double HOURLY_RATE = 0.5;
	
	//This array list will hold instances of Parkers.  In my object model, a Garage is a collection of parkers
	private ArrayList<Parker> parkers= new  ArrayList<Parker>();
	//Just a name to keep the garages apart.  You could also just make this a date so that each instance is the same garage for a different day.
	
	private String garageName = "";
	
	public Garage(String garageName) {
		this.garageName = garageName;
	}
	
	public String getGarageName() {
		return garageName;
	}


	public void setGarageName(String garageName) {
		this.garageName = garageName;
	}


	public ArrayList<Parker> getParkers() {
		return parkers;
	}

	public void setParkers(ArrayList<Parker> parkers) {
		this.parkers = parkers;
	}
	
	public void addParker(int hours){
		//Just some error checking before adding the data to make sure it complies with the expectations
		//Hours should be greater than 0 and less than or equal to 24
		//In real programming, I would create a custom exception and throw it here.  In this case, I'll just correct it.
		if (hours < 0) {
			hours = 0;
		} else if (hours > 24) {
			hours = 24;
		}
		this.parkers.add(new Parker(hours));
	}

	//You don't really need this method since the Parker object itself has a calculateCharges method, but this a convenience method.
	public static double calculateCharges(Parker parker){
		return parker.calculateCharges();
	}
	
	//This method will print the Garage Name, each parker (hours and charge) and a grand total for all parkers
	public void printOut() {
		System.out.println("*****************************\n Garage Printout for: " + garageName);
		//Holder for calculating the total charges for all Parkers in the Garage
		double totalCharges = 0.0;
		//Loop through the parkers ArrayList
		for (Parker parker: parkers){
			//Print the hours and the charge
			System.out.printf("Hours: %s \t Charge: $%.2f \n", parker.getHours(), parker.calculateCharges());
			//Add the current parker charge to the running total
			totalCharges += parker.calculateCharges();
		}
		//Print he total charges
		System.out.printf("Total Charge for day $%.2f \n", totalCharges);
		
	}
	
	/* In needed to create an inner class in this case in order to keep the object model making sense.
	 * In this case, each parker just has an integer for the number of hours parked and the class has the logic for
	 * calulating the total charges
	 */
	public class Parker{
		private int hours;
		public Parker (){
			super();
		}
		
		public Parker(int hours) {
			super();
			this.hours = hours;
		}

		public int getHours() {
			return hours;
		}

		public void setHours(int hours) {
			this.hours = hours;
		}
	
		public double calculateCharges(){
			//The value that will be returned by the method
			double retCalc = 0.0;
			//If we haven't parked for at least the minimum hours, then you simply charge them the minimum charge
			if (hours <= MINIMUM_HOURS) {
				retCalc = MINIMUM_FEE;
			} else { 
				//If the parker was there for more than the minimum, charge the miminum fee for first 3 hours and then the hourly rate thereafter
				retCalc = MINIMUM_FEE + (hours - MINIMUM_HOURS) * HOURLY_RATE;
				//If the charges are greater than the maximum_fee for 24 hours, then just charge the maximum fee.
				if (retCalc > MAXIMUM_FEE) {
					retCalc = MAXIMUM_FEE;
				}
			}
			return retCalc;
		}
	}

}

