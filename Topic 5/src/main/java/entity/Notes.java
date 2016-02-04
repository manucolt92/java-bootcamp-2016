package entity;

import org.mongodb.morphia.annotations.*;
import org.bson.types.ObjectId;

@Entity
public class Notes {
	@Id private ObjectId id;
	@Reference
	private Course course;
	@Reference
	private Student student;
	private int firstNote, secondNote, thirdNote;
	private double finalNote;
	
	public ObjectId getId(){
		return id;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public int getFirstNote() {
		return firstNote;
	}

	public void setFirstNote(int firstNote) {
		this.firstNote = firstNote;
	}

	public int getSecondNote() {
		return secondNote;
	}

	public void setSecondNote(int secondNote) {
		this.secondNote = secondNote;
	}

	public int getThirdNote() {
		return thirdNote;
	}

	public void setThirdNote(int thirdNote) {
		this.thirdNote = thirdNote;
	}

	public double getFinalNote() {
		return finalNote;
	}

	public void setFinalNote(double finalNote) {
		this.finalNote = finalNote;
	}
	
	
}
