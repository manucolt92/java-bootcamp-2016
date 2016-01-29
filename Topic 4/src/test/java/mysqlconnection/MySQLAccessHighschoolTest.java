package mysqlconnection;

import org.junit.*;

public class MySQLAccessHighschoolTest{
	
	@Test
	public void practice5() throws Exception{
		MySQLAccessHighschool test1= new MySQLAccessHighschool();		
		Assert.assertTrue(test1.readDataBase());
	}
	
	
}
