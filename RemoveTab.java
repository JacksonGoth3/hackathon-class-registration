import javax.swing.JPanel;
import javax.swing.JTable;

public class RemoveTab extends RegisterTab {

	private static RemoveTab instance = null;
	private JPanel ioPanel = null;
	private JPanel tablePanel = null;
	
	private RemoveTab() {
		
	}
	
	public static RemoveTab getInstance() {
		if(instance == null) {
			instance = new RemoveTab();
		}
		return instance;
	}

	protected void initIOPanel() {
		ioPanel = new JPanel();
	}

	protected void initTablePanel() {
		tablePanel = new JPanel();
		JTable table = new JTable(5, 5);
		tablePanel.add(table);
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
