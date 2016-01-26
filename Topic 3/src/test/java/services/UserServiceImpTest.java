package services;

import org.junit.*;

public class UserServiceImpTest {

	@Test
	public void removesASpecifiedUser(){
		UserService userServiceImpTest1= new UserServiceImp();
		User userTest1= new User(57733, null, null);
		User userTest2= new User(8854, null, null);
		userServiceImpTest1.addUser(userTest1);
		userServiceImpTest1.addUser(userTest2);
		userServiceImpTest1.removeUser(userTest1);	
		
		Assert.assertNull(userServiceImpTest1.readUser(57733));
		
	}
	
	@Test
	public void addUserMethodAddsASpecifiedUser(){
		UserService userServiceImpTest2= new UserServiceImp();
		User userTest3= new User(28145, null, null);
		userServiceImpTest2.addUser(userTest3);
		
		Assert.assertSame(userServiceImpTest2.readUser(28145), userTest3);
	}
	
	@Test
	public void updateMethodUpdatesASpecifiedUser(){
		 UserService userServiceImpTest3= new UserServiceImp();
		 User userTest4= new User(55487, null, null);
		 userServiceImpTest3.addUser(userTest4);
		 userTest4.setName("Manuel");
		 userTest4.setEmail("mjimenez789@gmail.com");
		 
		 User userTest5= userServiceImpTest3.readUser(55487);
		 
		 userServiceImpTest3.updateUser(userTest4);
		 
		 Assert.assertEquals(userTest5, userTest4);
	}

}
