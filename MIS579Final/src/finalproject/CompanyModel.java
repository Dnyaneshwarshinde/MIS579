package finalproject;

import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class CompanyModel extends AbstractContactModel {

	private static final long serialVersionUID = 2723704369643527781L;
	public static final int COMPANY_NAME= 0;
	public static final int COMPANY_CONTACT= 1;
	public static final int CITY_COLUMN= 2;
	public static final int STATE_COLUMN= 3;
	public static final int COLUMN_COUNT=4;
	

	public CompanyModel(String name) {
		super(name);
		readFile();
		
		//Now load customer data
		if (this.list.size() == 0) {
			logger.info("No contacts in list.  Adding a generic.");
			CompanyBean cb = new CompanyBean();
			cb.setCompanyName("Acme Products");
			cb.setContactPerson("Road Runner");
			cb.setStreetAddress("123 Desert Road.");
			cb.setCity("Looneysburg");
			cb.setState("NV");
			cb.setZip("12345");
			this.add(cb);
		}
	}

	@Override
	public int getColumnCount() {
		return COLUMN_COUNT;
	}

	@Override
	public Object getValueAt(int row, int column) {
		CompanyBean company = (CompanyBean)list.get(row);
		switch (column){
			case COMPANY_NAME:
				return company.getCompanyName();
			case COMPANY_CONTACT:
				return company.getContactPerson();
			case CITY_COLUMN:
				return company.getCity();
			case STATE_COLUMN:
				return company.getState();
		}
		return null;
	}

	@Override
	public TableColumnModel getColumnModel() {
		DefaultTableColumnModel columnModel = new DefaultTableColumnModel();
		TableColumn column = new TableColumn();
		
		//Last Name
		column.setModelIndex(COMPANY_NAME);
		column.setHeaderValue(RunFinalProject.bundle.getString("company.companyname.column"));
		column.setPreferredWidth(26);
		columnModel.addColumn(column);
		
		//First Name
		column = new TableColumn();
		column.setModelIndex(COMPANY_CONTACT);
		column.setHeaderValue(RunFinalProject.bundle.getString("company.contactname.column"));
		column.setPreferredWidth(26);
		columnModel.addColumn(column);
		
		//City
		column = new TableColumn();
		column.setModelIndex(CITY_COLUMN);
		column.setHeaderValue(RunFinalProject.bundle.getString("company.city.column"));
		column.setPreferredWidth(26);
		columnModel.addColumn(column);
		
		//State
		column = new TableColumn();
		column.setModelIndex(STATE_COLUMN);
		column.setHeaderValue(RunFinalProject.bundle.getString("company.state.column"));
		column.setPreferredWidth(13);
		columnModel.addColumn(column);
		
		return columnModel;
	}

	@Override
	public void newContact(OrganizationPanel panel) {
		new CompanyFrame(panel);
		
	}

	@Override
	public void editContact(OrganizationPanel panel, ContactBean contactBean) {
		new CompanyFrame(contactBean, panel);
	}
	
	
	

}

