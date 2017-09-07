package callableStatement;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class ApplicationContext
 *
 */
@WebListener
public class ApplicationContext implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		
		FileInputStream fis;
		Properties props = new Properties();
		try {
			fis = new FileInputStream("procedure.sql");
			props.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
	}
	
}
