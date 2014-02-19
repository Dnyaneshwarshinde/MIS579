package finalproject;

import java.awt.GridBagConstraints;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class PoolRectangleShape extends AbstractShape {
	
	private JLabel lengthLabel;
	private JLabel widthLabel;
	private JLabel depthLabel;
	private JTextField lengthTextField;
	private JTextField widthTextField;
	private JTextField depthTextField;

	public PoolRectangleShape(String shapeName, Units unit) {
		super(shapeName, unit);
		
		//Initialize shape specific fields
		lengthLabel = new JLabel(String.format(RunFinalProject.bundle.getString("rectangle.length.label"), unit.toString()));
		widthLabel = new JLabel(String.format(RunFinalProject.bundle.getString("rectangle.width.label"), unit.toString()));
		depthLabel = new JLabel(String.format(RunFinalProject.bundle.getString("rectangle.depth.label"), unit.toString()));
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
	
	public PoolRectangleShape(){
		this("Rectangle", Units.US);	
	}

	@Override
	public int calculateVolume() {
		JOptionPane.showMessageDialog(null,
				"There was an error with one of your entries.  Only integers are accepted.");
		return 0;
	}
	
	@Override
	public void setUnit(Units unit){
		this.unit = unit;
		logger.debug("Changing Labels for unit change.");
		lengthLabel.setText(String.format(RunFinalProject.bundle.getString("rectangle.length.label"), unit.toString()));
		widthLabel.setText(String.format(RunFinalProject.bundle.getString("rectangle.width.label"), unit.toString()));
		depthLabel.setText(String.format(RunFinalProject.bundle.getString("rectangle.depth.label"), unit.toString()));
		repaint();
	}

}

