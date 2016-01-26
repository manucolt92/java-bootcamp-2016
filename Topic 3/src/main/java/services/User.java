package services;

public class User {
	private int id;
	private String name, email;
	
	public User(){
		id=0;
		name= "The name has not been specified";
		email= "The e-mail has not been specified";
	}
	
	public User(int id, String name, String email){
		this.id= id;
		this.name= name;
		this.email= email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String toString(){
		String aux="";
		aux+= "Id: "+id+"Name: "+name+"E-mail: "+email;
		return aux;
	}
	
	
}
