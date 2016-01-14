import java.sql.*;

public class PatronAFactoryDBDif {
	public static PatronAFactoryDBDif CreateConnection(String type)
	{
		PatronAFactoryDBDif factory = null;
	         switch (type)
	         {
	                   case "System.Data.SqlClient":
	                            factory = new MsSqlFactory();
	                            break;
	                   case "System.Data.OracleClient":
	                            factory = new OracleFactory();
	                            break;
	                   default:
	                            factory = new OleDbFactory();
	                            break;
	         }
	         return factory;
	}
}
