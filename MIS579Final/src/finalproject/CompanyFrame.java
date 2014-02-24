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

public class CompanyFrame extends JFrame {
	
	private static final long serialVersionUID = -620232134070095811L;
	private static final String TITLE = "Company Data Entry Form";
	protected static final ProjectLogger logger = ProjectLogger.getInstance();
	
	private boolean updateMode = true;
	private OrganizationPanel orgPanel;
	
	private JPanel panel;
	
	private CompanyBean companyBean;
	private JLabel companyNameLabel;
	private JTextField companyNameTextField;
	
	private JLabel contactNameLabel;
	private JTextField contactNameTextField;
	
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
	
	private JLabel productsLabel;
	private JTextField productsTextField;
	
	private JButton saveButton;
	private JButton cancelButton;
	
	
	protected GridBagLayout layout;
	protected GridBagConstraints constraints;
	
	public CompanyFrame(ContactBean bean, OrganizationPanel orgPanel) {
		this.orgPanel = orgPanel;
		this.companyBean = (CompanyBean)bean;
		
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
			height = Integer.parseInt(RunFinalProject.bundle.getString("company.window.height"));
			width = Integer.parseInt(RunFinalProject.bundle.getString("company.window.width"));
		} catch (NumberFormatException e){
			e.printStackTrace();
		}
		this.setSize(width,  height);
		
		companyNameLabel = new JLabel(RunFinalProject.bundle.getString("company.companyname.column"));
		companyNameTextField = new JTextField(companyBean.getCompanyName(),10);
		companyNameLabel.setLabelFor(companyNameTextField);
		constraints.anchor = GridBagConstraints.EAST;
		addComponent(companyNameLabel,     1, 0, 1, 1);
		constraints.anchor = GridBagConstraints.WEST;
		addComponent(companyNameTextField, 1, 1, 2, 1);
		
		streetLabel = new JLabel(RunFinalProject.bundle.getString("company.street.column"));
		streetTextField = new JTextField(companyBean.getStreetAddress(), 30);
		streetLabel.setLabelFor(streetTextField);
		constraints.anchor = GridBagConstraints.EAST;
		addComponent(streetLabel,        2, 0, 1, 1);
		constraints.anchor = GridBagConstraints.WEST;
		addComponent(streetTextField,    2, 1, 2, 1);
		
		address2Label = new JLabel(RunFinalProject.bundle.getString("company.street2.column"));
		address2TextField = new JTextField(companyBean.getStreetAddress2(), 30);
		address2Label.setLabelFor(address2TextField);
		constraints.anchor = GridBagConstraints.EAST;
		addComponent(address2Label,      3, 0, 1, 1);
		constraints.anchor = GridBagConstraints.WEST;
		addComponent(address2TextField,  3, 1, 2, 1);
		
		JPanel subPanel = new JPanel();
		
		cityLabel = new JLabel(RunFinalProject.bundle.getString("company.city.column"));
		cityTextField = new JTextField(companyBean.getCity(), 10);
		cityLabel.setLabelFor(cityTextField);
		subPanel.add(cityLabel);
		subPanel.add(cityTextField);
		
		stateLabel = new JLabel(RunFinalProject.bundle.getString("company.state.column"));
		stateTextField = new JTextField(companyBean.getState(), 4);
		stateLabel.setLabelFor(stateTextField);
		subPanel.add(stateLabel);
		subPanel.add(stateTextField);
		
		zipLabel = new JLabel(RunFinalProject.bundle.getString("company.zip.column"));
		zipTextField = new JTextField(companyBean.getZip(), 10);
		zipLabel.setLabelFor(zipTextField);
		subPanel.add(zipLabel);
		subPanel.add(zipTextField);
		
		phoneLabel = new JLabel(RunFinalProject.bundle.getString("company.phone.column"));
		phoneTextField = new JTextField(companyBean.getPhone(), 10);
		phoneLabel.setLabelFor(phoneTextField);
		subPanel.add(phoneLabel);
		subPanel.add(phoneTextField);
		addComponent(subPanel, 4, 0, 10, 1);
		
