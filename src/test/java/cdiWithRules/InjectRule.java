package cdiWithRules;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class InjectRule implements TestRule {
	Object object;

	public InjectRule(Object object) {
		this.object = object;
	}

	public Statement apply(Statement base, Description description) {
		return new InjectStatement(base,description,object);
	}

}
