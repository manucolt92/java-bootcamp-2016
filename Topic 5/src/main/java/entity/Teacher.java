package entity;

import java.util.*;
import org.mongodb.morphia.annotations.*;
import org.bson.types.ObjectId;


public class Teacher {
	@Id private ObjectId id;
	private String firstname, lastname, dateOfBirth;
	@Reference 
	private List<Course> assignedCourses;
	
	public ObjectId getId(){
		return id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public List<Course> getAssignedCourses() {
		return assignedCourses;
	}

	public void setAssignedCourses(List<Course> assignedCourses) {
		this.assignedCourses = assignedCourses;
	}
	
	

}
