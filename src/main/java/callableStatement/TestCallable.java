package callableStatement;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;

public class TestCallable {

   static DataSource dataSource; 
  
   public static Connection getConnection() throws SQLException {
	   dataSource = DataSourceFactory.getDataSource();
	  return dataSource.getConnection();
   }

	public static void main(String[] args) throws SQLException {
   
			ProcedureExecutor pe =  new ProcedureExecutor("UPDATEEMPLOYEENAME"); //procedure should be created in db before calling
			pe.addArgument(java.sql.Types.INTEGER,7);
			pe.addArgument(java.sql.Types.VARCHAR, "Manisha");
			pe.addArgument(java.sql.Types.INTEGER,1100);
			pe.runProcedure(getConnection());
			
			ProcedureExecutor pe1 =  new ProcedureExecutor("getEmployeeDetails");
			pe1.addArgument(java.sql.Types.INTEGER,5);
			pe1.addArgument(java.sql.Types.VARCHAR, "result", true);
			pe1.runProcedure(getConnection());
			
		}
}
