import java.util.ArrayList;

public class Course {
	
	private String name;
	private ArrayList<Course> prereqs;
	
	public Course(String name) {
		this.name = name;
	}
	
	public ArrayList<Course> getPrereqs() {
		return prereqs;
	}
	
}
