package finalproject;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;

public class MainTabbedPaneFrame extends JFrame {
	
	
	public MainTabbedPaneFrame(){
		super(RunFinal.bundle.getString("window.title"));
		
		JTabbedPane tabbedPane = new JTabbedPane();
		
		//Tab 1 - Pools
		PoolPanel poolPanel = new PoolPanel();
		tabbedPane.addTab(RunFinal.bundle.getString("panel1.title"), null, poolPanel, RunFinal.bundle.getString("panel1.tip"));
		
		
		//Tab 2 - Spas
		JLabel tabLabel2 = new JLabel(RunFinal.bundle.getString("panel2.label"), SwingConstants.CENTER);
		JPanel panel2 = new JPanel();
		panel2.add( tabLabel2 );
		tabbedPane.addTab(RunFinal.bundle.getString("panel2.title"), null, panel2, RunFinal.bundle.getString("panel2.tip"));
		
		
		JPanel panelFooter = new JPanel();
		panelFooter.setLayout(new FlowLayout());
		
		JButton exitButton = new JButton("Exit");
		exitButton.setSize(getMinimumSize());
		panelFooter.add(exitButton);
		
		add(tabbedPane, BorderLayout.CENTER);
		add(panelFooter, BorderLayout.SOUTH);
		
	}
}

