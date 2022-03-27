import java.util.*;

public class Course {
	
	private int id;
	private String name;
	private ArrayList<Course> prereqs;
	
	public Course(String name) {
		this.name = name;
	}
	public Course(String name, ArrayList<Course> prereqs) {
		this.name = name;
		this.prereqs = prereqs;
	}
	public Course(String name, ArrayList<Course> prereqs, int id) {
		this.name = name;
		this.prereqs = prereqs;
		this.id = id;
	}
	
	
	public void addPrereq(Course c) {
		prereqs.add(c);
	}
	public ArrayList<Course> getPrereqs() {
		return prereqs;
	}
	
	public String getName() {
		return name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
