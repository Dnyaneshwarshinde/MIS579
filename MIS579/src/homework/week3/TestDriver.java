package homework.week3;

import java.util.Scanner;
import java.util.logging.Logger;
import java.lang.annotation.*;
import java.lang.reflect.Method;


/*
* Matt Wolff
* MIS579 iLab / Week 3 / Problem 2
* Write a class called TestDriver that demonstrates all of the code in your Rectangle class and 
* your Square class. The TestDriver class should do the following:
*    1)  Create a Rectangle and a Square.
*    2)  Go into a loop where it asks the user if they want a Rectangle or Square.
*    3)  Read user answer.
*    4)  If user wants to quit, then exit the program.
*    5)  If user wants a Rectangle, ask user for width and length. If user wants a Square, ask 
*        user for the length of one side.
*    6)  Display the type (Rectangle or Square), the length, width, area, and perimeter.
*    7)  Return to Step 2.
*/

public class TestDriver {
	
	private final static Logger LOGGER = Logger.getLogger(TestDriver.class.getName());
	
	private static Rectangle rectangle;
	private static Square square;
	private static Rectangle RAsS;
	
	public static void main(String[] args){
		//Some tests
		
		rectangle = new Rectangle(2,4);
		square = new Square(6);
		
		System.out.println(rectangle);
		System.out.println(square);
		
		RAsS = new Square(6);
		System.out.println(RAsS);
		
		
		//Now for the main loop for interaction with the user
		boolean blnContinue = true;
		
		//Do this loop 2 - 7 until the user asks to quit
		
		//Stay in this loop until the user decides to quit
		do {
			//Print out the menu options
			helpChoice();
			//Get User's Menu Choice
			char charChoice = getValidatedInput().charAt(0);
			//Based on User's menu Choice, get reference to the associated method (annotated method corresponding to the menu choice.)
			Method runMethod = getMethod(charChoice);
			try {
				//Call the method returned by the menu system.  The return will be a boolean
				//that indicates if the user wants to quit and thereby exits the control loop
				blnContinue = (Boolean) runMethod.invoke(null, null);
			} catch (Exception e) {
				e.printStackTrace();
				blnContinue = false;
				System.out.println("An unexpected error has occured.  Exiting program.");
			} 
		} while (blnContinue);
		
		
	}
	
	//This method will return a reference to the method appropriate to the menu selection chosen 
	//as determine by the symbol attribute of the Command annotation
	// i.e. Which method should be run based on the menu choice
	private static Method getMethod(char charChoice) {
		Method returnMethod = null;
		Method[] methods = TestDriver.class.getDeclaredMethods();
		for (Method method: methods){
			if (method.isAnnotationPresent(Command.class)){
				if (method.getAnnotation(Command.class).symbol() == charChoice){
					returnMethod = method;
					break;
				}
			}
		}
		return returnMethod;
	}

	//This method just executes a loop until a valid menu option has been selected.  The validated menu option
	//is returned as a string.
	private static String getValidatedInput(){
		Scanner sc = new Scanner(System.in);
		System.out.printf("Enter Selection: ");
		while (!sc.hasNext(getRegEx())) {
	        System.out.printf("Invalid Choice. Enter Selection: ");
	        //Maybe show help?
		    sc.next();
		}
		return sc.next().toUpperCase();
	}
	
	//This method will generate a string of valid menu choices in the format for a regular expression
	private static String getRegEx(){
		String characters = "";
		Method[] methods = TestDriver.class.getDeclaredMethods();
		for (Method method: methods){
			//LOGGER.fine(method.getName());
			if (method.isAnnotationPresent(Command.class)){
				//LOGGER.info("Annotated: " + method.getName());
				characters += method.getAnnotation(Command.class).symbol();
			}
		}
		//Create the regular expression string
		String strReturn = "[" + characters.toUpperCase() + characters.toLowerCase() + "]";
		return strReturn;
	}
	
	//Rectangle creation method
	@Command(name="(R)ectangle - Select a Rectangle",symbol='R')
	private static boolean rectangleChoice(){
		System.out.println("You have decided on Rectangle.  In order to create a Rectangle, you will need to specify a Length and a Width.");
		System.out.print("Please enter Length (integer): ");
		Scanner sc = new Scanner (System.in);
		//Find out the Length of the desired Rectangle
		while (!sc.hasNextInt()) {
			System.out.print("Input error. Please enter Length (integer): ");
			sc.next();
		}
	    int length = sc.nextInt();
	    //Find out the Width of the desired Rectangle
	    System.out.print("Please enter Width (integer): ");
	    while (!sc.hasNextInt()) {
			System.out.print("Input error. Please enter Width (integer): ");
			sc.next();
		}
	    int width = sc.nextInt();
	    //Create the specified Rectangle
	    rectangle = new Rectangle(length, width);
	    System.out.println("Information about the Rectangle you've created: ");
	    //Print out info about the created Rectangle
	    System.out.println(rectangle);
		return true;
	}
	
	//Square creation method
	@Command(name="(S)quare - Select a Square",symbol='S')
	private static boolean squareChoice(){
		System.out.println("You have decided on Square.  In order to create a Square, you will need to specify the length of any side.");
		//Get the size of the square's side
		System.out.print("Please enter length or size (integer): ");
		Scanner sc = new Scanner (System.in);
		while (!sc.hasNextInt()) {
			System.out.print("Input error. Please enter length or size (integer): ");
			sc.next();
		}
	    int length = sc.nextInt();
	    //Create the square object per the requested dimension
		rectangle = new Square (length);
		System.out.println("Information about the Square you've created: ");
		//Print out releveant square info
	    System.out.println(rectangle);
		return true;
	}
	
	//Exit the program
	@Command(name="(E)xit the program", symbol='E')
	private static boolean exitChoice(){
		System.out.println("Exiting now.");
		return false;
	}
	//Just reshow the Help info for the menu
	@Command(name="(H)elp - This Message", symbol='H')
	private static boolean helpChoice(){
		System.out.println("Help Information.  Select any one of the following commands:");
		System.out.println(getAvailableMenuCommands());
		return true;
	}
	
	//This method returns a string with the Menu commands by finding any
	//methods with the Command annotation and using the Name method to build the menu text.
	private static String getAvailableMenuCommands(){
		String strReturn = "";
		Method[] methods = TestDriver.class.getDeclaredMethods();
		for (Method method: methods){
			//LOGGER.fine(method.getName());
			if (method.isAnnotationPresent(Command.class)){
				//LOGGER.info("Annotated: " + method.getName());
				strReturn += method.getAnnotation(Command.class).name() + "\n"; 
			}
		}
		return strReturn;
	}
	
	//Simple annotation that you put before a method to create an additional menu option
	@Target(ElementType.METHOD)
	@Retention(RetentionPolicy.RUNTIME)
	public @interface Command {
		String name() default "";
		char symbol();
	}
	
}

