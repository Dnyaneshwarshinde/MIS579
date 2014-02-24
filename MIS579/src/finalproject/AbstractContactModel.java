package finalproject;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumnModel;

public abstract class AbstractContactModel extends AbstractTableModel {

	private static final long serialVersionUID = 4282508930356567909L;
	protected static final ProjectLogger logger = ProjectLogger.getInstance();
	protected List<ContactBean> list = new ArrayList<ContactBean>();
	protected String name;
	protected File file;
	
	public AbstractContactModel(String name) {
		this.name = name;
		String fileName = ""
				//+ AbstractContactModel.class.getProtectionDomain().getCodeSource().getLocation().getPath() 
				//+ System.getProperty("file.separator") 
				+ this.name + ".xml";
		logger.debug("File for " + name + " objects: " + fileName);
		file = new File(fileName);	
		
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
	
	protected String getResourseString(String key){
		String strReturn = "";
		try{
			strReturn = RunFinalProject.bundle.getString(name.toLowerCase() + "." + key);
		} catch(Exception e){
			e.printStackTrace();
			logger.error(e.toString());
		}
		return strReturn;
	}
	

	@Override
	public abstract int getColumnCount();

	@Override
	public int getRowCount() {
		return list.size();
	}

	@Override
	public abstract Object getValueAt(int arg0, int arg1);

	public abstract TableColumnModel getColumnModel();

}

