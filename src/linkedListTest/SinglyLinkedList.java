package linkedListTest;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SinglyLinkedList {
	private Node head;
	private int size = 0;

	class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			next = null;
		}
	}

	public void insert(int data) {
		Node node = new Node(data);
		if (head == null) {
			head = node;
		} else {
			Node last = head;
			while (last.next != null) {
				last = last.next;
			}
			last.next = node;
		}
		size++;
	}

	public int size() {
		return this.size;
	}

	public Iterator<Object> iterator() {
		return new Itr();
	}

	private class Itr implements Iterator<Object> {
		int counter = 0;
		Node data = SinglyLinkedList.this.head;

		@Override
		public boolean hasNext() {
			return counter <= SinglyLinkedList.this.size;
		}

		@Override
		public Object next() {
			if (counter <= SinglyLinkedList.this.size) {
				throw new NoSuchElementException();
			} else {
				Object temp = data.data;
				data = data.next;
				counter++;
				return temp;

			}
		}

	}
}
