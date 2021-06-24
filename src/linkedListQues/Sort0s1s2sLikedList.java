package linkedListQues;

import linkedListQues.SinglyLinkedList.Node;

public class Sort0s1s2sLikedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	static void sort(SinglyLinkedList list) {
		
		SinglyLinkedList.Node head = list.head;
		SinglyLinkedList.Node zero = new Node(0);
		SinglyLinkedList.Node zerod = zero;
		SinglyLinkedList.Node one = new Node(0);
		SinglyLinkedList.Node oned = one;
		SinglyLinkedList.Node two = new Node(0);
		SinglyLinkedList.Node twod = two;
		while(head != null) {
			if(head.data==0) {
				zero.next = head;
				zero = zero.next;
			} else if (head.data ==1) {
				one.next = head;
				one = one.next;
			} else {
				two.next = head;
				two = two.next;
			} 
			head = head.next;
				
		}
		
		
		one.next = (twod.next !=null) ? twod.next : null;
		two.next = null;
		zero.next= (oned.next!=null) ? oned.next : null;
		one.next = null;
		
		head = zerod.next;
	}

}
