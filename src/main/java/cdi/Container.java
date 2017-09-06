package cdi;

import org.apache.webbeans.config.WebBeansContext;
import org.apache.webbeans.spi.ContainerLifecycle;

public class Container {
	
	static ContainerLifecycle lifecycle;
	
	public static void start() {
	final WebBeansContext context = WebBeansContext.getInstance();
	lifecycle = context.getService(ContainerLifecycle.class);
	lifecycle.startApplication(null);
	}
	
	public static void stop() {
		lifecycle.stopApplication(null);
	}

}
