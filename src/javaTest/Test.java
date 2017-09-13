package javaTest;

public class Test {
	public static void main(String... strings) {
		Thread t = new Thread(new TestThread());
		Thread t1 = new Thread(new TestThread());
		t.start();
		t1.start();
		
	}
}
