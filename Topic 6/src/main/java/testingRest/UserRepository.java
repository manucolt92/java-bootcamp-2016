package testingRest;

import java.util.*;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface UserRepository extends MongoRepository<User, String>{
	public List<User> findByFirst_Name(String first_name);
	public List<User> findByLast_Name(String last_name);
}

