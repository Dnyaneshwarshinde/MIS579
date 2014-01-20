package homework.week2;

import java.util.Scanner;

/*
 * Matt Wolff
 * MIS579 iLab / Week 2 / Problem 2
 * Requirements:A small airline has just purchased a computer for its new automated reservations system. You've 
 * been asked to develop the new system. You are to write an application to assign seats on each 
 * flight of the airline's only plane (capacity: 10 seats).
 * 
 * Your application should display the following alternatives: "Please type 1 for First Class and 
 * Please type 2 for Economy." If the user types 1, your application should assign a seat in the 
 * first-class section, which is seats 1 through 5. If the user types 2, your application should 
 * assign a seat in the economy section, which is seats 6 through 10. Your application should then 
 * display a boarding pass indicating the person's seat number and whether it is in the first 
 * class or economy section of the plane.
 * 
 * Use a one-dimensional array of primitive type boolean to represent the seating chart of the 
 * plane. Initialize all the elements of the array to false to indicate that all the seats are 
 * empty. As each seat is assigned, set the corresponding element of the array to true to indicate 
 * that the seat is no longer available. Your application should never assign a seat that has 
 * already been assigned. When the economy section is full, your application should ask the person 
 * if it is acceptable to be placed in the first class section and vice versa if the first-class 
 * section is full and there are seats available in economy. If yes, make the appropriate seat 
 * assignment. If no, display the message "Next flight leaves in 3 hours."
 * 
 */

public class Plane {
	
	private boolean[] seatsReserved = new boolean[10];
	
	public Plane(){
		for (int i = 0; i < seatsReserved.length; i++) {
			seatsReserved[i] = false;
		}
	}
	
	public static void main(String[] args){
		Plane p1 = new Plane();
		//p1.showSeating();
		
		p1.makeReservation();
		
	}
	
	private void makeReservation(){
		System.out.println("Welcome to XYZ Airline Reservation System. Type E to exit.");
		boolean blnContinue = true;
		do {
			String selection = getValidatedInput();
			if (selection.equals("1")){
				//Reserve First class
				//See if any first Class Seats are availabe
				if (firstClassAvailable()){
					//First class is available, so make reservation
					int seat = reserveFirstClass();
					System.out.println("Your First Class reservation was successful.  Seat number: " + getSeatNumberFromArray(seat));
					showBoardingPass(seat);
				} else {
					//In this case, there is no First Class Seating available
					//See if an economy seat is available
					if (economyAvailable()) {
						//Need input to see if they wish to try an economy ticket
						Scanner input = new Scanner (System.in);
						System.out.print("No First Class seats available.  Try a Economy Reservation? (Y/N): ");
						String response = input.next();
						if (response.equalsIgnoreCase("Y")){
							//User will accept an economy ticket, make the reservation
							int seat = reserveEconomy();
							System.out.println("Your Economy reservation was successful.  Seat number: " + getSeatNumberFromArray(seat));
							showBoardingPass(seat);
						} else {
							//User won't accept economy, disply exit string.
							System.out.println("Next flight leaves in 3 hours.");
							blnContinue = false;
						}
						//input.close();
					} else {
						//Nothing available, show exit info
						System.out.println("No seats available in First Class and no Economy Seats. Next flight leaves in 3 hours.");
						blnContinue = false;
					}
				}
			} else if ( selection.equals("2")){
				//Reserve an Economy seat
				if (economyAvailable()){
					//Economy seat available, reserve one
					int seat = reserveEconomy();
					System.out.println("Your Economy reservation was successful.  Seat number: " + getSeatNumberFromArray(seat));
					showBoardingPass(seat);
				} else {
					//No Economy seats available, see if there is a First Class one available
					if (firstClassAvailable()){
						//Need input to see if they will accept First Class
						Scanner input = new Scanner (System.in);
						System.out.print("No Economy seats available.  Try a First Class Reservation? (Y/N): ");
						String response = input.next();
						if (response.equalsIgnoreCase("Y")){
							//Reserve a First Class seat
							int seat = reserveFirstClass();
							System.out.println("Your First Class reservation was successful.  Seat number: " + getSeatNumberFromArray(seat));
							showBoardingPass(seat);
						} else {
							//User won't accept First Class, display exist string
							System.out.println("Next flight leaves in 3 hours.");
							blnContinue = false;
						}
						//input.close();
					} else {
						//Nothing available, display exit string
						System.out.println("No seats available in First Class and no Economy Seats. Next flight leaves in 3 hours.");
						blnContinue = false;
					}
				} //Economy Available
			} else if ( selection.equalsIgnoreCase("S")){
				//Just show the current seating status
				showSeating();
			} else if ( selection.equalsIgnoreCase("E")){
				//Exit option
				System.out.println("Display Final Seating.");
				showSeating();
				System.out.println("Exiting System.");
				blnContinue = false;
			}
		} while ( blnContinue);
		//Now that the input is validated, take the appropriate action for each input
	}
	
