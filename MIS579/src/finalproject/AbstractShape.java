package finalproject;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * Matt Wolff
 * MIS579 Final Project
 * WaterVolume.java
 * This abstract Class will 
 */

//Abstract Class for the shapes of either Pools or Spas basically to define some common functions (like calculate volume) and give common fields
public abstract class AbstractShape extends JPanel{
	
	
	private static final long serialVersionUID = 1322502282562419719L;

	public static final ProjectLogger logger = ProjectLogger.getInstance();
	
	protected String shapeName;
	protected GridBagLayout layout;
	protected GridBagConstraints constraints;
	protected Units unit;
	
	public AbstractShape(String shapeName, Units unit){
		this.shapeName = shapeName;
		this.unit = unit;
		this.layout = new GridBagLayout();
		this.setLayout(layout);
		//Constraints
		this.constraints = new GridBagConstraints();
		constraints.insets = new Insets(0, 0, 10, 10);
		this.setBorder(BorderFactory.createTitledBorder(shapeName));
	}
	
	
	//Each subclass will have to include an implementation of calculateVolume();
	public abstract int calculateVolume();
	
	protected void addComponent(Component component, int row, int column, int width, int height) {
		constraints.gridx = column;
		constraints.gridy = row;
		constraints.gridwidth = width;
		constraints.gridheight = height;
		layout.setConstraints(component, constraints);
		add(component);
	}
	
	@Override
	public String toString(){
		return shapeName;
	}

	public String getShapeName() {
		return shapeName;
	}

	public void setShapeName(String shapeName) {
		this.shapeName = shapeName;
	}


	public void setUnit(Units unit) {
		this.unit = unit;
	}
	
}

