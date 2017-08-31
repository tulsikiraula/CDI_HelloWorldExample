package interceptors;

public class LogginClient {
	
	@Log
	public void client() {
		System.out.println("execute this client");
		
	}

}
