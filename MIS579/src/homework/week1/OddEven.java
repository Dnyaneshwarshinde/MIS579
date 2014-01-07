package homework.week1;

import java.util.Scanner;

/*
 * Matt Wolff
 * MIS579 iLab / Week 1 / Problem 1
 * Requirements:
 * Write an application that reads an integer and determines and prints whether that integer is odd or even.
 */
public class OddEven {

	public static void main(String[] args) {
		//Set up a variable to get input
		Scanner input = new Scanner(System.in);
		
		int int1; //Will receive the input
		
		System.out.print("Please enter an integer: ");
		int1 = input.nextInt(); //This will read the next integer and assign it to int1
		
		input.close();
		
		if ( int1 % 2 == 0 ){  //Modulus operator finds the remainder
			//If the remainder of a number divided by 2 is 0, then that number is even
			System.out.println("The number (" + int1 + ") is even.");
		} else {
			//If the number is not even, it must be odd
			System.out.println("The number (" + int1 + ") is odd.");
		}
	}
}
