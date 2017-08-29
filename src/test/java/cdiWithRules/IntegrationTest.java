package cdiWithRules;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import cdi.HelloWorldTest;

@RunWith(Suite.class)
@SuiteClasses({
	InjectRuleTest.class,
	HelloWorldTest.class
})

public class IntegrationTest {
	
	//we can code here to start the server using @ClassRule
	

}
