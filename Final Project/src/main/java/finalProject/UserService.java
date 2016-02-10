package finalProject;

import java.util.*;

public interface UserService {
	
	String addUser(String userName, String pass, String firstName, String lastName);
	
	String updateUser(String userName, String firstName, String lastName);
	
	String deleteUser(String userName);
	
	boolean validUserName(String userName);
	
	boolean isLogged(String userName);
	
	String setOnline(String userName, String pass);
	
	String setOffline(String userName);
	
	List<User> showUsers();
	
	List<User> findUserByFirstName(String firstName);
	
	List<User> findUserByLastName(String lastName);
	
	
	
}
