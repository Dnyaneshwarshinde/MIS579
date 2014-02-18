package finalproject;

import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

@CalculatorToolOptions(title="Pool")
public class PoolPanel extends JPanel {
	
	public String title = "Pool";
	
	private static final long serialVersionUID = -7762344392374040559L;
	//Labels
	private JLabel poolPanelLabel1;
	private JLabel footerLabel1;
	private JLabel footerLabel2;
	private JLabel modelLabel;
	private JLabel shapeLabel;
	private JLabel unitsLabel;
	private JLabel lengthLabel;
	private JLabel widthLabel;
	private JLabel depthLabel;
	
	//ComboBoxes
	private JComboBox modelComboBox;
	private JComboBox shapeComboBox;
	
	//Radio Buttons
	private JRadioButton metricRadioButton;
	private JRadioButton usRadioButton;
	private ButtonGroup radioGroup;
	
	//Text Fields
	private JTextField lengthTextField;
	private JTextField widthTextField;
	private JTextField depthTextField;
	
	//Panels
	private JPanel shapeDataPanel;
	
	//Layouts
	private GridBagLayout gbLayout;
	private GridBagConstraints constraints;
	
	
	//Calculate Button
	private JButton calculateButton;
	private JButton clearButton;
	private JButton saveButton;

	
	public PoolPanel(){
		//Set up the layout manager
		gbLayout = new GridBagLayout();
		this.setLayout(gbLayout);
		constraints = new GridBagConstraints();
		constraints.weightx=0;//0.00001;
		constraints.weighty=0;//0.00001;
		constraints.insets = new Insets(0, 0, 10, 10);
		int gridRow = 0;
		
		//Top Label
		poolPanelLabel1 = new JLabel(RunFinalProject.bundle.getString("panel1.label"), SwingConstants.CENTER);
		poolPanelLabel1.setFont(new Font(UIManager.getDefaults().getFont("TabbedPane.font").getFontName(),Font.PLAIN, 28));
		poolPanelLabel1.setLabelFor(this);
		//constraints.anchor = GridBagConstraints.FIRST_LINE_START;
		//constraints.fill = GridBagConstraints.HORIZONTAL;
		addComponent( poolPanelLabel1, gridRow, 0, 5, 1 );
		gridRow++;
		
		//Model Pick List
		//TODO: Models list should be read in from a text file with items that have been saved
		modelLabel = new JLabel(RunFinalProject.bundle.getString("panel1.model.label"));
		modelComboBox = new JComboBox();
		modelComboBox.addItem("Pool 001");
		modelComboBox.addItem("Pool 002");
		modelComboBox.addItem("Pool 003");
		modelComboBox.addItem("Pool 004");
		modelComboBox.addItem("Pool 005");
		modelLabel.setLabelFor(modelComboBox);
		constraints.anchor = GridBagConstraints.EAST;
		addComponent( modelLabel, gridRow, 0, 2, 1);
		constraints.anchor = GridBagConstraints.WEST;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		addComponent( modelComboBox, gridRow, 3, 3, 1);
		constraints.fill = GridBagConstraints.NONE;
		constraints.anchor = GridBagConstraints.NONE;
		
		gridRow++;
		
		//Shape Pick List
		shapeLabel = new JLabel(RunFinalProject.bundle.getString("panel1.shape.label"));
		shapeComboBox = new JComboBox();
		shapeComboBox.addItem("Circle");
		shapeComboBox.addItem("Square");
		shapeComboBox.addItem("Rectangle");
		shapeComboBox.addItem("Oval");
		shapeComboBox.addItem("Custom");
		shapeLabel.setLabelFor(shapeComboBox);
		constraints.anchor = GridBagConstraints.EAST;
		addComponent(shapeLabel, gridRow, 0, 2, 1 );
		constraints.anchor = GridBagConstraints.WEST;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		addComponent(shapeComboBox, gridRow, 3, 3, 1 );
		constraints.fill = GridBagConstraints.NONE;
		gridRow++;
		
		//Units Option Box
		unitsLabel = new JLabel(RunFinalProject.bundle.getString("panel1.units.label"));
		metricRadioButton = new JRadioButton(RunFinalProject.bundle.getString("panel1.untis.metric.label"), false);
		usRadioButton = new JRadioButton(RunFinalProject.bundle.getString("panel1.units.us.label"), true);
		radioGroup = new ButtonGroup();
		unitsLabel.setLabelFor(usRadioButton);
		radioGroup.add(usRadioButton);
		radioGroup.add(metricRadioButton);
		constraints.anchor = GridBagConstraints.EAST;
		addComponent(unitsLabel, gridRow, 0, 2, 1);
		constraints.anchor = GridBagConstraints.WEST;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		addComponent(usRadioButton, gridRow, 3, 1, 1);
		addComponent(metricRadioButton, gridRow, 4, 1, 1);
		gridRow++;
		
		//Length, Width, AvgDepth
		//Panel
		shapeDataPanel = new JPanel();
		GridBagLayout shapeGBL = new GridBagLayout();
		GridBagConstraints shapeGBC = new GridBagConstraints();
		shapeGBC.insets = new Insets(0, 0, 10, 10);
		shapeDataPanel.setLayout(new GridBagLayout());
		shapeDataPanel.setBorder(BorderFactory.createTitledBorder("SHAPE"));
		lengthLabel = new JLabel(RunFinalProject.bundle.getString("panel1.length.label"));
		widthLabel = new JLabel(RunFinalProject.bundle.getString("panel1.width.label"));
		depthLabel = new JLabel(RunFinalProject.bundle.getString("panel1.depth.label"));
		lengthTextField = new JTextField("0", 10);
		lengthLabel.setLabelFor(lengthTextField);
		shapeGBC.anchor = GridBagConstraints.EAST;
		shapeDataPanel.add(lengthLabel, getConstraints(shapeGBC, 0, 0, 2, 1));
		shapeGBC.anchor = GridBagConstraints.WEST;
		shapeDataPanel.add(lengthTextField, getConstraints(shapeGBC, 0, 2, 3, 1));
		widthTextField = new JTextField("0", 10);
		widthLabel.setLabelFor(widthTextField);
		shapeGBC.anchor = GridBagConstraints.EAST;
		shapeDataPanel.add(widthLabel, getConstraints(shapeGBC, 1, 0, 2, 1));
		shapeGBC.anchor = GridBagConstraints.WEST;
		shapeDataPanel.add(widthTextField, getConstraints(shapeGBC, 1, 2, 3, 1));
		depthTextField = new JTextField("0", 10);
		depthLabel.setLabelFor(depthTextField);
		shapeGBC.anchor = GridBagConstraints.EAST;
		shapeDataPanel.add(depthLabel, getConstraints(shapeGBC, 2, 0, 2, 1));
		shapeGBC.anchor = GridBagConstraints.WEST;
		shapeDataPanel.add(depthTextField, getConstraints(shapeGBC, 2, 2, 3, 1));
		addComponent(shapeDataPanel, gridRow, 0, 5,3);
		gridRow=gridRow+3;
		
		//Now for the Buttons - Calculate, Clear and Save
		calculateButton = new JButton(RunFinalProject.bundle.getString("panel1.calculate.button"));
		calculateButton.setMnemonic(RunFinalProject.bundle.getString("panel1.calculate.button.mnemonic").charAt(0));
		clearButton = new JButton(RunFinalProject.bundle.getString("panel1.clear.button"));
		clearButton.setMnemonic(RunFinalProject.bundle.getString("panel1.clear.button.mnemonic").charAt(0));
		saveButton = new JButton(RunFinalProject.bundle.getString("panel1.save.button"));
		saveButton.setMnemonic(RunFinalProject.bundle.getString("panel1.save.button.mnemonic").charAt(0));
		addComponent(calculateButton, gridRow, 2, 1, 1);
		addComponent(clearButton, gridRow, 3, 1, 1);
		addComponent(saveButton, gridRow, 4, 1, 1);
	}


	private void addComponent(Component component, int row, int column, int width, int height) {
		constraints.gridx = column;
		constraints.gridy = row;
		constraints.gridwidth = width;
		constraints.gridheight = height;
		gbLayout.setConstraints(component, constraints);
		add(component);
		
	}
	
	private static GridBagConstraints getConstraints(GridBagConstraints gbc, int row, int column, int width, int height){
		gbc.gridx = column;
		gbc.gridx = column;
		gbc.gridy = row;
		gbc.gridwidth = width;
		gbc.gridheight = height;
		return gbc;
	}
	
	
}

