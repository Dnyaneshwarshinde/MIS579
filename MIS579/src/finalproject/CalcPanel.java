package finalproject;

import javax.swing.JPanel;

//All of the Panels for the Tabbed Pane need to be subclasses of Abstract Panel
public class CalcPanel extends JPanel {
	
	private static final long serialVersionUID = 5387821003923309744L;
	public static final ProjectLogger logger = ProjectLogger.getInstance();
	
	public String title;
	public String toolTip;
	public String name;
	
	public CalcPanel(String title, String toolTip, String name) {
		this.name = name;
		this.title = title;
		this.toolTip = toolTip;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getToolTip() {
		return toolTip;
	}
	public void setToolTip(String toolTip) {
		this.toolTip = toolTip;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	protected String getResourseString(String key){
		String strReturn = "";
		try{
			strReturn = RunFinalProject.bundle.getString(name + "." + key);
		} catch(Exception e){
			e.printStackTrace();
			logger.error(e.toString());
		}
		return strReturn;
	}

}

