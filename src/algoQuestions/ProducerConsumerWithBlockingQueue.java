package algoQuestions;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import practice.Employee;

public class ProducerConsumerWithBlockingQueue {

	public static void main(String[] args) {
		BlockingQueue<Employee> queue = new ArrayBlockingQueue<>(15);

		Runnable producer = () -> {
			while (true) {
				System.out.println( "producing " + Thread.currentThread().getName());
				queue.add(new Employee());
			}
		};
		new Thread(producer).start();
		
		Runnable consumer = () -> {
			while (true) {
				try {
					System.out.println( "Consumer " + Thread.currentThread().getName());
					Employee e = queue.take();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		
		new Thread(consumer).start();
		new Thread(consumer).start();
	}

}
