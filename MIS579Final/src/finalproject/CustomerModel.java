package finalproject;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class CustomerModel extends AbstractContactModel {

	private static final long serialVersionUID = -2725417380548450374L;
	public static final int LAST_NAME_COLUMN= 0;
	public static final int FIRST_NAME_COLUMN= 1;
	public static final int CITY_COLUMN= 2;
	public static final int STATE_COLUMN= 3;
	public static final int COLUMN_COUNT=4;
	
	public CustomerModel(String name) {
		super(name);
		
		//Now load customer data
		
		CustomerBean cb = new CustomerBean();
		cb.setFirstName("Matt");
		cb.setLastName("Wolff");
		cb.setStreetAddress("123 Bedrock Ct.");
		cb.setCity("OakCity");
		cb.setState("IL");
		cb.setZip("12345");
		this.add(cb);
		
		
		/*
		try {
			list = readListFile();
			//add(list);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			logger.error("Error reading CustomerFile");
		}
		*/
		
		try {
			this.writeListFile();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			logger.error(e.toString());
		}
		
		
	}
	
	@Override
	public int getColumnCount() {
		return COLUMN_COUNT;
	}

	@Override
	public Object getValueAt(int row, int column) {
		CustomerBean contact = (CustomerBean)list.get(row);
		switch (column){
			case LAST_NAME_COLUMN:
				return contact.getLastName();
			case FIRST_NAME_COLUMN:
				return contact.getFirstName();
			case CITY_COLUMN:
				return contact.getCity();
			case STATE_COLUMN:
				return contact.getState();
		}
		return null;
	}
	
	private List<ContactBean> readListFile() throws FileNotFoundException{
		FileInputStream is = new FileInputStream(file);
	    XMLDecoder decoder = new XMLDecoder(is);
	    List<ContactBean> list = (List<ContactBean>) decoder.readObject(); 
	    decoder.close();
	    return list;
	}
	
	private void writeListFile() throws FileNotFoundException{
		FileOutputStream os =new FileOutputStream(file);
	    XMLEncoder encoder=new XMLEncoder(os);
	    //for (ContactBean contact : list){
	    //	encoder.writeObject(contact);
	    //}
	    logger.info("Writing datat to file: " + file.getAbsolutePath());
	    encoder.writeObject(list);
	    encoder.close();
	}

	@Override
	public TableColumnModel getColumnModel() {
		DefaultTableColumnModel columnModel = new DefaultTableColumnModel();
		TableColumn column = new TableColumn();
		
		//Last Name
		column.setModelIndex(LAST_NAME_COLUMN);
		column.setHeaderValue(this.getResourseString("lastname.column"));
		column.setPreferredWidth(26);
		columnModel.addColumn(column);
		
		//First Name
		column = new TableColumn();
		column.setModelIndex(FIRST_NAME_COLUMN);
		column.setHeaderValue(this.getResourseString("firstname.column"));
		column.setPreferredWidth(26);
		columnModel.addColumn(column);
		
		//City
		column = new TableColumn();
		column.setModelIndex(CITY_COLUMN);
		column.setHeaderValue(this.getResourseString("city.column"));
		column.setPreferredWidth(26);
		columnModel.addColumn(column);
		
		//State
		column = new TableColumn();
		column.setModelIndex(STATE_COLUMN);
		column.setHeaderValue(this.getResourseString("state.column"));
		column.setPreferredWidth(13);
		columnModel.addColumn(column);
		
		return columnModel;
	}

}

