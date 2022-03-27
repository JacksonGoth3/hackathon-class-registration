import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class AddTab extends RegisterTab {

	private static AddTab instance = null;
	
	private JPanel ioPanel = null;
	private JTextField idField = null;
	private JTextField courseField = null;
	private JButton submit = null;
	
	private JPanel tablePanel = null;
	public static final String[] colNames = {"Course", "Professor", "Days", "Times", "Credits"};
	
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
		ioPanel.add(new JLabel("Student ID:"));
		ioPanel.add(idField = new JTextField(10));
		ioPanel.add(new JLabel("Course:"));
		ioPanel.add(courseField = new JTextField(10));
		ioPanel.add(submit = new JButton("Submit"));
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addCourseForStudent(Integer.parseInt(idField.getText()), courseField.getText());
			}
		});
		ioPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
	}

	private void addCourseForStudent(int studentID, String course) {
		
	}
	
	protected void initTablePanel() {
		tablePanel = new JPanel();
		JTable table = new JTable(getAllClasses("courses-1.txt"), colNames);
		tablePanel.add(new JScrollPane(table));
	}
	
	public static String[][] getAllClasses(String filename) {
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
