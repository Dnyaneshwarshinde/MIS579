package finalproject;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CustomerFrame extends JFrame {
	
	private static final long serialVersionUID = -620232134070095811L;
	private static final String TITLE = "Customer Data Entry Form";
	protected static final ProjectLogger logger = ProjectLogger.getInstance();
	
	private boolean updateMode = true;
	private OrganizationPanel orgPanel;
	
	private JPanel panel;
	
	private CustomerBean customerBean;
	private JLabel firstNameLabel;
	private JTextField firstNameTextField;
	
	private JLabel lastNameLabel;
	private JTextField lastNameTextField;
	
	private JLabel streetLabel;
	private JTextField streetTextField;
	
	private JLabel address2Label;
	private JTextField address2TextField;
	
	private JLabel cityLabel;
	private JTextField cityTextField;
	
	private JLabel stateLabel;
	private JTextField stateTextField;
	
	private JLabel zipLabel;
	private JTextField zipTextField;
	
	private JLabel phoneLabel;
	private JTextField phoneTextField;
	
	private JButton saveButton;
	private JButton cancelButton;
	
	
	protected GridBagLayout layout;
	protected GridBagConstraints constraints;
	
	public CustomerFrame(ContactBean bean, OrganizationPanel orgPanel) {
		this.orgPanel = orgPanel;
		this.customerBean = (CustomerBean)bean;
		
		panel = new JPanel();
		this.add(panel);
		
		this.layout = new GridBagLayout();
		panel.setLayout(layout);
		constraints = new GridBagConstraints();
		constraints.weightx=0;//0.00001;
		constraints.weighty=0;//0.00001;
		constraints.insets = new Insets(0, 0, 10, 10);
	
		int height = 0;
		int width = 0;
		try{
			height = Integer.parseInt(RunFinalProject.bundle.getString("customer.window.height"));
			width = Integer.parseInt(RunFinalProject.bundle.getString("customer.window.width"));
		} catch (NumberFormatException e){
			e.printStackTrace();
		}
		this.setSize(width,  height);
		firstNameLabel = new JLabel(RunFinalProject.bundle.getString("customer.firstname.column"));
		firstNameTextField = new JTextField(customerBean.getFirstName(),10);
		firstNameLabel.setLabelFor(firstNameTextField);
		lastNameLabel = new JLabel(RunFinalProject.bundle.getString("customer.lastname.column"));
		lastNameTextField = new JTextField(customerBean.getLastName(),10);
		lastNameLabel.setLabelFor(lastNameTextField);
		constraints.anchor = GridBagConstraints.EAST;
		addComponent(lastNameLabel,      0, 0, 1, 1);
		constraints.anchor = GridBagConstraints.WEST;
		addComponent(lastNameTextField,  0, 1, 2, 1);
		constraints.anchor = GridBagConstraints.EAST;
		addComponent(firstNameLabel,     1, 0, 1, 1);
		constraints.anchor = GridBagConstraints.WEST;
		addComponent(firstNameTextField, 1, 1, 2, 1);
		
		streetLabel = new JLabel(RunFinalProject.bundle.getString("customer.street.column"));
		streetTextField = new JTextField(customerBean.getStreetAddress(), 30);
		streetLabel.setLabelFor(streetTextField);
		constraints.anchor = GridBagConstraints.EAST;
		addComponent(streetLabel,        2, 0, 1, 1);
		constraints.anchor = GridBagConstraints.WEST;
		addComponent(streetTextField,    2, 1, 2, 1);
		
		address2Label = new JLabel(RunFinalProject.bundle.getString("customer.street2.column"));
		address2TextField = new JTextField(customerBean.getStreetAddress2(), 30);
		address2Label.setLabelFor(address2TextField);
		constraints.anchor = GridBagConstraints.EAST;
		addComponent(address2Label,      3, 0, 1, 1);
		constraints.anchor = GridBagConstraints.WEST;
		addComponent(address2TextField,  3, 1, 2, 1);
		
		JPanel subPanel = new JPanel();
		
		cityLabel = new JLabel(RunFinalProject.bundle.getString("customer.city.column"));
		cityTextField = new JTextField(customerBean.getCity(), 10);
		cityLabel.setLabelFor(cityTextField);
		subPanel.add(cityLabel);
		subPanel.add(cityTextField);
		
		stateLabel = new JLabel(RunFinalProject.bundle.getString("customer.state.column"));
		stateTextField = new JTextField(customerBean.getState(), 4);
		stateLabel.setLabelFor(stateTextField);
		subPanel.add(stateLabel);
		subPanel.add(stateTextField);
		
		zipLabel = new JLabel(RunFinalProject.bundle.getString("customer.zip.column"));
		zipTextField = new JTextField(customerBean.getZip(), 10);
		zipLabel.setLabelFor(zipTextField);
		subPanel.add(zipLabel);
		subPanel.add(zipTextField);
		
		phoneLabel = new JLabel(RunFinalProject.bundle.getString("customer.phone.column"));
		phoneTextField = new JTextField(customerBean.getPhone(), 10);
		phoneLabel.setLabelFor(phoneTextField);
		subPanel.add(phoneLabel);
		subPanel.add(phoneTextField);
		
		addComponent(subPanel, 4, 0, 10, 1);
		
		ButtonHandler handler = new ButtonHandler();
		
		JPanel buttonPanel = new JPanel(); 
		buttonPanel.setLayout(new BorderLayout());
		
		saveButton = new JButton(RunFinalProject.bundle.getString("customer.form.save.button"));
		saveButton.setMnemonic(RunFinalProject.bundle.getString("customer.form.save.button.mnemonic").charAt(0));
		saveButton.addActionListener(handler);
		buttonPanel.add(BorderLayout.CENTER, saveButton);
		//addComponent(saveButton, 6, 2, 1, 1);
		
		cancelButton = new JButton(RunFinalProject.bundle.getString("customer.form.cancel.button"));
		cancelButton.setMnemonic(RunFinalProject.bundle.getString("customer.form.cancel.button.mnemonic").charAt(0));
		cancelButton.addActionListener(handler);
		//addComponent(cancelButton, 6, 3, 1, 1);
		buttonPanel.add(BorderLayout.EAST, cancelButton);
		addComponent(buttonPanel, 5, 2, 2, 1);
		
		this.setTitle(TITLE);
		this.setIconImage(new ImageIcon( CustomerFrame.class.getResource(RunFinalProject.bundle.getString("window.icon"))).getImage());
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	public CustomerFrame(OrganizationPanel orgPanel){
		this(new CustomerBean(), orgPanel);
		updateMode = false; //New customer mode
	}
	
	protected void addComponent(Component component, int row, int column, int width, int height) {
		constraints.gridx = column;
		constraints.gridy = row;
		constraints.gridwidth = width;
		constraints.gridheight = height;
		layout.setConstraints(component, constraints);
		panel.add(component);
	}
	
	private class ButtonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			//See which button was pressed
			if (event.getSource() == cancelButton) {
				//Dispose of the form
				logger.debug("Cancel Button Pressed");
				CustomerFrame.this.dispose();
			} else if (event.getSource() == saveButton) {
				//Update the CustomerBean data
				logger.debug("Save Button Pressed");
				customerBean.setFirstName(CustomerFrame.this.firstNameTextField.getText());
				customerBean.setLastName(CustomerFrame.this.lastNameTextField.getText());
				customerBean.setStreetAddress(CustomerFrame.this.streetTextField.getText());
				customerBean.setStreetAddress2(CustomerFrame.this.address2TextField.getText());
				customerBean.setCity(CustomerFrame.this.cityTextField.getText());
				customerBean.setState(CustomerFrame.this.stateTextField.getText());
				customerBean.setZip(CustomerFrame.this.zipTextField.getText());
				customerBean.setPhone(CustomerFrame.this.phoneTextField.getText());
				if (!CustomerFrame.this.updateMode) {
					//If this is not update mode, then we need to add the customerBean to the List
					CustomerFrame.this.orgPanel.contactModel.add(customerBean);
					logger.debug("New Customer Added.");
				}
				CustomerFrame.this.orgPanel.contactModel.writeFile();
				CustomerFrame.this.dispose();
			}
				
		} // actionPerformed
	}
	
}
