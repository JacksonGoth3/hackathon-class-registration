import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class AddTab extends RegisterTab {

	private static AddTab instance = null;
	private JPanel ioPanel = null;
	private JPanel tablePanel = null;
	
	private AddTab() {
		
	}
	
	public static AddTab getInstance() {
		if(instance == null) {
			instance = new AddTab();
		}
		return instance;
	}

	private TableModel getTableModel() {
		return new DefaultTableModel() {

		    private static final long serialVersionUID = 1L;
		    String[] names = {"Course", "Professor", "Days", "Times", "Credits"};

		    public int getColumnCount() {
		         return 5;
		    }

		    public boolean isCellEditable(int row, int col) {
		         return false;
		    }

		    public int getRowCount() {
		         return 100;
		    }

		    public String getColumnName(int index) {
		        return names[index];
		    }
		};
	}
	
	protected void initIOPanel() {
		ioPanel = new JPanel();
		ioPanel.add(new JButton("Push1"));
		ioPanel.add(new JButton("Push2"));
		ioPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
	}

	protected void initTablePanel() {
		tablePanel = new JPanel();
		JTable table = new JTable(getTableModel());
		tablePanel.add(new JScrollPane(table));
		tablePanel.setMinimumSize(new Dimension(400, 600));
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
