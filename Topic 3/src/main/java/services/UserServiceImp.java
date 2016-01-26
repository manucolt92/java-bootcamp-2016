package services;

import java.util.*;

public class UserServiceImp implements UserService{
	
	private List<User> users;
	
	
	public UserServiceImp(){
		users= new LinkedList<User>();
	}
	
	public String addUser(User u){
		if(u!=null && !users.contains(u)){			
			users.add(0, u);
			return "Usser added.";			
		}
		else return "The user already exist.";
	}
	
	public int getAmountUsers(){
		return users.size();
	}
	
	public User readUser(int id){
		User u= null;		
		for(int i=0; i<users.size(); i++){
				u= users.get(i);
				if(u.getId()==id){
					return u;
				}			
		}
		return null;
	}
	
	public void updateUser(User u){
		if(users.contains(u)){
			User ux= users.get(users.indexOf(u));			
			ux.setId(u.getId());
			ux.setName(u.getName());
			ux.setEmail(u.getEmail());
		}
	}
	
	public void removeUser(User u){
		if(users.contains(u)){
			users.remove(u);
		}
	}
	
	
}
