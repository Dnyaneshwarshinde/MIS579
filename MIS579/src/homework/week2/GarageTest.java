package homework.week2;

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

public class GarageTest {
	
	public static void main(String[] args) {
		
		//Testing that the hourly rates come out correctly
		System.out.println("Test Data");
		Garage gTest = new Garage("Test Garage");
		for (int i = 1; i < 25; i++){
			gTest.addParker(i);
		}
		gTest.printOut();
		
		
		//Now simulate a days worth of customers parking in the garage
		System.out.println("Customer Data");
		//This array is just a bunch of different parker times in the garage to add to the Garage instance
		int[] custHours = { 5, 12, 23, 4, 9, 1, 9, 10, 18, 10, 17, 8, 5, 13, 1, 4, 6, 4, 12};
		
		//This is the instance of Garage into which will put the parker data
		Garage gCustomer = new Garage("Customer 1 Garage");
		//Loop through the array of Customer Hours parked
		for (int i : custHours){
			//Add another parker to the garage
			gCustomer.addParker(i);
		}
		//Now give a nice print out of each parker's cost for the day and the total
		gCustomer.printOut();

	}
	

}