		contactNameLabel = new JLabel(RunFinalProject.bundle.getString("company.contactname.column"));
		contactNameTextField = new JTextField(companyBean.getContactPerson(),30);
		contactNameLabel.setLabelFor(contactNameTextField);
		constraints.anchor = GridBagConstraints.EAST;
		addComponent(contactNameLabel,      5, 0, 1, 1);
		constraints.anchor = GridBagConstraints.WEST;
		addComponent(contactNameTextField,  5, 1, 2, 1);
		constraints.anchor = GridBagConstraints.EAST;
		
		productsLabel = new JLabel(RunFinalProject.bundle.getString("company.products.column"));
		productsTextField = new JTextField(companyBean.getProducts(), 30);
		productsLabel.setLabelFor(productsTextField);
		constraints.anchor = GridBagConstraints.EAST;
		addComponent(productsLabel,      6, 0, 1, 1);
		constraints.anchor = GridBagConstraints.WEST;
		addComponent(productsTextField,  6, 1, 2, 1);
		constraints.anchor = GridBagConstraints.EAST;
		
		
		ButtonHandler handler = new ButtonHandler();
		
		JPanel buttonPanel = new JPanel(); 
		buttonPanel.setLayout(new BorderLayout());
		
		saveButton = new JButton(RunFinalProject.bundle.getString("company.form.save.button"));
		saveButton.setMnemonic(RunFinalProject.bundle.getString("company.form.save.button.mnemonic").charAt(0));
		saveButton.addActionListener(handler);
		buttonPanel.add(BorderLayout.CENTER, saveButton);
		//addComponent(saveButton, 6, 2, 1, 1);
		
		cancelButton = new JButton(RunFinalProject.bundle.getString("company.form.cancel.button"));
		cancelButton.setMnemonic(RunFinalProject.bundle.getString("company.form.cancel.button.mnemonic").charAt(0));
		cancelButton.addActionListener(handler);
		//addComponent(cancelButton, 6, 3, 1, 1);
		buttonPanel.add(BorderLayout.EAST, cancelButton);
		addComponent(buttonPanel, 7, 2, 2, 1);
		
		this.setTitle(TITLE);
		this.setIconImage(new ImageIcon( CompanyFrame.class.getResource(RunFinalProject.bundle.getString("window.icon"))).getImage());
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	public CompanyFrame(OrganizationPanel orgPanel){
		this(new CompanyBean(), orgPanel);
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
				CompanyFrame.this.dispose();
			} else if (event.getSource() == saveButton) {
				//Update the CustomerBean data
				logger.debug("Save Button Pressed");
				companyBean.setCompanyName(CompanyFrame.this.companyNameTextField.getText());
				companyBean.setContactPerson(CompanyFrame.this.contactNameTextField.getText());
				companyBean.setProducts(CompanyFrame.this.productsTextField.getText());
				companyBean.setStreetAddress(CompanyFrame.this.streetTextField.getText());
				companyBean.setStreetAddress2(CompanyFrame.this.address2TextField.getText());
				companyBean.setCity(CompanyFrame.this.cityTextField.getText());
				companyBean.setState(CompanyFrame.this.stateTextField.getText());
				companyBean.setZip(CompanyFrame.this.zipTextField.getText());
				companyBean.setPhone(CompanyFrame.this.phoneTextField.getText());
				if (!CompanyFrame.this.updateMode) {
					//If this is not update mode, then we need to add the customerBean to the List
					CompanyFrame.this.orgPanel.contactModel.add(companyBean);
					logger.debug("New Company Added.");
				}
				CompanyFrame.this.orgPanel.contactModel.writeFile();
				CompanyFrame.this.dispose();
			}
				
		} // actionPerformed
	}
	
}
