import java.io.*;
import java.util.*;

public class Student {
	
	private String name;
	private int id;
	private HashSet<Course> taken;
	private HashSet<Course> taking;
	
	public Student(String name, int id) {
		this.name = name;
		this.id = id;
		taken = new HashSet<>();
		taking = new HashSet<>();
	}
	
	
	// Checks if this student has the proper prerequisites to take this course
	public boolean checkPrereq(Course c) {
		ArrayList<Course> prereqs = c.getPrereqs();
		// Check if all prereqs appear in taken courses
		for(int i = 0; i < prereqs.size(); i++) {
			if (!taken.contains(prereqs.get(i))) {
				return false;
			}
		}
		return true;
	}
	// Student takes this course, returns false if the student does not have the proper prerequisites
	public boolean takeCourse(Course c) {
		if (checkPrereq(c)) {
			taking.add(c);
			return true;
		}
		return false;
	}
	// Add course to already taken
	public void addTaken(Course c) {
		taken.add(c);
	}
	
	public void removeCourse(Course c) {
		taking.remove(c);
	}
	
	public String getName() {
		return name;
	}
	public int getId() {
		return id;
	}
	public HashSet<Course> getTaking() {
		return taking;
	}
	public HashSet<Course> getTaken() {
		return taken;
	}
	
	
}
