package finalproject;

import java.awt.GridBagConstraints;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class EllipseShape extends AbstractShape {
	
	private static final long serialVersionUID = -1688738959855532757L;
	private JLabel majorAxisLabel;
	private JLabel minorAxisLabel;
	private JLabel depthLabel;
	private JTextField majorAxisTextField;
	private JTextField minorAxisTextField;
	private JTextField depthTextField;

	public EllipseShape(String shapeName) {
		super(shapeName);
		show();
	}
	
	
	
	public EllipseShape(){
		this("Ellipse");	
	}

	@Override
	public String calculateVolume() {
		String strReturn = CALC_SEPERATOR_LINE;
		strReturn += "Shape: " + this.shapeName + "\n";
		strReturn += "Major Axis=" + this.majorAxisTextField.getText() + "\n";
		strReturn += "Minor Axis=" + this.minorAxisTextField.getText() + "\n";
		strReturn += "Depth=" + this.depthTextField.getText() + "\n";
		//Error handling
		if (isNumber(this.majorAxisTextField.getText()) && isNumber(this.minorAxisTextField.getText()) && isNumber(this.depthTextField.getText())){
			double A = Double.parseDouble(this.majorAxisTextField.getText());
			double B = Double.parseDouble(this.minorAxisTextField.getText());
			double depth = Double.parseDouble(this.depthTextField.getText());
			double volume = A*B*Math.PI*depth;
			strReturn += "Volume = " + df.format(volume) + " cubic ft" + "\n";
			strReturn += "Volume = " + df.format(volume * GALLONS_PER_CUBIC_FOOT) + " gallons" + "\n";
		} else {
			strReturn += "Error parsing your dimensional entries.\n";
			this.showErrorMessage();
		}
		return strReturn;
		
	}

	public void show() {
		//Initialize shape specific fields
		majorAxisLabel = new JLabel(RunFinalProject.bundle.getString(shapeName.toLowerCase() + ".majoraxis.label"));
		minorAxisLabel = new JLabel(RunFinalProject.bundle.getString(shapeName.toLowerCase() + ".minoraxis.label"));
		depthLabel = new JLabel(RunFinalProject.bundle.getString(shapeName.toLowerCase() + ".depth.label"));
		majorAxisTextField = new JTextField("0", 10);
		majorAxisLabel.setLabelFor(majorAxisTextField);
		constraints.anchor = GridBagConstraints.EAST;
		this.addComponent(majorAxisLabel, 0, 0, 2, 1);
		//shapeDataPanel.add(lengthLabel, getConstraints(shapeGBC, 0, 0, 2, 1));
		constraints.anchor = GridBagConstraints.WEST;
		this.addComponent(majorAxisTextField, 0, 2, 3, 1);
		minorAxisTextField = new JTextField("0", 10);
		minorAxisLabel.setLabelFor(minorAxisTextField);
		constraints.anchor = GridBagConstraints.EAST;
		this.addComponent(minorAxisLabel, 1, 0, 2, 1);
		constraints.anchor = GridBagConstraints.WEST;
		this.addComponent(minorAxisTextField, 1, 2, 3, 1);
		depthTextField = new JTextField("0", 10);
		depthLabel.setLabelFor(depthTextField);
		constraints.anchor = GridBagConstraints.EAST;
		this.addComponent(depthLabel, 2, 0, 2, 1);
		constraints.anchor = GridBagConstraints.WEST;
		this.addComponent(depthTextField, 2, 2, 3, 1);
		
	}
	
	public void clear(){
		majorAxisTextField.setText("0");
		minorAxisTextField.setText("0");
		depthTextField.setText("0");
	}

}

