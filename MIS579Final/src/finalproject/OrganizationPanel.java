package finalproject;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

public class OrganizationPanel extends CalcPanel {
	
	private static final long serialVersionUID = 6929506581372808186L;
	
	public static final String VENDOR = "Vendor";
	public static final String CONTRACTOR = "Contractor";
	public static final String CUSTOMER = "Customer";
	
	private JList recordsList;
	private AbstractContactModel contactModel;
	private JTable table;
	
	private JButton openButton;
	private JButton newButton;
	
	protected GridBagLayout layout;
	protected GridBagConstraints constraints;
	
	//public OrganizationPanel(){}

	public OrganizationPanel(String title, String toolTip, String name) {
		super(title, toolTip, name);
		
		initializeContactModel();
		
		table = new JTable(contactModel);
		
		table.setColumnModel(createColumnModel());
		
		table.setRowHeight(26);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setIntercellSpacing(new Dimension (0,0));

		Dimension viewSize = new Dimension();
		viewSize.width = table.getColumnModel().getTotalColumnWidth();
		viewSize.height = 10* table.getRowHeight();
		table.setPreferredScrollableViewportSize(viewSize);
		
		JTableHeader header = table.getTableHeader();
		header.setPreferredSize(new Dimension(30,26));
		TableCellRenderer headerRenderer = header.getDefaultRenderer();
		if (headerRenderer instanceof JLabel){
			((JLabel) headerRenderer).setHorizontalAlignment(JLabel.CENTER);
		}
		
		JScrollPane scrollpane = new JScrollPane(table);
		
		addComponent(scrollpane, 0, 0, 4, 1);
		
		openButton = new JButton(this.getResourseString("open.button"));
		openButton.setMnemonic(this.getResourseString("open.button.mnemonic").charAt(0));
		addComponent( openButton, 1, 1, 1, 1);
		
		newButton = new JButton(this.getResourseString("new.button"));
		newButton.setMnemonic(this.getResourseString("new.button.mnemonic").charAt(0));
		addComponent( newButton, 1, 2, 1, 1);
		
	}

	private TableColumnModel createColumnModel() {
		return contactModel.getColumnModel();
	}

	private void initializeContactModel() {
		if (title.equalsIgnoreCase(VENDOR)){
			contactModel = new CompanyModel(VENDOR);
		} else if (title.equalsIgnoreCase(CONTRACTOR)){
			contactModel = new CompanyModel(CONTRACTOR);
		} else if (title.equalsIgnoreCase(CUSTOMER)){
			contactModel = new CustomerModel(CUSTOMER);
		} else {
			//This shouldn't necessarily happen, but log it.
			logger.error("Unknown Model type.");
			contactModel = null;
		}
		
	}

	

}
