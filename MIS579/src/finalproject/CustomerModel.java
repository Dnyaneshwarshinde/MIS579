package finalproject;
public class CustomerModel extends AbstractContactModel {

	public static final int LAST_NAME_COLUMN= 0;
	public static final int FIRST_NAME_COLUMN= 1;
	public static final int CITY_COLUMN= 2;
	public static final int STATE_COLUMN= 3;
	public static final int COLUMN_COUNT=4;
	
	public CustomerModel(String name) {
		super(name);
		//Now load customer data
		
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

}

