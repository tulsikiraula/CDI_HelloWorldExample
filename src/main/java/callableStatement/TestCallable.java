package callableStatement;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.flywaydb.core.Flyway;

public class TestCallable {

   static DataSource dataSource; 
  
   public static Connection getConnection() throws SQLException {
	   dataSource = DataSourceFactory.getDataSource();
	  return dataSource.getConnection();
   }

	public static void main(String[] args) throws SQLException {

		dataSource = DataSourceFactory.getDataSource();
		
		Flyway flyway = new Flyway();
		flyway.setDataSource(dataSource);
		//flyway.clean();
		flyway.setLocations("filesystem:src/main/resources/db/migration");
		flyway.setSqlMigrationPrefix("P");
		flyway.setSqlMigrationSuffix(".sql");
		flyway.setValidateOnMigrate(true);
		flyway.setBaselineOnMigrate(true);
		
		flyway.migrate();
		flyway.getLocations();
		flyway.getTable();

		/*InputStream fis;
		Properties props = new Properties();
		try {
			fis = TestCallable.class.getClassLoader().getResourceAsStream("plsql/procedure.sql");
			// fis = new FileInputStream("procedure.sql");
			props.load(fis);
			dataSource.getConnection();
		} catch (IOException e) {
			e.printStackTrace();
		}*/

		/*
		 * ProcedureExecutor pe = new ProcedureExecutor("UPDATEEMPLOYEENAME");
		 * //procedure should be created in db before calling
		 * pe.addArgument(java.sql.Types.INTEGER,7);
		 * pe.addArgument(java.sql.Types.VARCHAR, "Manisha");
		 * pe.addArgument(java.sql.Types.INTEGER,1100);
		 * pe.runProcedure(getConnection());
		 */

		/*ProcedureExecutor pe1 = new ProcedureExecutor("getEmployeeDetails2");
		pe1.addArgument(java.sql.Types.INTEGER, 2);
		pe1.addArgument(java.sql.Types.VARCHAR, "result", true);
		pe1.runProcedure(getConnection());*/

	}
}
