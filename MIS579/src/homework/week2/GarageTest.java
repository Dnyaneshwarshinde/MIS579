package homework.week2;

/*
 * Matt Wolff
 * MIS579 iLab / Week 2 / Problem 1
 * Requirements:
 * 
 */

public class GarageTest {

	private static double runningTotal = 0.0;
	
	public static void main(String[] args) {
		
		//Testing
		Garage g1 = new Garage(1);
		printOut(g1);

	}
	public static void printOut(Garage g) {
		double dblOut = g.calculateCharges();
		runningTotal += dblOut;
		System.out.printf("Charge $%2f", dblOut);
	}

}

