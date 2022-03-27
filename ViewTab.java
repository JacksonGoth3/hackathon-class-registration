import javax.swing.JPanel;

public class ViewTab extends RegisterTab {

	private static ViewTab instance = null;
	private JPanel ioPanel = null;
	private JPanel tablePanel = null;
	
	private ViewTab() {
		
	}
	
	public static ViewTab getInstance() {
		if(instance == null) {
			instance = new ViewTab();
		}
		return instance;
	}

	
	protected void initIOPanel() {
		ioPanel = new JPanel();
	}

	protected void initTablePanel() {
		tablePanel = new JPanel();
	}
	
	public JPanel getIOPanel() {
		initIOPanel();
		return ioPanel;
	}

	public JPanel getTablePanel() {
		initTablePanel();
		return tablePanel;
	}

}
