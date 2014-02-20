package finalproject;

import java.awt.GridBagConstraints;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class SquareShape extends AbstractShape {

	private static final long serialVersionUID = 2818051138946580817L;
	
	private JLabel lengthLabel;
	private JLabel depthLabel;
	private JTextField lengthTextField;
	private JTextField depthTextField;
	
	public SquareShape(){
		this("Square");
		show();
	}
	
	public SquareShape(String shapeName) {
		super(shapeName);
		logger.debug("Created SquareShape instance.");
	}

	
	

	@Override
	public String calculateVolume() {
		String strReturn = CALC_SEPERATOR_LINE;
		strReturn += "Shape: " + this.shapeName + "\n";
		strReturn += "Length=" + this.lengthTextField.getText() + "\n";
		strReturn += "Depth=" + this.depthTextField.getText() + "\n";
		//TODO: Error handling
		int length = Integer.parseInt(this.lengthTextField.getText());
		int depth = Integer.parseInt(this.depthTextField.getText());
		int volume = length*length*depth;
		strReturn += "Volume = " + volume + " cubic ft" + "\n";
		strReturn += "Volume = " + (volume * GALLONS_PER_CUBIC_FOOT) + " gallons" + "\n";
		strReturn += CALC_SEPERATOR_LINE;
		return strReturn;
	}

	@Override
	public void show() {
		logger.debug("Initializing Square panel members.");
		//Initialize shape specific fields
		lengthLabel = new JLabel(RunFinalProject.bundle.getString("square.length.label"));
		depthLabel = new JLabel(RunFinalProject.bundle.getString("square.depth.label"));
		lengthTextField = new JTextField("0", 10);
		lengthLabel.setLabelFor(lengthTextField);
		constraints.anchor = GridBagConstraints.EAST;
		this.addComponent(lengthLabel, 0, 0, 2, 1);
		//shapeDataPanel.add(lengthLabel, getConstraints(shapeGBC, 0, 0, 2, 1));
		constraints.anchor = GridBagConstraints.WEST;
		this.addComponent(lengthTextField, 0, 2, 3, 1);
		depthTextField = new JTextField("0", 10);
		depthLabel.setLabelFor(depthTextField);
		constraints.anchor = GridBagConstraints.EAST;
		this.addComponent(depthLabel, 1, 0, 2, 1);
		constraints.anchor = GridBagConstraints.WEST;
		this.addComponent(depthTextField, 1, 2, 3, 1);
		
	}
	public void clear(){
		lengthTextField.setText("0");
		depthTextField.setText("0");
	}
	

}