	//Loop until the user selects a valid input (1, 2, E or S)
	private String getValidatedInput(){
		Scanner input = new Scanner(System.in);
		boolean inputAccepted = false;
		String response;
		//Loop until a valid input is received
		do {
			System.out.print("Please type 1 for First Class and Please type 2 for Economy: ");
			response = input.next();
			//Use If then else statements to validate input
			if ( response.equals("1") || response.equals ("2") || response.equalsIgnoreCase("E") || response.equalsIgnoreCase("S") ){
				inputAccepted = true;
			} else {
				//No valid input was received, restart the loop
				inputAccepted = false;
				System.out.println("Invalid selection.  Press E to exit.");
			}
		} while (!inputAccepted);
		//input.close();
		return response;
	}
	
	//See if a First Class seat is available
	private boolean firstClassAvailable(){
		boolean blnReturn = false;
		for (int i=0 ; i < 5; i++){
			if (!seatsReserved[i]) {
				blnReturn = true;
				break;
			}
		}
		return blnReturn;
	}
	
	//Make a First Class Reservation with the first seat available
	private int reserveFirstClass(){
		int intReturn = 0;
		//Find the first available first class
		for (int i=0; i < 5; i++){
			if (!seatsReserved[i]){
				intReturn = i;
				seatsReserved[i] = true;
				break;
			}
		}
		return intReturn;
	}
	
	//See if an Economy Class Seat is available
	private boolean economyAvailable(){
		boolean blnReturn = false;
		for (int i=5 ; i < 10; i++){
			if (!seatsReserved[i]) {
				blnReturn = true;
				break;
			}
		}
		return blnReturn;
	}
	
	//Make an Economy reservation with the first seat available
	private int reserveEconomy(){
		int intReturn = 0;
		//Find the first available first class
		for (int i=5; i < 10; i++){
			if (!seatsReserved[i]){
				intReturn = i;
				seatsReserved[i] = true;
				break;
			}
		}
		return intReturn;
	}
	
	//Method just shows the list of seats and whether they are available or taken
	private void showSeating(){
		System.out.println("Printing Airplane reservation status. 1-5 are First Class, 6-10 are Economy.");
		//Loop through the seats by 2, and display 2 seats per line
		for (int i=0 ; i < 10; i = i+2){
			System.out.print("(" + getSeatNumberFromArray(i) + ") " + getSeatSymbol(seatsReserved[i]) + "\t");
			System.out.println("(" + getSeatNumberFromArray(i+1) + ") " + getSeatSymbol(seatsReserved[i+1]));
		}
	}
	
	private static int getSeatNumberFromArray(int arrayIndex){
		return arrayIndex + 1;
	}
	
	//Just a method to show whether the seat is open [ ] or taken [X]
	//This is just used in the showSeating method
	private static String getSeatSymbol(boolean seatReserved){
		if ( seatReserved ){
			return "[X]";
		} else {
			return "[ ]";
		}
	}
	//Show the customer's boarding pass based on the seat
	private void showBoardingPass(int seat){
		String strClass = "";
		if (seat <5 ) {
			strClass = "First Class";
		} else {
			strClass = "Economy";
		}
		System.out.println("*****************BOARDING PASS*****************");
		System.out.println("Class: " + strClass);
		System.out.println("Seat Number: " + getSeatNumberFromArray(seat));
		System.out.println("*****************BOARDING PASS*****************");
	
	}
	

}

