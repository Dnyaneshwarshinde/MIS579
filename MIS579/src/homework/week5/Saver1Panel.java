package homework.week5;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
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
	
	//Added logging for this project
	private static final Logger logger = Logger.getLogger(Saver1Panel.class.getName());
	//Several Constants Used to construct the line
	private static final int COLOR_CHANGE_MAGNITUDE = 20;
	private static final int LINE_CHANGE_MAGNITUDE = 20;
	private static final int LINE_THICKNESS = 3;
	private static final int LINES_TO_DRAW = 100;
	private static final int WAIT_TIME = 100; //milliseconds
	private static final boolean USE_2D = false;
	
	//This array list holds line data and is populated in one of the screen saver methods, which calls the repaint and sleeps
	private ArrayList<LineData> lineDataList = new ArrayList<LineData>();
	//Interrupt will be true when an event listener triggers the exit
	private boolean interrupt = false;
	
	
	
	public Saver1Panel(){
		super();
		//Set the background to black
		this.setBackground(Color.BLACK);
		//Register the mouse handler
		MouseHandler handler = new MouseHandler();
		this.addMouseMotionListener(handler);
	}
	
	//Not part of the assignement, just wanted to load up the lineDataList with some other data
	private void screenSaverRndRelatedLines(){
		do {
			LineData priorLine = getRandomLine();
			
			for (int i=0; i< LINES_TO_DRAW*10; i++){
				//Check to see if the we need to interrupt.
				if (interrupt) {
					break;
				}
				LineData lineData = getVariedLine(priorLine);
				lineDataList.add(lineData);
				priorLine = new LineData(lineData);
				this.repaint();
				//Sleep
				try {
					Thread.sleep(WAIT_TIME);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} //for
			//Emply the ArrayList and start again
			lineDataList.clear();
		} while (!interrupt);
	}
	
	//This method is for the assignement, and will load 100 random lines into the lineDataList
	//While loading the list, repaint is called to update the Panel and then the thread sleeps for a little while
	private void screenSaverRndLines(){
		do {
			for (int i=0; i< LINES_TO_DRAW; i++){
				if (interrupt) {
					break;
				}
				LineData lineData = getRandomLine();
				lineDataList.add(lineData);
				this.repaint();
				try {
					Thread.sleep(WAIT_TIME);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} //for
			lineDataList.clear();
			logger.log(Level.INFO, "Resetting and drawing again.");
		} while (!interrupt);
	}
	
	private void screenSaverBouncingBall(){
		//TODO: Write another screensaver
	}
	
	//This is called from Saver1 to enter screensaver mode with a parameter indicating which type of screensaver to run.
	public void screenSaver(int type){
		switch (type) {
			case 1 :
				screenSaverRndLines();
			case 2 : 
				screenSaverRndRelatedLines();
			case 3 :
				screenSaverBouncingBall();
			default :
				break;
		}
	}
	
	//Paint component just loops through the lineDataList and paints the appropriate lines
	//I've decided to go with Graphics2D version of line so that I can set the thickness, which looks better
	@Override
	public void paintComponent (Graphics g){
		//Call superclass's paint component
		super.paintComponent(g);
		
		//Loop throught he lineData ArrayList and draw each line
		if (USE_2D){
			//Cast g to a Graphics2D instance
			Graphics2D g2 = (Graphics2D)g;
			for(LineData lineData : lineDataList){
				g2.setColor(lineData.color);
				g2.setStroke(new BasicStroke(LINE_THICKNESS));
				g2.draw(new Line2D.Float(lineData.x1, lineData.y1, lineData.x2, lineData.y2));
			}
		} else {
			//Alternate - use the standard drawLine method
			for(LineData lineData : lineDataList){
				g.setColor(lineData.color);
				g.drawLine(lineData.x1, lineData.y1, lineData.x2, lineData.y2);
				//g.fillOval(x, y, width, height);
			}
		}
		
		
		
	}
	
	//This method will return a slightly modified color from the color given.
	//It will randomly select one RGB component and vary it by + or - COLOR_CHANGE_MAGNITUDE value
	private static Color getNextColor(Color startColor){
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
		r = validateColorLevel(r);
		g = validateColorLevel(g);
		b = validateColorLevel(b);
		Color returnColor= new Color(r,g,b);
		return returnColor;
	}
	
	//Just make sure that the color value is within the acceptable range (0-255)
	private static int validateColorLevel(int level){
		if (level > 255) {
			return 255;
		} else if (level < 0) {
			return 0;
		} else {
			return level;
		}
		
	}
	
	//Get a relevant random number
	private static int getRandomBetween(int min, int max){
		return min + (int)(Math.random() * ((max - min) + 1));
	}
	
	//This method will return a LineData object that is slightly different than the one given in the parameters
	//The new LineDat will have a altered color, and endpoints that vary by +- LINE_CHANGE_MAGNITUDE
	public LineData getVariedLine(LineData lineData){
		LineData lineDataReturn = new LineData();
		lineDataReturn.color = getNextColor(lineData.color);
		
		lineDataReturn.x1 = lineData.x1 + getRandomBetween(-LINE_CHANGE_MAGNITUDE, LINE_CHANGE_MAGNITUDE);
		lineDataReturn.x2 = lineData.x2 + getRandomBetween(-LINE_CHANGE_MAGNITUDE, LINE_CHANGE_MAGNITUDE);
		lineDataReturn.y1 = lineData.y1 + getRandomBetween(-LINE_CHANGE_MAGNITUDE, LINE_CHANGE_MAGNITUDE);
		lineDataReturn.y2 = lineData.y2 + getRandomBetween(-LINE_CHANGE_MAGNITUDE, LINE_CHANGE_MAGNITUDE);
		return lineDataReturn;
	}
	//Just get a random line in LineData format
	public LineData getRandomLine(){
		Color color = new Color(getRandomBetween(0,255), getRandomBetween(0,255),getRandomBetween(0,255));
		int x1 = getRandomBetween(0, getWidth());
		int x2 = getRandomBetween(0, getWidth());
		int y1 = getRandomBetween(0, getHeight());
		int y2 = getRandomBetween(0, getHeight());
		LineData lineDataReturn = new LineData(color, x1, y1, x2, y2);
		return lineDataReturn;
	}
	
	//Not going to bother with encapsulation since this is a private inner class
	private	class LineData{

			public Color color;
			public int x1;
			public int x2;
			public int y1;
			public int y2;
			
			public LineData(){
				super();
			}
			
			public LineData(Color color, int x1, int y1, int x2, int y2) {
				super();
				this.color = color;
				this.x1 = x1;
				this.x2 = x2;
				this.y1 = y1;
				this.y2 = y2;
			}	
			
			public LineData(LineData lineData){
				this.color = lineData.color;
				this.x1 = lineData.x1;
				this.x2 = lineData.x2;
				this.y1 = lineData.y1;
				this.y2 = lineData.y2;
			}
		}


	private class MouseHandler implements MouseMotionListener {

		private int lastx = 0;
		private int lasty = 0;
		
		@Override
		public void mouseDragged(MouseEvent event) {
			//Mouse movement detected, exit screen saver
			logger.log(Level.INFO, "Mouse Dragged. Exiting.");
			Saver1Panel.this.interrupt=true;
			Saver1.getFrame().dispose();
			System.exit(0);
			
		}

		@Override
		public void mouseMoved(MouseEvent event) {
			//If lastx is 0, the program just started
			if (lastx != 0){
				if (lastx != event.getX() || lasty != event.getY()){
					logger.log(Level.INFO, "Mouse Moved. Exiting X: " + lastx + " --> " + event.getX());
					logger.log(Level.INFO, "Mouse Moved. Exiting Y: " + lasty + " --> " + event.getY());
					Saver1Panel.this.interrupt=true;
					Saver1.getFrame().dispose();
					System.exit(0);
				} else {
					lastx = event.getX();
					lasty = event.getY();
				}
				
			} else {
				lastx = event.getX();
				lasty = event.getY();
			}
			
		}

		
		
	}
}

