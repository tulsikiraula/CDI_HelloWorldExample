package decoratorNew;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;

@Decorator
public class GreetingDecorator implements Greeting {

	@Inject
	@Delegate
	Greeting greeting;
	
	public String greet(String name) {
		return  greeting.greet(name) + " very much";
	}

}
