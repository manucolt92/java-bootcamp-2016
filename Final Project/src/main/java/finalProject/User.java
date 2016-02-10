package finalProject;

import org.springframework.data.annotation.Id;

public class User{
	
	@Id private String userName;
	private String pass, firstName, lastName;
	private boolean online;
	
	protected User(){}
	
	public User(String userName, String pass, String firstName, String lastName){
		
		this.setUserName(userName);
		this.setPass(pass);
		this.setFirstName(firstName);
		this.setLastName(lastName);
		online= false;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public boolean isCorrect(String pass){
		boolean aux= false;
		if(this.getPass().equals(pass)){
			aux= true;
		}
		return aux;
	}
	
	public void setOnline(){
		this.online= true;
	}
	
	public void setOffline(){
		this.online= false;
	}
	
	public boolean getStatus(){
		return online;
	}
	
	public String toString() {
        return String.format(
                "User[username=%s, pass=%s, firstname='%s', lastname='%s']",
                userName, getPass(), firstName, lastName);
    }

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}