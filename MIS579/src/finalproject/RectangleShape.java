package finalproject;

import java.awt.GridBagConstraints;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class RectangleShape extends AbstractShape {
	
	private static final long serialVersionUID = -4979842584443768193L;
	private JLabel lengthLabel;
	private JLabel widthLabel;
	private JLabel depthLabel;
	private JTextField lengthTextField;
	private JTextField widthTextField;
	private JTextField depthTextField;

	public RectangleShape(String shapeName) {
		super(shapeName);
		show();
	}
	
	
	
	public RectangleShape(){
		this("Rectangle");	
	}

	@Override
	public String calculateVolume() {
		//JOptionPane.showMessageDialog(null, "There was an error with one of your entries.  Only integers are accepted.");
		String strReturn = CALC_SEPERATOR_LINE;
		strReturn += "Shape: " + this.shapeName + "\n";
		strReturn += "Length=" + this.lengthTextField.getText() + "\n";
		strReturn += "Width=" + this.widthTextField.getText() + "\n";
		strReturn += "Depth=" + this.depthTextField.getText() + "\n";
		//TODO: Error handling
		int length = Integer.parseInt(this.lengthTextField.getText());
		int width = Integer.parseInt(this.widthTextField.getText());
		int depth = Integer.parseInt(this.depthTextField.getText());
		int volume = length*width*depth;
		strReturn += "Volume = " + volume + " cubic ft" + "\n";
		strReturn += "Volume = " + (volume * GALLONS_PER_CUBIC_FOOT) + " gallons" + "\n";
		strReturn += CALC_SEPERATOR_LINE;
		return strReturn;
		
	}

	public void show() {
		//Initialize shape specific fields
		lengthLabel = new JLabel(RunFinalProject.bundle.getString(shapeName.toLowerCase() + ".length.label"));
		widthLabel = new JLabel(RunFinalProject.bundle.getString(shapeName.toLowerCase() + ".width.label"));
		depthLabel = new JLabel(RunFinalProject.bundle.getString(shapeName.toLowerCase() + ".depth.label"));
		lengthTextField = new JTextField("0", 10);
		lengthLabel.setLabelFor(lengthTextField);
		constraints.anchor = GridBagConstraints.EAST;
		this.addComponent(lengthLabel, 0, 0, 2, 1);
		//shapeDataPanel.add(lengthLabel, getConstraints(shapeGBC, 0, 0, 2, 1));
		constraints.anchor = GridBagConstraints.WEST;
		this.addComponent(lengthTextField, 0, 2, 3, 1);
		widthTextField = new JTextField("0", 10);
		widthLabel.setLabelFor(widthTextField);
		constraints.anchor = GridBagConstraints.EAST;
		this.addComponent(widthLabel, 1, 0, 2, 1);
		constraints.anchor = GridBagConstraints.WEST;
		this.addComponent(widthTextField, 1, 2, 3, 1);
		depthTextField = new JTextField("0", 10);
		depthLabel.setLabelFor(depthTextField);
		constraints.anchor = GridBagConstraints.EAST;
		this.addComponent(depthLabel, 2, 0, 2, 1);
		constraints.anchor = GridBagConstraints.WEST;
		this.addComponent(depthTextField, 2, 2, 3, 1);
		
	}
	
	public void clear(){
		lengthTextField.setText("0");
		widthTextField.setText("0");
		depthTextField.setText("0");
	}

}

