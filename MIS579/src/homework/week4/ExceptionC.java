package homework.week4;

/*
 * Matt Wolff
 * MIS579 iLab / Week 3 / Problem 1d
 * Requirements:
 * Use inheritance to create an exception superclass called ExceptionA and exception subclasses ExceptionB and 
 * ExceptionC, where ExceptionB inherits from ExceptionA and ExceptionC inherits from ExceptionB. Write a program to 
 * demonstrate how one catch block can catch all three types of exceptions. That is the catch block for type 
 * ExceptionA that catches exceptions of types ExceptionB and ExceptionC. The idea here is to have you write and 
 * understand exception handling and get a sense of how you might use it in your final project.
 */

public class ExceptionC extends ExceptionB {


  public ExceptionC() {
    super("ExceptionC");
  }

  public ExceptionC(String message) {
    super(message);
  }

  public ExceptionC(Throwable cause) {
    super(cause);
  }

  public ExceptionC(String message, Throwable cause) {
    super(message, cause);
  }


  
}
