package cdi;

import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.spi.AnnotatedType;
import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.inject.spi.CDI;
import javax.enterprise.inject.spi.InjectionTarget;

public class CDIUtils {
	
	public static <T> void injection(final T object) {
		
		final BeanManager beanManager = CDI.current().getBeanManager();
	
		@SuppressWarnings("unchecked")
		final AnnotatedType<T> annotatedType = (AnnotatedType<T>) beanManager
				.createAnnotatedType(object.getClass());
		
		final InjectionTarget<T> injectionTarget = beanManager
				.createInjectionTarget(annotatedType);
		
		final CreationalContext<T> creationalContext = beanManager
				.createCreationalContext(null);
		
		injectionTarget.inject(object, creationalContext);
				
	}
	

}
