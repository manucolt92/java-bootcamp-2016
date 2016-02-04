package dao;

import com.mongodb.MongoClient;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.dao.BasicDAO;
import org.mongodb.morphia.Datastore;
import org.bson.types.ObjectId;
import java.util.*;
import entity.Teacher;
import entity.Course;


public class TeacherDAO extends BasicDAO<Teacher, ObjectId> {
	public TeacherDAO(Morphia morphia, MongoClient mongo){
		super(mongo, morphia, "highschool");
	}
	
	public List<Course> practice3(Teacher teacher){
		Datastore datastore= super.getDatastore();
		Teacher matchingTeacher= datastore.find(Teacher.class, "lastname", teacher.getLastname()).get();
		List<Course> result= matchingTeacher.getAssignedCourses();
		result.sort(null);
		return result;
	}
	
	
}
