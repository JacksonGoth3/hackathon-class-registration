import java.util.*;

public class Course {
	
	private int id;
	private String name;
	private ArrayList<Course> prereqs;
	private ArrayList<Session> sessions;
	
	public Course(String name) {
		this.name = name;
	}
	public Course(String name, ArrayList<Course> prereqs) {
		this.name = name;
		this.prereqs = prereqs;
		this.sessions = new ArrayList<>();
	}
	public Course(String name, ArrayList<Course> prereqs, ArrayList<Session> sessions) {
		this.name = name;
		this.prereqs = prereqs;
		this.sessions = sessions;
	}
	
	
	public void addSession(String prof, String days, String time) {
		sessions.add(new Session(prof, days, time));
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
