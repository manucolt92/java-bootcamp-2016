package testingRest;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.Api;

@Api
public class User implements Comparable<User>{
	
	@Id
	private final String user_name;
	
	private String first_name, last_name;
	
	public User(String user_name, String first_name, String last_name){
		this.user_name= user_name;
		this.first_name= first_name;
		this.last_name= last_name;		
	}
	
	@JsonProperty(required= true)
	@ApiModelProperty(notes= "Returns user name", required= true)
	public String getuser_name(){
		return user_name;
	}
	
	@JsonProperty(required= true)
	@ApiModelProperty(notes= "Sets user's first name", required= true)
	public void setfirst_name(String first_name){
		this.first_name= first_name;
	}
	
	@JsonProperty(required= true)
	@ApiModelProperty(notes= "Returns first name", required= true)
	public String getfirst_name(){
		return first_name;
	}
	
	@JsonProperty(required= true)
	@ApiModelProperty(notes= "Sets user's last name", required= true)
	public void setlast_name(String last_name){
		this.last_name= last_name;
	}
	
	@JsonProperty(required= true)
	@ApiModelProperty(notes= "Returns last name", required= true)
	public String getlast_name(){
		return last_name;
	}
	
	public String toString(){
		return String.format("User data: user_name= %s, first_name= %s, last_name= %s ", user_name, first_name, last_name);
		
	}
	
	@JsonProperty(required= true)
	@ApiModelProperty(notes= "Two users are equals if all of their fields are equal", required= true)
	public int compareTo(User anUser){
		int aux= 1;
		if(this.user_name.compareTo(anUser.user_name)== 0 && this.first_name.compareTo(anUser.first_name)== 0 && this.last_name.compareTo(anUser.last_name)== 0){
			aux= 0;
		}
		return aux;
	}
	
	
	
	
}