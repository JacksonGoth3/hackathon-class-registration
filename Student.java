import java.io.*;
import java.util.*;

public class Student {
	
	private String name;
	private int id;
	private HashSet<Integer> taken;
	private HashSet<Integer> taking;
	
	public Student(String name, int id) {
		this.name = name;
		this.id = id;
		taken = new HashSet<>();
		taking = new HashSet<>();
	}
	
	
	// Checks if this student has the proper prerequisites to take this course
	public boolean checkPrereq(int c) {
		/*
		ArrayList<Course> prereqs = GUI.courseMap.get(c).getPrereqs();
		if (prereqs == null) {
			return true;
		}
		// Check if all prereqs appear in taken courses
		for(int i = 0; i < prereqs.size(); i++) {
			if (!taken.contains(prereqs.get(i).getId())) {
				return false;
			}
		}
		*/
		return true;
	}
	// Student takes this course, returns false if the student does not have the proper prerequisites
	public boolean takeCourse(int c) {
		if (checkPrereq(c)) {
			taking.add(c);
			return true;
		}
		return false;
	}
	// Add course to already taken
	public void addTaken(int c) {
		taken.add(c);
	}
	
	public void removeCourse(int c) {
		taking.remove(c);
	}
	
	public String getName() {
		return name;
	}
	public int getId() {
		return id;
	}
	public HashSet<Integer> getTaking() {
		return taking;
	}
	public HashSet<Integer> getTaken() {
		return taken;
	}
	
	
}
