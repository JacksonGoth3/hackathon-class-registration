import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class ReadStudents {
	
	public static Course getCourse(String name, ArrayList<Course> courseList) {
		for(int i = 0; i < courseList.size(); i++) {
			Course c = courseList.get(i);
			if (c.getName() == name) {
				return c;
			}
		}
		return null;
	}
	
	public static ArrayList<Student> loadStudents(String fname, ArrayList<Course> courseList) throws IOException {
		ArrayList<Student> students = new ArrayList<>();
		Scanner s = new Scanner(new FileInputStream(fname));
		while(s.hasNext()) {
			// Name & ID
			String name = s.next();
			int id = s.nextInt();
			Student curStudent = new Student(name, id);
			// Taken courses
			while(true) {
				String courseName = s.next();
				if (courseName == "~") {
					break;
				}
				curStudent.addTaken(getCourse(courseName, courseList));
			}
			// Taking courses
			while(true) {
				String courseName = s.next();
				if (courseName == "~") {
					break;
				}
				curStudent.takeCourse(getCourse(courseName, courseList));
			}
			// Add student to array
			students.add(curStudent);
		}
		
		s.close();
		return students;
	}
	
	// Load from file
	public void storeStudents(String fname, ArrayList<Student> students) throws IOException {
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(fname)));
		for(int i = 0; i < students.size(); i++) {
			// Save name & id
			Student s = students.get(i);
			pw.print(s.getName() + " ");
			pw.print(s.getId() + " ");
			// Save classes taken
			Object[] takenArray = s.getTaken().toArray();
			for(int j = 0; j < takenArray.length; j++) {
				pw.println(((Course)takenArray[j]).getName() + " ");
			}
			pw.print("~ ");
			Object[] takingArray = s.getTaking().toArray();
			for(int j = 0; j < takingArray.length; j++) {
				pw.println(((Course)takingArray[j]).getName() + " ");
			}
		}
		pw.close();
	}
	
}
