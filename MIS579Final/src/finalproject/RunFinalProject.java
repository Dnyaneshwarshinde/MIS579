package finalproject;

import java.util.ResourceBundle;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

import finalproject.ProjectLogger.LogLevel;

//Run this class
public class RunFinalProject {

	//This Resource Bundle has a bunch of strings externalized from the code
	public static final ResourceBundle bundle = ResourceBundle.getBundle("finalproject.settings");
	private static final ProjectLogger logger = ProjectLogger.getInstance();
	
	public static void main(String[] args) {
		logger.setLevel(LogLevel.TRACE);
		logger.info("Starting Final Project.");
		//Create the Main JFrame
		MainTabbedPaneFrame frame = new MainTabbedPaneFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		logger.debug("Setting Image Icon");
		frame.setIconImage(new ImageIcon( RunFinalProject.class.getResource(bundle.getString("window.icon"))).getImage());
		
		logger.info("Run Dir: " + RunFinalProject.class.getProtectionDomain().getCodeSource().getLocation().getPath());
		try{
			//Determine Height and Width of the JFrame
			int height = Integer.parseInt(bundle.getString("window.height"));
			int width = Integer.parseInt(bundle.getString("window.width"));
			logger.debug("Height: " + height + "\tWidth: " + width);
			frame.setSize(width, height);
			frame.setVisible(true);
			
		} catch (NumberFormatException e){
			e.printStackTrace();
			logger.error(e.toString());
		}
	}

}

