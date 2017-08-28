package cdi;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class HelloWorld {
	
	public String display(){
		System.out.println("inside Hello World");
		return "Hello world";
	}

}
