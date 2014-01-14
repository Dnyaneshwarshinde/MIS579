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
public class Garage {
	
	private static final double MINIMUM_FEE = 2.0;
	private static final double MAXIMUM_FEE = 10.0;
	private static final double HOURLY_RATE = 0.5;
	
	private int hoursParked;
	
	public Garage(int hoursParked) {
		this.hoursParked = hoursParked;
	}
	
	public double getHoursParked() {
		return hoursParked;
	}

	public void setHoursParked(int hoursParked) {
		this.hoursParked = hoursParked;
	}
	
	public double calculateCharges(){
		double retCalc = hoursParked * HOURLY_RATE;
		if (retCalc > MAXIMUM_FEE) {
			retCalc = MAXIMUM_FEE;
		} else if (retCalc < MINIMUM_FEE) {
			retCalc = MINIMUM_FEE;
		}
		return retCalc;
	}
	
	

}

