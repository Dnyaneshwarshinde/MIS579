package finalproject;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class WaterFeaturePanel extends CalcPanel {
	
	private static final long serialVersionUID = -7762344392374040559L;
	
	private AbstractShape[] shapes = { new RectangleShape(), new SquareShape(), new CircleShape(), new EllipseShape(), new RectangleShape("Custom")};
	
	//Labels
	private JLabel panelLabel1;
	//private JLabel footerLabel1;
	//private JLabel footerLabel2;
	private JLabel modelLabel;
	private JLabel shapeLabel;
	
	//ComboBoxes
	private JComboBox modelComboBox;
	private JComboBox shapeComboBox;
	
	//Panels
	private AbstractShape shape;
	private JPanel answerPanel;
	
	//Layouts
	//private GridBagLayout layout;
	//private GridBagConstraints constraints;
	
	
	//Calculate Button
	private JButton calculateButton;
	private JButton clearButton;
	private JButton saveButton;

	private JTextArea answerTextArea;

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
		/*
		layout = new GridBagLayout();
		this.setLayout(layout);
		constraints = new GridBagConstraints();
		constraints.weightx=0;//0.00001;
		constraints.weighty=0;//0.00001;
		constraints.insets = new Insets(0, 0, 10, 10);
		*/
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
		shapeLabel = new JLabel(getResourseString("shape.label"));
		shapeComboBox = new JComboBox(shapes);
		shapeLabel.setLabelFor(shapeComboBox);
		shapeComboBox.setSelectedItem(shapes[0]);
		constraints.anchor = GridBagConstraints.EAST;
		addComponent(shapeLabel, gridRow, 0, 2, 1 );
		constraints.anchor = GridBagConstraints.WEST;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		ShapeHandler shapeHandler = new ShapeHandler();
		shapeComboBox.addItemListener(shapeHandler);
		addComponent(shapeComboBox, gridRow, 2, 2, 1 );
		constraints.fill = GridBagConstraints.NONE;
		gridRow++;
		
		
		//Show the appropriate Shape Input fields
		logger.trace(shapeComboBox.getSelectedItem().getClass().getName());
		shape = (AbstractShape) shapeComboBox.getSelectedItem(); // new RectangleShape();
		addComponent(shape, gridRow, 0, 5, 3);
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
		//saveButton = new JButton(getResourseString("save.button"));
		//saveButton.setMnemonic(getResourseString("save.button.mnemonic").charAt(0));
		//saveButton.addActionListener(buttonHandler);
		addComponent(calculateButton, gridRow, 2, 1, 1);
		addComponent(clearButton, gridRow, 3, 1, 1);
		//addComponent(saveButton, gridRow, 4, 1, 1);
		gridRow++;
		
		//Answer Panel
		answerPanel = new JPanel();
		answerTextArea = new JTextArea(getTextAreaInitialText(), 10, 30);
		answerTextArea.setEditable(false);
		answerPanel.add(new JScrollPane(answerTextArea));
		addComponent(answerPanel, gridRow, 0, 5, 5);
		
	}
	
	private String getTextAreaInitialText(){
		return title + " " + getResourseString("calculationlog.initialtext");
		
	}
	
	private class ButtonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			//See which button was pressed
			if (event.getSource() == calculateButton) {
				//Need to call the Shape dependent implemenation of the calculate function
				logger.debug("Calculate Button Pressed");
				String answer = shape.calculateVolume();
				answerTextArea.append(answer); 

			} else if (event.getSource() == clearButton) {
				// Clear things
				logger.debug("Clear Button Pressed");
				answerTextArea.setText(getTextAreaInitialText());
				shape.clear();
				
			} else if (event.getSource() == saveButton){
				//Save things
				logger.debug("Save Button Pressed");
			}
				
		} // actionPerformed
	}
	
	private class ShapeHandler implements ItemListener {

		@Override
		public void itemStateChanged(ItemEvent event) {
			if (event.getStateChange() == ItemEvent.SELECTED) {
				logger.debug("Shape has changed: " + shapeComboBox.getSelectedItem().toString());
				remove(shape);
				shape = (AbstractShape)shapeComboBox.getSelectedItem();
				addComponent(shape, 3,  0, 5, 3 );
				revalidate();  
				repaint();
				shape.revalidate();
				shape.repaint();
				logger.debug(shape);
			}
		}
	}
	
}

