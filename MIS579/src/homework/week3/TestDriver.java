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
	
	
	public static void main(String[] args){
		//Some tests
		Rectangle r = new Rectangle(2,4);
		Square s = new Square(6);
		
		System.out.println(r);
		System.out.println(s);
		
		
		//Now for the main loop for interaction with the user
		boolean blnContinue = true;
		helpChoice();
		//Do this loop 2 - 7 until the user asks to quit
		
		do {
			char charChoice = getValidatedInput().charAt(0);
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
	public static String getValidatedInput(){
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
	public static String getRegEx(){
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
	
	@Command(name="(R)ectangle - Select a Rectangle",symbol='R')
	private static boolean rectangleChoice(){
		System.out.println("Make a Rectangle choice.");
		return true;
	}
	
	@Command(name="(S)quare - Select a Square",symbol='S')
	private static boolean squareChoice(){
		System.out.println("Make a Square choice.");
		
		return true;
	}
	
	@Command(name="(E)xit the program", symbol='E')
	private static boolean exitChoice(){
		System.out.println("Exiting now.");
		return false;
	}
	@Command(name="(H)elp - This Message", symbol='H')
	private static boolean helpChoice(){
		System.out.println("Help Information.  Select any one of the following commands:");
		System.out.println(getAvailableMenuCommands());
		return true;
	}
	
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
	
	@Target(ElementType.METHOD)
	@Retention(RetentionPolicy.RUNTIME)
	public @interface Command {
		String name() default "";
		char symbol();
	}
	
}

