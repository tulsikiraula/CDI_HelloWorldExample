package callableStatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

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
		// flyway.clean();

		// for custom settings
		// flyway.setLocations("src/main/resources/db/migration"); // to keep scripts in
		// custom location
		flyway.setSqlMigrationPrefix("V");
		flyway.setSqlMigrationSuffix(".sql");
		flyway.setTable("Schema"); // to reset name of shema_version table

		// flyway.setValidateOnMigrate(true); // to create schema_version
		//flyway.baseline(); // to create schema_version for the first time
		//flyway.setBaselineOnMigrate(true);
		flyway.migrate();

		ProcedureExecutor pe = new ProcedureExecutor("UPDATEEMPLOYEENAME");
		// procedure should be created in db before calling
		pe.addArgument(java.sql.Types.INTEGER, 7);
		pe.addArgument(java.sql.Types.VARCHAR, "Manisha");
		pe.addArgument(java.sql.Types.INTEGER, 1100);
		pe.runProcedure(getConnection());

		ProcedureExecutor pe1 = new ProcedureExecutor("getEmployeeDetails2");
		pe1.addArgument(java.sql.Types.INTEGER, 2);
		pe1.addArgument(java.sql.Types.VARCHAR, "result", true);
		pe1.runProcedure(getConnection());

		
		Connection con = getConnection();
		CallableStatement cstmt = con.prepareCall("{? = call updateSalary(?)}");
		cstmt.registerOutParameter(1, Types.INTEGER);
		cstmt.setInt(2, 1);
		cstmt.executeUpdate();
		int sal= cstmt.getInt(1);
		System.out.print("salary is "+sal);

		
	}
}
