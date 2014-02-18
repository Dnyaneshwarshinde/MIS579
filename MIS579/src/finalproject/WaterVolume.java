package finalproject;

import java.util.ResourceBundle;
import java.util.logging.Logger;

import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * Matt Wolff
 * MIS579 Final Project
 * WaterVolume.java
 * This abstract Class will 
 */



//Abstract Class for Pool and Spa to define some common functions and give common fields
public abstract class WaterVolume extends JPanel{
	
	public static final ResourceBundle bundle = ResourceBundle.getBundle("finalproject.settings");
	public static final Logger logger = Logger.getLogger(WaterVolume.class.getName());
	
	JLabel titleLabel = new JLabel();
	
	//Each subclass will have to include an implementation of calculateVolume();
	public abstract int calculateVolume();
	
}

