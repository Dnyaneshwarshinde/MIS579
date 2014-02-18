package finalproject;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class MainTabbedPaneFrame extends JFrame {
	
	private static final long serialVersionUID = -7638722326754484691L;
	private JTabbedPane tabbedPane;
	private JPanel[] panels = { new PoolPanel() };
	
	
	public MainTabbedPaneFrame(){
		//Create the Frame with the title
		super(RunFinalProject.bundle.getString("window.title"));
		
		//Create a JTabbedPane
		tabbedPane = new JTabbedPane();
		tabbedPane.setBorder(new EmptyBorder(10,10,0,10));
		
		
		//Add tabs to the pane
		//Tab 1 - Pools
		PoolPanel poolPanel = new PoolPanel();
		tabbedPane.addTab(RunFinalProject.bundle.getString("panel1.title"), null, poolPanel, RunFinalProject.bundle.getString("panel1.tip"));
		
		
		//Tab 2 - Spas
		JLabel tabLabel2 = new JLabel(RunFinalProject.bundle.getString("panel2.label"), SwingConstants.CENTER);
		JPanel panel2 = new JPanel();
		panel2.add( tabLabel2 );
		tabbedPane.addTab(RunFinalProject.bundle.getString("panel2.title"), null, panel2, RunFinalProject.bundle.getString("panel2.tip"));
		
		//Add a footer panel for the exit button
		JPanel panelFooter = new JPanel();
		panelFooter.setLayout(new FlowLayout());
		
		JButton exitButton = new JButton("Exit");
		exitButton.setSize(getMinimumSize());
		exitButton.setMnemonic('x');
		panelFooter.add(exitButton);
		
		add(tabbedPane, BorderLayout.CENTER);
		add(panelFooter, BorderLayout.SOUTH);
		
	}
}

