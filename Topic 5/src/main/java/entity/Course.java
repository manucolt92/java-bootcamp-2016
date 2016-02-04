package entity;

import java.util.*;
import org.mongodb.morphia.annotations.*;
import org.bson.types.ObjectId;

@Entity
public class Course implements Comparable<Course> {
	@Id ObjectId id;
	private String courseName;
	private int hoursPerWeek;
	private List<String> schedule;
	
	public ObjectId getId(){
		return id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getHoursPerWeek() {
		return hoursPerWeek;
	}

	public void setHoursPerWeek(int hoursPerWeek) {
		this.hoursPerWeek = hoursPerWeek;
	}

	public List<String> getSchedule() {
		return schedule;
	}

	public void setSchedule(List<String> schedule) {
		this.schedule = schedule;
	}
	
	public int compareTo(Course aCourse){
		return courseName.compareTo(aCourse.getCourseName());
	}
	
}
