package finalproject;

import java.awt.Image;
import java.util.ResourceBundle;

import javax.swing.ImageIcon;
import javax.swing.JFrame;




import com.sun.media.sound.Toolkit;

public class RunFinal {

	public static final ResourceBundle bundle = ResourceBundle.getBundle("finalproject.settings");
	
	
	public static void main(String[] args) {
		
		Toolkit kit ;
		
		//Create the JFrame
		MainTabbedPaneFrame frame = new MainTabbedPaneFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setIconImage(new ImageIcon( RunFinal.class.getResource("pool.jpg")).getImage());
		
		frame.setSize(500,500);
		frame.setVisible(true);
	}

}

