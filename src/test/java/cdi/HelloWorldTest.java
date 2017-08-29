package cdi;

import static org.junit.Assert.assertTrue;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.apache.webbeans.config.WebBeansContext;
import org.apache.webbeans.spi.ContainerLifecycle;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HelloWorldTest {

	@Inject
	HelloWorld hello;
	
	ContainerLifecycle container;
	
	@Before
	public void init() {
		final WebBeansContext context = WebBeansContext.getInstance();
		container = context.getService(ContainerLifecycle.class);
		container.startApplication(null);
		
		CDIUtils.injection(this);
	}
	
	@After
	public void destroy() {
		container.stopApplication(null);
	}
	
	@Test
	public void check() {
		if ("Hello world".equals(hello.display())) {
			assertTrue("assert is successful", true);
		}

	}
}
