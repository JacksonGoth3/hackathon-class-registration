import java.util.*;

public class Course {
	
	private String name;
	private ArrayList<Course> prereqs;
	private ArrayList<String> profs;
	
	public Course(String name) {
		this.name = name;
	}
	public Course(String name, ArrayList<Course> prereqs) {
		this.name = name;
		this.prereqs = prereqs;
	}
	public Course(String name, ArrayList<Course> prereqs, ArrayList<String> profs) {
		this.name = name;
		this.prereqs = prereqs;
		this.profs = profs;
	}
	
	
	public void addProf(String name) {
		profs.add(name);
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
	
}
