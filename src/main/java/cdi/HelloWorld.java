package cdi;

import javax.enterprise.inject.Default;

@Default
public class HelloWorld {
	
	public String display(){
		System.out.println("inside Hello World");
		return "Hello world";
	}

}
