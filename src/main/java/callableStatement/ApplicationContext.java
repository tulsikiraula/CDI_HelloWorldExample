package callableStatement;

import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import oracle.jdbc.pool.OracleDataSource;

/**
 * Application Lifecycle Listener implementation class ApplicationContext
 *
 */
public class ApplicationContext implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		
		ServletContext context = sce.getServletContext();
		final String driver = "oracle.jdbc.driver.OracleDriver";
		final String url = "jdbc:oracle:thin:@10.151.57.58:1521:orcl";
		final String user = "kiraula1";
		final String password = "kiraula1";
		
		try {
			final OracleDataSource oracleDS = new OracleDataSource();
			oracleDS.setURL(url);
			oracleDS.setUser(user);
			oracleDS.setPassword(password);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
	}
	
}
