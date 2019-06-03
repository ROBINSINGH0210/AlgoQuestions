package linkedListQues;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SinglyLinkedList {
	public Node head;
	private int size = 0;

	public static class Node {
		public int data;
		public Node next;

		Node(int data) {
			this.data = data;
			next = null;
		}
		

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Node [data=").append(data).append(", next=").append(next).append("]");
			return builder.toString();
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

	public Iterator<Integer> iterator() {
		return new Itr();
	}

	private class Itr implements Iterator<Integer> {
		int counter = 0;
		Node data = SinglyLinkedList.this.head;

		@Override
		public boolean hasNext() {
			return counter <= SinglyLinkedList.this.size;
		}

		@Override
		public Integer next() {
			if (counter <= SinglyLinkedList.this.size) {
				throw new NoSuchElementException();
			} else {
				Integer temp = data.data;
				data = data.next;
				counter++;
				return temp;

			}
		}

	}

	public void reverse() {
		Node next = null;
		Node current = this.head;
		Node previous = null;
		while (current != null) {
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;

		}
		this.head = previous;
	}
	
	public Node mergeSort(Node h) {
		if(h == null || h.next ==null)
			return h;
		Node m = middle(h);
		
		Node middleNext = m.next;
		m.next = null;
		
		Node left = mergeSort(h);
		Node right = mergeSort(middleNext);
		
		return mergeSortedLikedList(left,right);
	}

	private Node mergeSortedLikedList(Node left, Node right) {
		Node result;
		if(left == null)
			return right;
		if(right== null)
			return left;
		if(left.data<=right.data) {
			result = left;
			result.next = mergeSortedLikedList(left.next, right);
		}else {
			result = right;
			result.next = mergeSortedLikedList(left, right.next);
		}
		return result;
	}

	private Node middle(Node h) {
		if (h == null) 
			return h; 
		Node slowPtr = h;
		Node fastPtr = h.next;
		while(fastPtr !=null) {
			fastPtr =  fastPtr.next;
			if(fastPtr!=null) {
				slowPtr = slowPtr.next;
				fastPtr = fastPtr.next;
			}
		}
		return slowPtr;
	}
	void printList(Node headref)  
    { 
        while (headref != null)  
        { 
            System.out.print(headref.data + " "); 
            headref = headref.next; 
        } 
    } 

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SinglyLinkedList [head=").append(head).append(", size=").append(size).append("]");
		return builder.toString();
	}
	
	
	
}
