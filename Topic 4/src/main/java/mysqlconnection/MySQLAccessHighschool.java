package mysqlconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class MySQLAccessHighschool {
  private Connection connect = null;
  private Statement statement = null;  
  private ResultSet resultSet = null;
  private boolean first= false;

  @SuppressWarnings("finally")
public boolean readDataBase() throws Exception {
    try {
      // This will load the MySQL driver, each DB has its own driver
      Class.forName("com.mysql.jdbc.Driver");
      // Setup the connection with the DB
      connect = DriverManager.getConnection("jdbc:mysql://localhost/highschool?"
              + "user=root&password=tablada92");

      // Statements allow to issue SQL queries to the database
      statement = connect.createStatement();
      // Result set get the result of the SQL query
      
       resultSet = statement.executeQuery("select teacher_lastname, teacher_firstname,"+
	   "schedulecourse_day, schedulecourse_starts, schedulecourse_ends,"+
       "course_name"+
       "from teacher"+
       "join course on course_assignedteacher=teacher_id"+
       "join schedulecourse on schedulecourse_id=course_id"+
       "where teacher_id=1"+
       "order by schedulecourse_day");
      boolean first= false;
      while(resultSet.next()){
    	  if(!first){
    		  first= true;
    		  System.out.printf("\nTeacher: %s, %s\nSchedule: \n", resultSet.getString(1), resultSet.getShort(2));
    		}
    	  String day= resultSet.getString("day");
    	  String starts= resultSet.getString("starts");
    	  String ends= resultSet.getString("ends");
    	  String course_name= resultSet.getString("course_name");
    	  System.out.printf(" %s %s - %s: %s\n", day, starts, ends, course_name);
      }
      
    } catch (Exception e) {
      throw e;
    } finally {
      close();
      return first;
    }

  }

  // You need to close the resultSet
  private void close() {
    try {
      if (resultSet != null) {
        resultSet.close();
      }

      if (statement != null) {
        statement.close();
      }

      if (connect != null) {
        connect.close();
      }
    } catch (Exception e) {

    }
  }

} 
