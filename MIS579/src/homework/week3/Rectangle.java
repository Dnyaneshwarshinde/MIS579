package homework.week3;

/*
 * Matt Wolff
 * MIS579 iLab / Week 3 / Problem 1
 * Write a class called Rectangle. It should have length and width attributes that default to 1 if 
 * they are not set. It should have appropriate get and set methods for getting and setting the 
 * attributes. It should also have a perimeter() method that returns the perimeter of the 
 * rectangle. It should also have an area() method that returns the area of the rectangle. It 
 * should also have a getType() method that either returns a String with the value of "Rectangle" 
 * or prints that string value out.
 */

public class Rectangle {
	private int length = 1;
	private int width = 1;
	
	//Constructor using length and width attributes
	public Rectangle(int length, int width) {
		super();
		setLength(length);
		setWidth(width);
		this.length = length;
		this.width = width;
	}
	
	//getType method is supposed to return "Rectangle" for members of Rectangle
	public String getType(){
		return "Rectangle";
	}
	//Perimeter formula is 2*length + 2*width
	public int perimeter(){
		return length*2 + width*2;
	}
	
	//Width formula is just length * width
	public int area(){
		return length*width;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		if (length >= 0) {
			this.length = length;
		} else {
			this.length =0;
		}
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		if (width >= 0) {
			this.width = width;
		} else {
			this.width =0;
		}
	}
	
	@Override
	public String toString(){
		String strReturn = "Rectangle type: " + getType() + "\n";
		strReturn += "Length: " + length + "\t Width: " + width  + "\n";
		strReturn += "Area: " + area() + "\t Perimeter: "+ perimeter()   + "\n";
		
		return strReturn;
	}
	
}

