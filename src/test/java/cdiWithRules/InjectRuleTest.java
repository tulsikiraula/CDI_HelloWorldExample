package cdiWithRules;

import javax.inject.Inject;

import org.apache.webbeans.config.WebBeansContext;
import org.apache.webbeans.spi.ContainerLifecycle;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

import cdi.HelloWorld;

import static org.junit.Assert.assertEquals;

//@RunWith(CdiTestRunner.class) : No need to create a container. Its provides its own container
public class InjectRuleTest {
	
	static ContainerLifecycle container;
	
	//Act as before and after that runs for every test
	@Rule
	public final TestRule injectRules = new InjectRule(this);
	
	@Inject
	private HelloWorld hello;
	
	@BeforeClass
	public static void init() {
		final WebBeansContext context = WebBeansContext.getInstance();
		container = context.getService(ContainerLifecycle.class);
		container.startApplication(null);
	}
	
	@AfterClass
	public static void destroy() {
		container.stopApplication(null);
	}
	
	@Test
	public void check() {
		assertEquals("Hello world", hello.display());
	}

}
