package finalproject;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JTable;

public class OrganizationPanel extends CalcPanel {
	
	private static final long serialVersionUID = 6929506581372808186L;
	
	private JList recordsList;
	private JTable table;
	
	private JButton openButton;
	private JButton newButton;
	
	protected GridBagLayout layout;
	protected GridBagConstraints constraints;
	
	//public OrganizationPanel(){}

	public OrganizationPanel(String title, String toolTip, String name) {
		super(title, toolTip, name);
		/*
		layout = new GridBagLayout();
		this.setLayout(layout);
		constraints = new GridBagConstraints();
		constraints.weightx=0;//0.00001;
		constraints.weighty=0;//0.00001;
		constraints.insets = new Insets(0, 0, 10, 10);
		*/
		/*
		String[] listItems = {"Item1", "Item2", "Item3", "Item4"};
		recordsList = new JList(listItems);
		recordsList.setVisibleRowCount(10);
		recordsList.setSize(300,400);
		
		recordsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		addComponent( recordsList, 0, 0, 1, 1);
		*/
		table = new JTable();
		
		openButton = new JButton(this.getResourseString("open.button"));
		openButton.setMnemonic(this.getResourseString("open.button.mnemonic").charAt(0));
		addComponent( openButton, 1, 0, 2, 2);
		
		newButton = new JButton(this.getResourseString("new.button"));
		newButton.setMnemonic(this.getResourseString("new.button.mnemonic").charAt(0));
		addComponent( newButton, 1, 1, 1, 1);
		
	}

	

}
