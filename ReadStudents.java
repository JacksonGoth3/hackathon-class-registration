import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class ReadStudents {
	
	public static Course getCourse(String name, ArrayList<Course> courseList) {
		for(int i = 0; i < courseList.size(); i++) {
			Course c = courseList.get(i);
			if (c.getName().equals(name)) {
				return c;
			}
		}
		return null;
	}
	
	private static HashMap<String, Course> getCourseMap(String filename) {
		HashMap<String, Course> output = new HashMap<>();
		try {
			Scanner s = new Scanner(new File(filename));
			while(s.hasNextLine()) {
				String[] parts = s.nextLine().split(" ");
				output.put(parts[0], new Course(parts[0]));
			}
			s.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return output;
	}
	
	public static ArrayList<Student> loadStudents(String fname) throws IOException {
		ArrayList<Student> students = new ArrayList<>();
		//HashMap<String, Course> courseMap = getCourseMap("courses-1.txt");
		Scanner s = new Scanner(new FileInputStream(fname));
		while(s.hasNext()) {
			// Name & ID
			String name = s.next();
			int id = s.nextInt();
			Student curStudent = new Student(name, id);
			// Taken courses
			while(true) {
				String courseName = s.next();
				if (courseName.equals("~")) {
					break;
				}
				curStudent.addTaken(Integer.parseInt(courseName));
			}
			// Taking courses
			while(true) {
				String courseName = s.next();
				if (courseName.equals("~")) {
					break;
				}
				curStudent.takeCourse(Integer.parseInt(courseName));
			}
			// Add student to array
			students.add(curStudent);
		}
		
		s.close();
		return students;
	}
	
	// Load from file
	public static void storeStudents(String fname, ArrayList<Student> students) throws IOException {
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(fname)));
		for(int i = 0; i < students.size(); i++) {
			// Save name & id
			Student s = students.get(i);
			pw.print(s.getName() + " ");
			pw.print(s.getId() + " ");
			// Save classes taken
			Object[] takenArray = s.getTaken().toArray();
			for(int j = 0; j < takenArray.length; j++) {
				pw.print((Integer)takenArray[j] + " ");
			}
			pw.print("~ ");
			Object[] takingArray = s.getTaking().toArray();
			for(int j = 0; j < takingArray.length; j++) {
				pw.print((Integer)takingArray[j] + " ");
			}
			pw.print("~ ");
			pw.println();
		}
		pw.close();
	}
	
}
