package homework.week5;

import java.awt.Color;

import javax.swing.JPanel;
/* *
 * Matt Wolff
 * MIS579 iLab / Week 5 / Problem 1
 * Requirements:
 * Design, code, and test an application that simulates a screensaver. The application should randomly draw lines 
 * using method drawLine of class Graphics. After drawing 100 lines, the application should clear the screen and 
 * start drawing lines again. To allow the program to draw continuously, place a call to repaint as the last line in 
 * method paintComponent. There could be problems getting this application to function perfectly on any particular 
 * computer system. That would be a good topic for the discussion threads; how well the screen saver works on your 
 * computer.
 */ 
 

public class Saver1Panel extends JPanel {
	
	private static final int COLOR_CHANGE_MAGNITUDE = 10;
	
	//4 variables
	//Center (like of a polar coordinate system
	//Line size
	//Angle of line 1-180 or 1 - pi radians
	//Color
	
	
	private Color getNextColor(Color startColor){
		//Get the current RGB values
		int r,g,b;
		r = startColor.getRed();
		g = startColor.getGreen();
		b = startColor.getBlue();
		
		//Random number 1-3 to pick which (R, G or B) to change
		int whichToChange = getRandomBetween(1,3);
		int changeAmount = getRandomBetween(-1*COLOR_CHANGE_MAGNITUDE, COLOR_CHANGE_MAGNITUDE);
		//Now change the determine component by the determined amount
		switch (whichToChange) {
			case 1 : r += changeAmount;
			case 2 : g += changeAmount;
			case 3 : b += changeAmount;
		}
		Color returnColor= new Color(r,g,b);
		return returnColor;
	}
	
	//TODO: Change this to private
	public static int getRandomBetween(int min, int max){
		return min + (int)(Math.random() * ((max - min) + 1));
	}
	
	
}

