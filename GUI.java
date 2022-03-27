import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class GUI {

	private JFrame frame; //Main frame
	private JTabbedPane tabs;
	
	public GUI() {
		frame = new JFrame("Class Registration");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(900,600);
	    
	    tabs = new JTabbedPane();
	    tabs.addTab("Add Courses", new JPanel());
	    tabs.addTab("Remove Courses", new JPanel());
	    tabs.addTab("View Courses", new JPanel());
	    ChangeListener changeListener = new ChangeListener() {
	        public void stateChanged(ChangeEvent changeEvent) {
	          JTabbedPane sourceTabbedPane = (JTabbedPane) changeEvent.getSource();
	          swapTabs(sourceTabbedPane.getTitleAt(sourceTabbedPane.getSelectedIndex()));
	        }
	      };
        tabs.addChangeListener(changeListener);
	    frame.getContentPane().add(tabs, BorderLayout.PAGE_START);
	    swapTabs("Add Courses");
	    
	    frame.setVisible(true);
	}
	
	private void clearTabs() {
		BorderLayout layout = (BorderLayout) frame.getLayout();
		if(layout.getLayoutComponent(BorderLayout.CENTER) != null) {
			frame.getContentPane().remove(layout.getLayoutComponent(BorderLayout.CENTER));
		}
		if(layout.getLayoutComponent(BorderLayout.PAGE_END) != null) {
			frame.getContentPane().remove(layout.getLayoutComponent(BorderLayout.PAGE_END));
		}
	}
	
	private void swapTabs(String newTab) {
		RegisterTab tab = null;
		if(newTab.equals("Add Courses")) {
			tab = AddTab.getInstance();
		} else if(newTab.equals("Remove Courses")) {
			tab = RemoveTab.getInstance();
		} else if(newTab.equals("View Courses")) {
			tab = ViewTab.getInstance();
		} else {
			System.out.println("Error: unable to retrieve tab selected!");
			return;
		}
		clearTabs();
		frame.getContentPane().add(tab.getTablePanel(), BorderLayout.CENTER);
		frame.getContentPane().add(tab.getIOPanel(), BorderLayout.PAGE_END);
	}
	
	public static void main(String[] args) {
		GUI gui = new GUI();
	}
	
}
