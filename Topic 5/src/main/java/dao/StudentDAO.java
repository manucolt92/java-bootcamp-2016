package dao;

import com.mongodb.MongoClient;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.dao.BasicDAO;
import org.mongodb.morphia.Datastore;
import org.bson.types.ObjectId;
import java.util.*;
import entity.Student;

public class StudentDAO extends BasicDAO<Student, ObjectId> {
	public StudentDAO(Morphia morphia, MongoClient mongo){
		super(mongo, morphia, "highschool");
	}
}
