package cdi;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;

@ApplicationScoped
@Default
public class HelloWorld {
	
	public String display(){
		System.out.println("inside Hello World");
		return "Hello world";
	}

}
