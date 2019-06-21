package linkedListQues;

import linkedListQues.SinglyLinkedList.Node;

public class FlatteringLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SinglyLinkedList list = new SinglyLinkedList();
		list.head = new Node(5);
		list.head.down = new Node(7);
		list.head.down.down = new Node(8);
		list.head.down.down.down = new Node(30);
		list.head.next = new Node(10);
		list.head.next.down = new Node(20);
		list.head.next.next = new Node(19);
		list.head.next.next.down = new Node(22);
		list.head.next.next.down.down = new Node(50);
		list.head.next.next.next = new Node(28);
		list.head.next.next.next.down = new Node(35);
		list.head.next.next.next.down.down = new Node(40);
		list.head.next.next.next.down.down.down = new Node(45);
		// System.out.println(flattern(list.head));
		list.printList(flattern(list.head));
	}

	/* Let us create the following linked list 
    5 -> 10 -> 19 -> 28 
   	|    |     |     | 
    V    V     V     V 
    7    20    22    35 
    |          |     | 
    V          V     V 
    8          50    40 
    |                | 
    V                V 
    30               45 
 */
	static Node flattern(Node node) {
		Node head = node;
		Node headd = node;

		while (head.next != null || head.down != null) {
			if (head.down != null && head.next != null) {
				if (head.down.data <= head.next.data) {
					Node next = head.next;
					head.next = head.down;
					head.next.next = next;
					head.down = null;
					head = head.next;
				} else {
					Node down = head.down;
					Node ne = head;
					while (ne.next != null && ne.next.data < down.data) {
						ne = ne.next;
					}
					if (ne.next == null) {
						ne.next = down;
						head.down = null;
					} else {
						Node temp = ne.next;
						ne.next = down;
						down.next = temp;
						head.down = null;
					}
				}
			} else {
				if (head.next == null) {
					while (head.down != null) {
						head.next = head.down;
						head.down = head.down.down;
					}
				} else
					head = head.next;
			}

		}

		if (head.next == null) {
			while (head.down != null) {
				head.next = head.next;
				head = head.next;
			}
		}

		return headd;
	}

	
}
