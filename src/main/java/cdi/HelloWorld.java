package cdi;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class HelloWorld {
	
	public void display(){
		System.out.println("Inside Hello world");
	}

}
