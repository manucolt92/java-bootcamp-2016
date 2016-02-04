package entity;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.*;

@Entity
public class Student implements Comparable<Student>{
   @Id private ObjectId id;
   private String firstname, lastname, dateOfBirth;
   
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
   
public int compareTo(Student stu){
	int result= this.lastname.compareTo(stu.lastname);
	if (result==0){
		result= (this.firstname.compareTo(stu.firstname));
	}
	return result;
}
   
   
}
