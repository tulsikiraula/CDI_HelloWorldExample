package cdi;

import java.util.Set;

import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.spi.AnnotatedType;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.inject.spi.CDI;
import javax.enterprise.inject.spi.InjectionTarget;
import javax.inject.Inject;

import org.apache.webbeans.config.WebBeansContext;
import org.apache.webbeans.spi.ContainerLifecycle;






public class TestHelloWorld {

	@Inject
	private HelloWorld helloWorld;
	
	@SuppressWarnings("unchecked")
	
	
	//In our project, it has been set at application startup
	public void injection() {
		final BeanManager beanManager = CDI.current().getBeanManager();
		final AnnotatedType<TestHelloWorld> annotatedType = beanManager
				.createAnnotatedType(TestHelloWorld.class);
		
		final InjectionTarget<TestHelloWorld> injectionTarget = beanManager
				.createInjectionTarget(annotatedType);
		
		final Set<Bean<?>> beans = beanManager.getBeans(HelloWorld.class);
		final Bean<?> bean = beans.iterator().next();
		
		injectionTarget.inject(this,
				(CreationalContext<TestHelloWorld>) beanManager
						.createCreationalContext(bean));
	}
	
	
	public static void main(String[] args) {
		
		ContainerLifecycle lifecycle;
		
		final WebBeansContext context = WebBeansContext.getInstance();
		lifecycle = context.getService(ContainerLifecycle.class);
		lifecycle.startApplication(null);
		
		TestHelloWorld testHelloWorld =new TestHelloWorld();
		testHelloWorld.injection();
		
		testHelloWorld.show();
		
		lifecycle.stopApplication(null);
	}
	public void show() {
		System.out.println("inside TestHelloWorld") ;
		if(helloWorld!=null)
		helloWorld.display();
		else
		System.out.println(this + "is null");

	}

}
