package testingRest;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
@RequestMapping("/users")
public class UserRestController {
	
	private final UserRepository userRepo;
	
	@ApiOperation(value= "addUser", nickname= "addUser")
	@RequestMapping(method= RequestMethod.POST)
	@ApiImplicitParams({
		@ApiImplicitParam(name= "user", value= "User object to add", required= true, dataType= "User.class", paramType= "Request body")
	})
	@ApiResponses(value= {
			@ApiResponse(code= 200, message= "Success"),
			@ApiResponse(code= 401, message= "Unauthorized"),
			@ApiResponse(code= 403, message= "Forbidden"),
			@ApiResponse(code= 404, message= "Not found"),
			@ApiResponse(code= 500, message= "Failure")
	})
	ResponseEntity<?> addUser(@RequestBody User user){
		if(!this.userRepo.exists(user.getuser_name())){
			User aux= userRepo.save(new User(user.getuser_name(), user.getfirst_name(), user.getlast_name()));
			
			HttpHeaders httpHeaders= new HttpHeaders();
			httpHeaders.setLocation(ServletUriComponentsBuilder.fromCurrentRequest().path("/{user_name}").buildAndExpand(aux.getuser_name()).toUri());
			
			return new ResponseEntity<>(null, httpHeaders, HttpStatus.CREATED);
		}
		else {
			System.out.printf("\n\nUsername %s already exists, choose a new one\n\n", user.getuser_name());
			return new ResponseEntity<>(null, new HttpHeaders(), HttpStatus.IM_USED);
		}
	}
	
	@ApiOperation(value= "readAllUsers", nickname= "readAll")
	@RequestMapping(method= RequestMethod.GET)
	@ApiResponses(value= {
			@ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")
	})
	
	List<User> readAllUser(){
		return userRepo.findAll();
	}
	
	@ApiOperation(value= "updateUser", nickname= "updateUser")
	@RequestMapping(method= RequestMethod.PUT)
	@ApiImplicitParams({
		@ApiImplicitParam(name= "user", value= "User object to update", required= true, dataType= "User.class", paramType= "Request Body")
		})
	@ApiResponses(value= {
			@ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")
	})
	User updateUser(@RequestBody User updateUser){
		User aux= userRepo.findOne(updateUser.getuser_name());
		if(aux==null){
			throw new RuntimeException("UPDATE FAILED: user not found");
		}
		aux.setfirst_name(updateUser.getfirst_name());
		aux.setlast_name(updateUser.getlast_name());
		
		return userRepo.save(aux);
	}
	
	@ApiOperation(value= "deleteUser", nickname="deleteUser")
	@RequestMapping(value= "/{user_name}", method= RequestMethod.DELETE)
	@ApiImplicitParams({
		@ApiImplicitParam(name= "user_name", value= "user_name of the User object to delete", required= true, dataType= "String", paramType= "Path variable")
		})
	@ApiResponses(value= {
			@ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")
	})
	
	void deleteUser(@PathVariable String user_name){
		User aux= userRepo.findOne(user_name);
		if(aux!=null){
			userRepo.delete(aux);
		}
		else {
			System.out.printf("\n\nUser to delete \"%s\" not found\n\n", user_name);
		}
	}
	
	@ApiOperation(value= "readUserByUser_Name", nickname= "readByUser_Name")
	@RequestMapping(value= "/{user_name", method= RequestMethod.GET)
	@ApiImplicitParams({
		@ApiImplicitParam(name= "user_name", value= "user_name to query", required= true, dataType= "String", paramType= "PathVariable")
	})
	@ApiResponses(value= {
			@ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")
	})
	User readByUser_Name(@PathVariable String user_name){
		return userRepo.findOne(user_name);
	}
	
	@Autowired
	UserRestController (UserRepository userRepo){
		this.userRepo= userRepo;
	}
}
