
public class TestPool {


	public static void main(String[] args) throws InterruptedException {
		
		Pool pool =  new Pool();
		
		Thread t1 = new Thread(() -> {
			try {
				pool.getItem();
				System.out.println("current item is " + pool.getItem());
			} catch (InterruptedException e) {
				// TODO   Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		Thread t2 =  new Thread(() -> {
			try {
				pool.getItem();
				System.out.println("current item is " + pool.getItem());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		t1.start();
		t2.start();
		
		System.out.println(Thread.currentThread().getName() + " is running");
		/*
		t1.join();
		
		System.out.println(Thread.currentThread().getName() + " is running");

		t2.join();
		*/
		System.out.println(Thread.currentThread().getName() + " is running");
	}

}
