/* Copyright 2014 Caterpillar Inc. All rights reserved. 
 * The work contains Caterpillar’s proprietary information, 
 * which may constitute a trade secret and/or be confidential. 
 * Copyright notice is precautionary only and does not imply publication.
 * 
 *  
 * Create By : wolffml
 * Create On : Jan 9, 2014
 */
package chapters.four;

import java.awt.Graphics;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class DrawPanel extends JPanel {

	private final static Logger LOGGER = Logger.getLogger(DrawPanel.class.getName());
	private static final int RESOLUTION = 25;
	
	
	public static void main(String[] args) {
		System.setProperty("java.util.logging.SimpleFormatter.format","%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS %4$s %2$s %5$s%6$s%n");
		
		DrawPanel panel = new DrawPanel();
		
		JFrame application = new JFrame();
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		application.add(panel);
		application.setSize (250,250);
		application.setVisible(true);
		
	}
	
	public void paintComponent (Graphics g){
		super.paintComponent(g);
		int width = getWidth();
		int height = getHeight();
		LOGGER.log(Level.INFO, "Height is: " + height);
		LOGGER.log(Level.INFO, "Width is: " + width);
		/*
		
		g.drawLine(0, 0, width, height);
		g.drawLine(0,  height,  width, 0);
		*/
		
		int widthCount = width / RESOLUTION;
		int heightCount = height / RESOLUTION;
		
		for (int i = 1; i <= RESOLUTION ; i++) {
			g.drawLine(0 , heightCount * i, widthCount * i, height);
			g.drawLine(widthCount * i, height, width, height -heightCount *i);
			g.drawLine( width, height -heightCount *i, width - widthCount*i, 0);
			g.drawLine( width - widthCount*i, 0, 0 , heightCount * i);
		}
	}
}

