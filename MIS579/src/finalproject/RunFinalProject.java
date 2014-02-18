package finalproject;

import java.io.IOException;
import java.util.ResourceBundle;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

//Run class
public class RunFinalProject {

	public static final ResourceBundle bundle = ResourceBundle.getBundle("finalproject.settings");
	
	public static void main(String[] args) {
		//ProjectLog.INFO("Starting Final Project.");
		//Create the JFrame
		MainTabbedPaneFrame frame = new MainTabbedPaneFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//ProjectLog.DEBUG("Setting Image Icon");
		frame.setIconImage(new ImageIcon( RunFinalProject.class.getResource(bundle.getString("window.icon"))).getImage());
		try{
			int height = Integer.parseInt(bundle.getString("window.height"));
			int width = Integer.parseInt(bundle.getString("window.width"));
			//ProjectLog.DEBUG("Height: " + height + "\tWidth: " + width);
			frame.setSize(width, height);
			frame.setVisible(true);
			
		} catch (NumberFormatException e){
			e.printStackTrace();
			//ProjectLog.ERROR(e.toString());
		}
		try {
			System.out.println(RunFinalProject.class.getName());
			ClassLoader.getSystemResources(RunFinalProject.class.getName());
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

}

