package callableStatement;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

public class DataSourceFactory {

	public static DataSource getDataSource() {

		final String driver = "oracle.jdbc.driver.OracleDriver";
		final String url = "jdbc:oracle:thin:@10.151.57.58:1521:orcl";
		final String user = "kiraula1";
		final String password = "kiraula1";

		// Use DBCP for core management
		final BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setUrl(url);
		basicDataSource.setUsername(user);
		basicDataSource.setPassword(password);
		basicDataSource.setDriverClassName(driver);

		return basicDataSource;

	}
}
