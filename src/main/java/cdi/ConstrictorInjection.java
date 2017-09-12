package cdi;

import javax.inject.Inject;

public class ConstrictorInjection {
	
    @Inject
    private static TestHelloWorld test;

	public static void main(String[] args) {
		
      Container.start();
      
    //  ConstrictorInjection obj = new ConstrictorInjection();
		
      CDIUtils.getReference(ConstrictorInjection.class);
	
      ConstrictorInjection.display();

	}

	private static void display() {
		System.out.println("Hello constructor");
		test.show();
	} 

}
