package finalproject;

import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class PoolPanel extends JPanel {
	private JLabel poolPanelLabel1;
	private JLabel footerLabel1;
	private JLabel footerLabel2;
	private JLabel modelLabel;
	private JLabel shapeLabel;
	private JLabel unitsLabel;
	private JLabel lengthLabel;
	private JLabel widthLabel;
	private JLabel depthLabel;
	
	private JList modelList;
	private JList shapeList;
	
	private JTextField lengthTextField;
	private JTextField widthTextField;
	private JTextField depthTextField;
	
	private GridBagLayout gbLayout;
	GridBagConstraints constraints;
	
	
	//Length, width, depth
	//Volume
	//Calculate Button
	
	//10 Rows
	
	public PoolPanel(){
		//Set up the layout manager
		gbLayout = new GridBagLayout();
		this.setLayout(gbLayout);
		constraints = new GridBagConstraints();
		int gridRow = 0;
		//Top Label
		poolPanelLabel1 = new JLabel(RunFinal.bundle.getString("panel1.label"), SwingConstants.CENTER);
		poolPanelLabel1.setFont(new Font(UIManager.getDefaults().getFont("TabbedPane.font").getFontName(),Font.PLAIN, 28));
		addComponent( poolPanelLabel1, gridRow, 0, 5, 1 );
		
		modelLabel = new JLabel(RunFinal.bundle.getString("panel1.label"));
	}


	private void addComponent(Component component, int row, int column, int width, int height) {
		constraints.gridx = column;
		constraints.gridy = row;
		constraints.gridwidth = width;
		constraints.gridheight = height;
		gbLayout.setConstraints(component, constraints);
		add(component);
		
	}
	
}

