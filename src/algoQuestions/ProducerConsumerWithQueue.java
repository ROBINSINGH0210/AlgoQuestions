package algoQuestions;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerWithQueue {

	public static void main(String[] args) {

	}

}

class MyBlockingQueue<E> {
	Queue<E> queue;
	Lock lock = new ReentrantLock();
	int size;
	Condition addLock = lock.newCondition();
	Condition takeLock = lock.newCondition();

	public MyBlockingQueue(int size) {
		queue = new LinkedList<>();
		this.size = size;
	}

	public void put(E e) {
		lock.lock();
		try {
			if (queue.size() == size)
				addLock.await();
			queue.add(e);
			takeLock.signalAll();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public E take() {
		lock.lock();
		try {
			while(queue.isEmpty())
				takeLock.await();
			E item = queue.remove();
			addLock.signalAll();
			return item;
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
		return null;

	}

}