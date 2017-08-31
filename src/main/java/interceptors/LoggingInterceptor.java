package interceptors;

import javax.interceptor.AroundConstruct;
import javax.interceptor.AroundInvoke;
import javax.interceptor.AroundTimeout;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Log
@Interceptor
public class LoggingInterceptor {
	
	@AroundInvoke
	public Object log(InvocationContext context ) throws Exception {
		System.out.println("in Logging interceptor");
		return context.proceed();
	}
	
	@AroundTimeout
	public Object aroundTime(InvocationContext context) throws Exception{
		System.out.println("in Logging interceptor's around time method");
		return context.proceed();
	}
	
	@AroundConstruct
	public Object aroundConstruct(InvocationContext context) throws Exception{
		System.out.println("in Logging interceptor's around time method");
		return context.proceed();
	}

}
