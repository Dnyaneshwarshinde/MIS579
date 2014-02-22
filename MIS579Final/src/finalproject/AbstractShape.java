package finalproject;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.text.DecimalFormat;



import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
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
	protected static final double GALLONS_PER_CUBIC_FOOT = 7.48052;
	protected static final String CALC_SEPERATOR_LINE = "***************VolumeCalc***************\n";
	protected static final ProjectLogger logger = ProjectLogger.getInstance();
	protected static final String INITIAL_FIELD_VALUE="0.0";
	
	protected DecimalFormat df = new DecimalFormat("#,##0.00##");
	protected String shapeName;
	protected GridBagLayout layout;
	protected GridBagConstraints constraints;
	
	
	public AbstractShape(String shapeName){
		this.shapeName = shapeName;
		this.layout = new GridBagLayout();
		this.setLayout(layout);
		//Constraints
		this.constraints = new GridBagConstraints();
		constraints.insets = new Insets(0, 0, 10, 10);
		this.setBorder(BorderFactory.createTitledBorder(shapeName));
	}
	
	public abstract void show();
	
	
	//Each subclass will have to include an implementation of calculateVolume();
	public abstract String calculateVolume();
	
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

	public abstract void clear();
	
	protected boolean isNumber(String number){
		boolean ret = true;
		try{
			Double.parseDouble(number);
		} catch (NumberFormatException e){
			e.printStackTrace();
			logger.error(e.toString());
			ret = false;
		}
		return ret;
	}
	protected double getNumber(String number){
		return Double.parseDouble(number);
	}
	
	protected void showErrorMessage(){
		JOptionPane.showMessageDialog(this, "There was an error with one of your entries.  Only numbers are accepted.");
	}
	
}

