package decoratorNew;

import static org.junit.Assert.assertEquals;

import javax.inject.Inject;

import org.apache.webbeans.config.WebBeansContext;
import org.apache.webbeans.spi.ContainerLifecycle;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

import cdiWithRules.InjectRule;

public class DecoratorTest {
	
	
static ContainerLifecycle container;

    @Inject 
    Greeting greeting;
	
	@Rule
	public final TestRule injectRules = new InjectRule(this);

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
	public void checkDecorator() {
		assertEquals(greeting.greet("tulsi"),"Hello tulsi very much");
		
	}

}
