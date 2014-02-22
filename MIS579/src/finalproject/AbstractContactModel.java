package finalproject;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public abstract class AbstractContactModel extends AbstractTableModel {

	private static final long serialVersionUID = 4282508930356567909L;
	protected List<ContactBean> list = new ArrayList<ContactBean>();
	protected String name;
	
	public AbstractContactModel(String name) {
		this.name = name;
	}
	
	public void add(List<ContactBean> newItems){
		int first = list.size();
		int last = first + newItems.size() -1;
		list.addAll(newItems);
		fireTableRowsInserted(first, last);
	}
	
	public void add(ContactBean contact){
		int index = list.size();
		list.add(contact);
		fireTableRowsInserted(index, index);
	}

	@Override
	public abstract int getColumnCount();

	@Override
	public int getRowCount() {
		return list.size();
	}

	@Override
	public abstract Object getValueAt(int arg0, int arg1);

}

