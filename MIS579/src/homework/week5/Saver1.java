package homework.week5;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import javax.swing.JFrame;

/*
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

public class Saver1 {
	
	private static final Logger logger = Logger.getLogger(Saver1.class.getName());

	public static void main (String[] args){
		logger.setLevel(Level.INFO);
		
		Saver1Panel panel = new Saver1Panel();
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		
		//Get Screen dimensions for current screen
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		int width = gd.getDisplayMode().getWidth();
		int height = gd.getDisplayMode().getHeight();
		
		logger.log(Level.INFO, "Resolution is: {0} X {1}", new Object[] {width, height});
		
		frame.setUndecorated(true);
		frame.setSize (width, height);
        frame.setResizable(false);
        GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().setFullScreenWindow(frame);
		
		frame.setVisible(true);
		//Now go into screenSaver mode;  (On the panel)
		panel.screenSaver(1);
		/*
		//Testing to verify the getRandomBetweenMethod is inclusive of the min and max
		for(int i=0; i<100; i++){
			int rndInt = Saver1Panel.getRandomBetween(-10, 10);
			logger.log(Level.INFO, "{0}: Number is [{1}]", new Object[] {i, rndInt});
		}
		*/
	}
}

