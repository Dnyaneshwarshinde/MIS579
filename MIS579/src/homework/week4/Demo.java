package homework.week4;

/*
 * Matt Wolff
 * MIS579 iLab / Week 4 / Problem 1d
 * Requirements:
 * Use inheritance to create an exception superclass called ExceptionA and exception subclasses ExceptionB and 
 * ExceptionC, where ExceptionB inherits from ExceptionA and ExceptionC inherits from ExceptionB. Write a program to 
 * demonstrate how one catch block can catch all three types of exceptions. That is the catch block for type 
 * ExceptionA that catches exceptions of types ExceptionB and ExceptionC. The idea here is to have you write and 
 * understand exception handling and get a sense of how you might use it in your final project.
 */

public class Demo {

	public static void main(String[] args) {

		// One catch block to catch all 3 exception types
		
		System.out.println("Exception Block per exception type demo: ");
		for (int i=0; i<3 ; i++){
			try{
				switch (i) {
					case 0 : giveExceptionC();
					case 1 : giveExceptionB();
					case 2 : giveExceptionA();
				}
			} catch (ExceptionC ec) {
				System.out.println("ExceptionC catch block.");
				System.out.println(ec);
			} catch (ExceptionB eb) {
				System.out.println("ExceptionB catch block.");
				System.out.println(eb);
			} catch (ExceptionA ea) {
				System.out.println("ExceptionA catch block.");
				System.out.println(ea);
			}
			
		} //fore
		
		//This example will catch any Child of ExceptionA.  The messaging shows that actual exception class is preserved
		System.out.println("Exception and Children all Caught in one block demo.");
		for (int i=0; i<3 ; i++){
			try{
				switch (i) {
					case 0 : giveExceptionC();
					case 1 : giveExceptionB();
					case 2 : giveExceptionA();
				}
			} catch (ExceptionA ea) {
				System.out.println("ExceptionA catch block.");
				System.out.println(ea);
				//ea.printStackTrace();
			}
			
		} //for

	}
	

	public static void giveExceptionA() throws ExceptionA {
		throw new ExceptionA();
	}

	public static void giveExceptionB() throws ExceptionB {
		throw new ExceptionB();
	}
	public static void giveExceptionC() throws ExceptionC {
		throw new ExceptionC();
	}

}
