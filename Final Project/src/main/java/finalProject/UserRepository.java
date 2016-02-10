package finalProject;

import java.util.*;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface UserRepository extends MongoRepository<User, String>{
	
	public List<User> findByFirstName(String firstName);
	
	public List<User> findByLastName(String lastName);
}
