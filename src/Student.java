import java.util.HashSet;

public class Student {
	
	private String name;
	private String id;
	private HashSet<Course> taken;
	
	public Student(String name, String id) {
		this.name = name;
		this.id = id;
		taken = new HashSet<>();
	}
	
	public boolean checkPrereq(Course c) {
		return true;
	}
	
	public boolean takeCourse(Course c) {
		if (checkPrereq(c)) {
			taken.add(c);
			return true;
		}
		return false;
	}
	
	
}