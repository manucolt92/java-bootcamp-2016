package finalProject;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component("userService")
@Transactional
public class UserServiceImp implements UserService{
	
	private final UserRepository userRepo;
	
	@Autowired
	public UserServiceImp(UserRepository userRepo){
		this.userRepo= userRepo;
	}
	
	public String addUser(String userName, String pass, String firstName, String lastName){
		String aux="The new user has been added";
		if(this.userRepo.exists(userName)){
			aux= "The user name already exist, please choose another one";
		}
		else{
			User u= new User(userName, pass, firstName, lastName);
			this.userRepo.save(u);
		}
		return aux;
	}
	
	public String updateUser(String userName, String firstName, String lastName){
		User u= this.userRepo.findOne(userName);
		String aux= "The user has been updated";
		u.setUserName(userName);
		u.setFirstName(firstName);
		u.setLastName(lastName);
		this.userRepo.save(u);
		return aux;
	}
	
	public String deleteUser(String userName){
		this.userRepo.delete(userName);
		return "The user has been deleted";
	}
	
	public String setOnline(String userName, String pass){
		String aux= "Passworld incorrect";
		User u= this.userRepo.findOne(userName);
		if(u.isCorrect(pass)){
			aux= "Status: Online";
			u.setOnline();
			this.userRepo.save(u);
		}
		return aux;
	}
	
	public boolean validUserName(String userName) {
        boolean aux = false;
        if (this.userRepo.exists(userName)) {
            aux = true;
        }
        return aux;
    }
	
	public boolean isLogged(String userName) {
        return this.userRepo.findOne(userName).getStatus();
    }
	
	public String setOffline(String userName){
		String aux= "Status: Offline";
		User u= this.userRepo.findOne(userName);
		u.setOffline();
		this.userRepo.save(u);
		return aux;
	}
	
	public List<User> showUsers(){
		return this.userRepo.findAll();
	}
	
	public List<User> findUserByFirstName(String firstName){
		return this.userRepo.findByFirstName(firstName);
	}
	
	public List<User> findUserByLastName(String lastName){
		return this.findUserByLastName(lastName);
	}
}
