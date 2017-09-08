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
		// flyway.clean();

		// for custom settings
		// flyway.setLocations("src/main/resources/db/migration"); // to keep scripts in
		// custom location
		flyway.setSqlMigrationPrefix("V");
		flyway.setSqlMigrationSuffix(".sql");
		flyway.setTable("Schema"); // to reset name of shema_version table

		// flyway.setValidateOnMigrate(true); // to create schema_version
		flyway.baseline(); // to create schema_version for the first time
		flyway.setBaselineOnMigrate(true);

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

	}
}
