package homework.week3;

/*
* Matt Wolff
* MIS579 iLab / Week 3 / Problem 2
* Write a class called Square that is a child class of Rectangle. A square is a rectangle with 
* equal sides. It should inherit the perimeter() and area() methods. It should also inherit the 
* get and set methods for each attribute, if that is appropriate. The Square class should 
* override the getType() method from the superclass so that it returns or outputs "Square."
*/

public class Square extends Rectangle {
	
	//Square has length and width which are identical, so call the Rectange constuctor using size for each dimension
	public Square(int size) {
		super(size, size);
	}
	
	@Override
	public String getType(){
		return "Square";
	}
	
	@Override
	public void setLength(int length){
		//Synch length and width
		super.setLength(length);
		super.setWidth(length);
	}
	@Override
	public void setWidth(int width) {
		//Synch length and width
		super.setLength(width);
		super.setWidth(width);
	}
}

