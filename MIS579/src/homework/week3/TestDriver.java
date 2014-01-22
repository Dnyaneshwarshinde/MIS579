package homework.week3;

import java.util.Scanner;

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
	
	public static MenuOption[] MENU_OPTIONS = { 
		new MenuOption("Rectangle",'R',"test"),
		new MenuOption("Square", 'S', "test2"),
		new MenuOption("Help", 'H', "help"),
		new MenuOption("Exit", 'E', "exit")
	};
	
	
	public static void main(String[] args){
		
		Rectangle r = new Rectangle(2,4);
		Square s = new Square(6);
		
		System.out.println(r);
		System.out.println(s);
		
		boolean blnContinue = true;
		//Do this loop 2 - 7 until the user asks to quit
		do {
			
		} while (blnContinue);
	}
	
	public static String getValidatedInput(){
		Scanner sc = new Scanner(System.in);
		while (!sc.hasNext(getRegEx())) {
		        System.out.println("Invalid Choice please choose any of the following");
		        sc.next();
		}
		return "";
	}
	
	public static String getRegEx(){
		String strReturn = "";
		String characters = "";
		for (MenuOption menu: MENU_OPTIONS){
			characters += menu.getSymbol();
		}
		strReturn = "[" + characters.toUpperCase() + characters.toLowerCase() + "]";
		return strReturn;
	}
	
	private String getAvailableMenuCommands(){
		String strReturn = "";
		for (MenuOption menu: MENU_OPTIONS){
			strReturn += "(" + ")" + menu.getSymbol() + " " + menu.getName() + "\n"; 
		}
		return strReturn;
	}
	
	private static class MenuOption{
		
		private String name;
		private char symbol;
		private String action;
		public MenuOption(String name, char symbol, String action) {
			this.name = name;
			this.symbol = symbol;
			this.action = action;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public char getSymbol() {
			return symbol;
		}
		public void setSymbol(char symbol) {
			this.symbol = symbol;
		}
		public String getAction() {
			return action;
		}
		public void setAction(String action) {
			this.action = action;
		}
		
	}
	
}

