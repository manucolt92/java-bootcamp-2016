package services;

public interface UserService {
	
	public String addUser(User u);
	
	public User readUser(int id);
	
	public void updateUser(User u);
	
	public void removeUser(User u);
	
	public int getAmountUsers();
}
