package finalProject;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	 
	    @RequestMapping(value= "addUser", method = RequestMethod.POST)	    
	    String addUser(@RequestParam(value= "userName")String userName,
	    		@RequestParam(value= "password")String password,
	    		@RequestParam(value= "firstName")String firstName,
	    		@RequestParam(value= "lastName")String lastName){
		 return userService.addUser(userName, password, firstName, lastName);
	    }	   
	    	    
	    @RequestMapping(value="/showUsers", method = RequestMethod.GET)	    
	    List<User> readAllUsers() {
	        return userService.showUsers();
	    }	    
	    
	    @RequestMapping(value = "/{userName}/update", method = RequestMethod.PUT)	    
	    String updateUser(@PathVariable String userName,
	    		@RequestParam(value= "firstName")String firstName,
	    		@RequestParam(value= "lastName")String lastName){
	    	return userService.updateUser(userName, firstName, lastName);  
	    }	    
	    
	    @RequestMapping(value = "/findUserByFirstName", method = RequestMethod.GET)	    
	    List<User> findUserByFirstName(@RequestParam(value= "firstName")String firstName){
	    	return userService.findUserByFirstName(firstName);	    	
	    }	    
	    
	    @RequestMapping(value = "/findUserByLastName", method = RequestMethod.GET)	    
	    List<User> findUserByLastName(@RequestParam(value= "lastName")String lastName){
	    	return userService.findUserByLastName(lastName);	    	
	    }
	    
	    @RequestMapping(value = "/{userName}/delete", method = RequestMethod.DELETE)	    
	    String deleteUser(@PathVariable String userName){
	    	String aux= "Invalid user name or Status: Offline";
	    	if(userService.validUserName(userName) && userService.isLogged(userName)){
	    		aux= userService.deleteUser(userName);
	    	}
	    	return aux;
	    }	    
	    
	    @RequestMapping(value = "/login", method = RequestMethod.PUT)	    
	    String logIn(@RequestParam(value= "userName")String userName,
	    		@RequestParam(value= "password")String password){
	    	String aux= "Invalid user name";
	    	if(userService.validUserName(userName)){
	    		aux= userService.setOnline(password, password);
	    	}
	    	return aux;
	    }	    
	    
	    @RequestMapping(value = "/logout", method = RequestMethod.PUT)	    
	    String logOut(@PathVariable String userName){
	    	String aux= "Invalid user name or Status: Offline";
	    	if(userService.validUserName(userName) && userService.isLogged(userName)){
	    		aux= userService.setOffline(userName);
	    	}
	    	return aux;
	    }
	    
	    
	        
	    
}
