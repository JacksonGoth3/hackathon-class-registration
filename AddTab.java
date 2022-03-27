import java.awt.Dimension;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
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
	private final String[] colNames = {"Course", "Professor", "Days", "Times", "Credits"};
	
	private AddTab() {
		
	}
	
	public static AddTab getInstance() {
		if(instance == null) {
			instance = new AddTab();
		}
		return instance;
	}
	
	protected void initIOPanel() {
		ioPanel = new JPanel();
		ioPanel.add(new JButton("Push1"));
		ioPanel.add(new JButton("Push2"));
		ioPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
	}

	protected void initTablePanel() {
		tablePanel = new JPanel();
		JTable table = new JTable(getAllClasses("courses-1.txt"), colNames);
		tablePanel.add(new JScrollPane(table));
	}
	
	private String[][] getAllClasses(String filename) {
		String[][] output = null;
		try {
			Scanner s = new Scanner(new File(filename));
			int lineCount = 0;
			while(s.hasNextLine()) {
				s.nextLine();
				lineCount++;
			}
			s = new Scanner(new File(filename));
			output = new String[lineCount][5];
			for(int i = 0; i < lineCount; i++) {
				String[] parts = s.nextLine().split(" ");
				String[] newClass = new String[colNames.length];
				for(int j = 0; j < newClass.length - 1; j++) {
					newClass[j] = parts[j];
				}
				newClass[newClass.length - 1] = parts[parts.length - 1];
				output[i] = newClass;
			}
			s.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return output;
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
