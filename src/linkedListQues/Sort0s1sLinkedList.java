package linkedListQues;

import linkedListQues.SinglyLinkedList.Node;

public class Sort0s1sLinkedList {

	public static void main(String[] args) {
		SinglyLinkedList list = new SinglyLinkedList();
		list.insert(0);
		list.insert(1);
		list.insert(0);
		list.insert(0);
		list.insert(0);

		list.printList(list.head);
		System.out.println(" After Sort ");
		sort(list);
		list.printList(list.head);
	}

	public static void sort(SinglyLinkedList list) {
		SinglyLinkedList.Node head = list.head;
		SinglyLinkedList.Node zero = new Node(0);
		SinglyLinkedList.Node one = new Node(0);
		SinglyLinkedList.Node zerod = zero;
		SinglyLinkedList.Node oned = one;

		while (head != null) {
			if (head.data != 1) {
				zero.next = head;
				zero = zero.next;
			} else {
				one.next = head;
				one = one.next;
			}
			head = head.next;
		}

		zero.next = (oned.next!=null) ? (oned.next) : null;  
        one.next = null;  
        head = zerod.next; 
	}
}
