package finalproject;

import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class WaterFeaturePanel extends CalcPanel {
	
	private static final long serialVersionUID = -7762344392374040559L;
	//Labels
	private JLabel panelLabel1;
	private JLabel footerLabel1;
	private JLabel footerLabel2;
	private JLabel modelLabel;
	private JLabel shapeLabel;
	private JLabel unitsLabel;
	
	//ComboBoxes
	private JComboBox modelComboBox;
	private JComboBox shapeComboBox;
	
	//Radio Buttons
	private JRadioButton metricRadioButton;
	private JRadioButton usRadioButton;
	private ButtonGroup radioGroup;
	private Units unit;
	
	//Panels
	private AbstractShape shape;
	private JPanel answerPanel;
	
	//Layouts
	private GridBagLayout gbLayout;
	private GridBagConstraints constraints;
	
	
	//Calculate Button
	private JButton calculateButton;
	private JButton clearButton;
	private JButton saveButton;

	public WaterFeaturePanel(String title, String toolTip, String name){
		super(title, toolTip, name);
		initializePanel();
	}
	
	public WaterFeaturePanel(String name) {
		this(RunFinalProject.bundle.getString(name + ".title"), RunFinalProject.bundle.getString(name + ".tip"), name);
	}

	public void initializePanel(){
		//Set up the layout manager
		logger.info("Initializing the panel: " + name);
		gbLayout = new GridBagLayout();
		this.setLayout(gbLayout);
		constraints = new GridBagConstraints();
		constraints.weightx=0;//0.00001;
		constraints.weighty=0;//0.00001;
		constraints.insets = new Insets(0, 0, 10, 10);
		int gridRow = 0;
		
		//Top Label
		panelLabel1 = new JLabel(getResourseString("label"), SwingConstants.CENTER);
		panelLabel1.setFont(new Font(UIManager.getDefaults().getFont("TabbedPane.font").getFontName(),Font.PLAIN, 28));
		panelLabel1.setLabelFor(this);
		addComponent( panelLabel1, gridRow, 0, 5, 1 );
		gridRow++;
		
		//Model Pick List
		//TODO: Models list should be read in from a text file with items that have been saved
		modelLabel = new JLabel(getResourseString("model.label"));
		modelComboBox = new JComboBox();
		modelComboBox.addItem("Pool 001");
		modelComboBox.addItem("Pool 002");
		modelComboBox.addItem("Pool 003");
		modelComboBox.addItem("Pool 004");
		modelComboBox.addItem("Custom");
		modelLabel.setLabelFor(modelComboBox);
		modelComboBox.setSelectedItem("Custom");
		constraints.anchor = GridBagConstraints.EAST;
		addComponent( modelLabel, gridRow, 0, 2, 1);
		constraints.anchor = GridBagConstraints.WEST;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		addComponent( modelComboBox, gridRow, 2, 2, 1);
		constraints.fill = GridBagConstraints.NONE;
		constraints.anchor = GridBagConstraints.NONE;
		
		gridRow++;
		
		//Shape Pick List
		//TODO: Shapes should be read...
		shapeLabel = new JLabel(getResourseString("shape.label"));
		shapeComboBox = new JComboBox();
		shapeComboBox.addItem("Circle");
		shapeComboBox.addItem("Square");
		shapeComboBox.addItem("Rectangle");
		shapeComboBox.addItem("Oval");
		shapeComboBox.addItem("Custom");
		shapeLabel.setLabelFor(shapeComboBox);
		shapeComboBox.setSelectedItem("Rectangle");
		constraints.anchor = GridBagConstraints.EAST;
		addComponent(shapeLabel, gridRow, 0, 2, 1 );
		constraints.anchor = GridBagConstraints.WEST;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		addComponent(shapeComboBox, gridRow, 2, 2, 1 );
		constraints.fill = GridBagConstraints.NONE;
		gridRow++;
		
		//Units Option Box
		UnitsHandler unitsHandler = new UnitsHandler();
		unitsLabel = new JLabel(getResourseString("units.label"));
		metricRadioButton = new JRadioButton(getResourseString("units.metric.label"), false);
		metricRadioButton.setMnemonic(getResourseString("units.metric.mnemonic").charAt(0));
		metricRadioButton.addActionListener(unitsHandler);
		usRadioButton = new JRadioButton(getResourseString("units.us.label"), true);
		usRadioButton.setMnemonic(getResourseString("units.us.mnemonic").charAt(0));
		usRadioButton.addActionListener(unitsHandler);
		setUnit();
		radioGroup = new ButtonGroup();
		unitsLabel.setLabelFor(usRadioButton);
		radioGroup.add(usRadioButton);
		radioGroup.add(metricRadioButton);
		constraints.anchor = GridBagConstraints.EAST;
		addComponent(unitsLabel, gridRow, 0, 2, 1);
		constraints.anchor = GridBagConstraints.WEST;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		addComponent(usRadioButton, gridRow, 2, 1, 1);
		addComponent(metricRadioButton, gridRow, 3, 1, 1);
		gridRow++;
		
		//TODO: Make the shape choice based on the current selection 
		shape = new PoolRectangleShape("Rectangle", unit);
		addComponent(shape, gridRow, 0, 5,3);
		gridRow=gridRow+3;
		
		//Now for the Buttons - Calculate, Clear and Save
		logger.debug("Creating the Button Handler");
		ButtonHandler buttonHandler = new ButtonHandler();
		logger.debug("Creating the calculate button");
		calculateButton = new JButton(getResourseString("calculate.button"));
		calculateButton.setMnemonic(getResourseString("calculate.button.mnemonic").charAt(0));
		calculateButton.addActionListener(buttonHandler);
		clearButton = new JButton(getResourseString("clear.button"));
		clearButton.setMnemonic(getResourseString("clear.button.mnemonic").charAt(0));
		clearButton.addActionListener(buttonHandler);
		saveButton = new JButton(getResourseString("save.button"));
		saveButton.setMnemonic(getResourseString("save.button.mnemonic").charAt(0));
		saveButton.addActionListener(buttonHandler);
		addComponent(calculateButton, gridRow, 2, 1, 1);
		addComponent(clearButton, gridRow, 3, 1, 1);
		addComponent(saveButton, gridRow, 4, 1, 1);
	}


	private void setUnit() {
		if (metricRadioButton.isSelected()) {
			unit = Units.Metric;
		} else {
			unit = Units.US;
		}
	}

	//Just a helper method to make GridBagLayout easier
	private void addComponent(Component component, int row, int column, int width, int height) {
		constraints.gridx = column;
		constraints.gridy = row;
		constraints.gridwidth = width;
		constraints.gridheight = height;
		gbLayout.setConstraints(component, constraints);
		add(component);
	}
	
	
	private class ButtonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			//See which button was pressed
			if (event.getSource() == calculateButton) {
				//Need to call the Shape dependent implemenation of the calculate function
				logger.debug("Calculate Button Pressed");
				int answer = WaterFeaturePanel.this.shape.calculateVolume();

			} else if (event.getSource() == clearButton) {
				// Clear things
				logger.debug("Clear Button Pressed");
				
			} else if (event.getSource() == saveButton){
				//Save things
				logger.debug("Save Button Pressed");
			}
				
		} // actionPerformed
	}
	
	private class UnitsHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			logger.debug(event.getSource());
			WaterFeaturePanel.this.setUnit();
			shape.setUnit(unit);
			logger.debug("Setting unit: " + unit);
		}
	}
	
}

