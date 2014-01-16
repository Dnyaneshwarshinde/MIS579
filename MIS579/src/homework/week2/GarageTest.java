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

	private static double runningTotal = 0.0;
	
	public static void main(String[] args) {
		
		//Testing that the hourly rates come out correctly
		System.out.println("Test Data");
		Garage g1 = new Garage(1);
		printOut(g1);
		for (int i = 1; i < 25; i++){
			Garage g = new Garage(i);
			printOut(g);
		}
		
		
		//Now simulate a days worth of customers parking in the garage
		System.out.println("Customer Data");
		int[] custHours = { 5, 12, 23, 4, 9, 1, 9, 10, 18, 10, 17, 8, 5, 13, 1, 4, 6, 4, 12};
		
		double totalCharge = 0.0;
		for (int i = 0; i < custHours.length; i++) {
			Garage g = new Garage(custHours[i]);
			printOut(g, i);
			totalCharge += g.calculateCharges();
		}
		System.out.printf("Total Charge for day $%.2f", totalCharge);
		
			
		
			

	}
	
	public static void printOut(Garage g) {
		double dblOut = g.calculateCharges();
		runningTotal += dblOut;
		System.out.printf("Hours: %s \t Charge: $%.2f \n",g.getHoursParked(), dblOut);
	}
	public static void printOut(Garage g, int customerNumber) {
		double dblOut = g.calculateCharges();
		runningTotal += dblOut;
		System.out.printf("(%s) \t Hours: %s \t Charge: $%.2f \n", customerNumber, g.getHoursParked(), dblOut);
	}

}

