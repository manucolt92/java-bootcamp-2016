package dao;

import com.mongodb.MongoClient;
import org.mongodb.morphia.Morphia;
import org.bson.types.ObjectId;

import entity.Course;
import entity.Notes;
import entity.Student;
import org.mongodb.morphia.dao.BasicDAO;
import org.mongodb.morphia.Datastore;
import java.util.*;

public class NotesDAO extends BasicDAO<Notes, ObjectId> {
	
	public NotesDAO(Morphia morphia, MongoClient mongo){
		super(mongo, morphia, "highschool");
	}
	
	public List<Student> practice2(Course course){
		Datastore datastore= super.getDatastore();
		Course matchingCourse= datastore.find(Course.class, "courseName", course.getCourseName()).get();
		List <Notes> matchingNotes= datastore.find(Notes.class, "finalNote >", 4).asList();
		List <Student> result= new ArrayList();
		for(int i= 0; i<matchingNotes.size(); i++){
			Notes note= matchingNotes.get(i);
			Student it= note.getStudent();
			result.add(it);		
			
		}
		result.sort(null);
		return result;
		
	}
}
