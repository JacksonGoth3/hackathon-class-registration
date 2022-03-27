import java.util.*;

public class Course {
	
	private String name;
	private ArrayList<Course> prereqs;
	private ArrayList<String> profs;
	
	public Course(String name) {
		this.name = name;
	}
	public Course(String name, ArrayList<String> profs) {
		this.name = name;
		this.profs = profs;
	}
	
	
	public void addProf(String name) {
		profs.add(name);
	}
	public ArrayList<Course> getPrereqs() {
		return prereqs;
	}
	
	public String getName() {
		return name;
	}
	
}
