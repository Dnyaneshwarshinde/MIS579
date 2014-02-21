package finalproject;

import java.awt.GridBagConstraints;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class CircleShape extends AbstractShape {

	private static final long serialVersionUID = -6466519307040077186L;

	private JLabel radiusLabel;
	private JLabel depthLabel;
	private JTextField radiusTextField;
	private JTextField depthTextField;
	
	public CircleShape(String shapeName) {
		super(shapeName);
		show();
	}
	
	public CircleShape(){
		this("Circle");
	}

	
	@Override
	public void show() {
		logger.debug("Initializing Square panel members.");
		//Initialize shape specific fields
		radiusLabel = new JLabel(RunFinalProject.bundle.getString("circle.radius.label"));
		depthLabel = new JLabel(RunFinalProject.bundle.getString("circle.depth.label"));
		radiusTextField = new JTextField("0", 10);
		radiusLabel.setLabelFor(radiusTextField);
		constraints.anchor = GridBagConstraints.EAST;
		this.addComponent(radiusLabel, 0, 0, 2, 1);
		//shapeDataPanel.add(lengthLabel, getConstraints(shapeGBC, 0, 0, 2, 1));
		constraints.anchor = GridBagConstraints.WEST;
		this.addComponent(radiusTextField, 0, 2, 3, 1);
		depthTextField = new JTextField("0", 10);
		depthLabel.setLabelFor(depthTextField);
		constraints.anchor = GridBagConstraints.EAST;
		this.addComponent(depthLabel, 1, 0, 2, 1);
		constraints.anchor = GridBagConstraints.WEST;
		this.addComponent(depthTextField, 1, 2, 3, 1);

	}

	@Override
	public String calculateVolume() {
		String strReturn = CALC_SEPERATOR_LINE;
		strReturn += "Shape: " + this.shapeName + "\n";
		strReturn += "Radius=" + this.radiusTextField.getText() + "\n";
		strReturn += "Depth=" + this.depthTextField.getText() + "\n";
		//Error handling
		if ( isNumber(this.radiusTextField.getText()) && isNumber(this.depthTextField.getText()) ){
			double radius = getNumber(this.radiusTextField.getText());
			double depth = getNumber(this.depthTextField.getText());
			double volume = radius*radius*Math.PI*depth;
			strReturn += "Volume = " + df.format(volume) + " cubic ft" + "\n";
			strReturn += "Volume = " + df.format(volume * GALLONS_PER_CUBIC_FOOT) + " gallons" + "\n";
			
		} else {
			strReturn += "Error parsing your dimensional entries.\n";
			this.showErrorMessage();
		}
		return strReturn;
	}

	@Override
	public void clear() {
		radiusTextField.setText("0");
		depthTextField.setText("0");

	}

}

