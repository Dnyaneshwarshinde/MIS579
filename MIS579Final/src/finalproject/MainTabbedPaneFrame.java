package finalproject;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

public class MainTabbedPaneFrame extends JFrame {
	
	private static final long serialVersionUID = -7638722326754484691L;
	public static final ProjectLogger logger = ProjectLogger.getInstance();
	private JTabbedPane tabbedPane;
	private CalcPanel[] panels = { new WaterFeaturePanel("panel1"), 
			new WaterFeaturePanel("panel2"),
			new OrganizationPanel("Customer", "Customer", "Customer")}; //, new SpaPanel(), new ContractorPanel(), new VendorsPanel(), new CustomersPanel() };
	
	
	public MainTabbedPaneFrame(){
		//Create the Frame with the title
		super(RunFinalProject.bundle.getString("window.title"));
		logger.debug("Setting window title.");
		
		//Create a JTabbedPane
		logger.debug("Creating Tabs");
		tabbedPane = new JTabbedPane();
		tabbedPane.setBorder(new EmptyBorder(10,10,0,10));
		
		
		//Add tabs to the pane
		//Tab 1 - Pools
		logger.info("Creating Pool Panel and Adding");
		
		for (CalcPanel panel : panels){
			logger.info("Adding panel titled: " + panel.getTitle());
			tabbedPane.addTab(panel.getTitle(), null, panel, panel.getToolTip());
		}
		
		//Add a footer panel for the exit button
		JPanel panelFooter = new JPanel();
		panelFooter.setLayout(new FlowLayout());
		
		JButton exitButton = new JButton("Exit");
		exitButton.setSize(getMinimumSize());
		exitButton.setMnemonic('x');
		ExitHandler exitHandler = new ExitHandler();
		exitButton.addActionListener(exitHandler);
		
		panelFooter.add(exitButton);
		
		add(tabbedPane, BorderLayout.CENTER);
		add(panelFooter, BorderLayout.SOUTH);
		
	}
	
	private class ExitHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			logger.info("Exiting program.");
			int height = MainTabbedPaneFrame.this.getHeight();
			int width = MainTabbedPaneFrame.this.getWidth();
			logger.info("Height: " + height + "\tWidth: " + width);
			MainTabbedPaneFrame.this.dispose();
			System.exit(0);
		}
	}
}

