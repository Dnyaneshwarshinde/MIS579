package homework.week5;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

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
	
	private static final Logger logger = Logger.getLogger(Saver1Panel.class.getName());
	private static final int COLOR_CHANGE_MAGNITUDE = 20;
	private static final int LINE_CHANGE_MAGNITUDE = 20;
	private static final int LINE_THICKNESS = 3;
	private static final int LINES_TO_DRAW = 100;
	private static final int WAIT_TIME = 100; //milliseconds
	
	private ArrayList<LineData> lineDataList = new ArrayList<LineData>();
	private boolean interrupt = false;
	
	
	
	public Saver1Panel(){
		super();
		MouseHandler handler = new MouseHandler();
		this.addMouseListener(handler);
		
	}
	
	private void screenSaverRndRelatedLines(){
		do {
			LineData priorLine = getRandomLine();
			
			for (int i=0; i< LINES_TO_DRAW; i++){
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
					//logger.log(Level.INFO, "Sleeping for {0} milliseconds", WAIT_TIME);
					Thread.sleep(WAIT_TIME);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} //for
			//Emply the ArrayList and start again
			lineDataList.clear();
		} while (!interrupt);
	}
	
	private void screenSaverRndLines(){
		do {
			for (int i=0; i< LINES_TO_DRAW; i++){
				if (interrupt) {
					break;
				}
				LineData lineData = getRandomLine();
				lineDataList.add(lineData);
				try {
					//logger.log(Level.INFO, "Sleeping for {0} milliseconds", WAIT_TIME);
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
		
	}
	
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
	
	@Override
	public void paintComponent (Graphics g){
		//Call superclass's paint component
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
		
		for(LineData lineData : lineDataList){
			g2.setColor(lineData.color);
			g2.setStroke(new BasicStroke(LINE_THICKNESS));
			g2.draw(new Line2D.Float(lineData.x1, lineData.y1, lineData.x2, lineData.y2));
		}
		//repaint();
	}
	
	
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
	
	public LineData getVariedLine(LineData lineData){
		LineData lineDataReturn = new LineData();
		lineDataReturn.color = getNextColor(lineData.color);
		
		lineDataReturn.x1 = lineData.x1 + getRandomBetween(-LINE_CHANGE_MAGNITUDE, LINE_CHANGE_MAGNITUDE);
		lineDataReturn.x2 = lineData.x2 + getRandomBetween(-LINE_CHANGE_MAGNITUDE, LINE_CHANGE_MAGNITUDE);
		lineDataReturn.y1 = lineData.y1 + getRandomBetween(-LINE_CHANGE_MAGNITUDE, LINE_CHANGE_MAGNITUDE);
		lineDataReturn.y2 = lineData.y2 + getRandomBetween(-LINE_CHANGE_MAGNITUDE, LINE_CHANGE_MAGNITUDE);
		return lineDataReturn;
	}
	
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


	private class MouseHandler implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent event) {
			logger.log(Level.INFO, "Mouse Entered.");	
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			logger.log(Level.INFO, "Mouse Exited.");	
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			logger.log(Level.INFO, "Mouse pressed.");	
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			logger.log(Level.INFO, "Mouse released.");	
			
		}
		
	}
}

