import java.io.IOException;
import java.util.ArrayList;

public class TestDriver {

	public static void main(String[] args) throws IOException {
		String[][] classNames = AddTab.getAllClasses("courses-1.txt");
		ArrayList<Course> c = new ArrayList<>();
		for(int i = 0; i < classNames.length; i++) {
			c.add(new Course(classNames[i][0]));
		}
		ArrayList<Student> s = ReadStudents.loadStudents("students.txt");
		ReadStudents.storeStudents("out.txt", s);
	}
	
}
