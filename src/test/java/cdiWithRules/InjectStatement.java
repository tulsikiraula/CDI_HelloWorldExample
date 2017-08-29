package cdiWithRules;

import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import cdi.CDIUtils;

public class InjectStatement extends Statement {

	Object object;
	Statement base;
	Description description;
	
	public  InjectStatement(Statement base, Description description, Object object) {
	this.base=base;
	this.description=description;
	this.object=object;
	}
	
	@Override
	public void evaluate() throws Throwable {
		//code that runs before Test method
		CDIUtils.injection(object);
		base.evaluate();
		//code that runs after Test method
		System.out.println("code afer each test method goes here");
	}

}
