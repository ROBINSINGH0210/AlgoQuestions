package linkedListQues;

import linkedListQues.SinglyLinkedList.Node;

class ReorderList {
	Node h = null;
	Node h1 = null;

	public static void main(String[] args) {
		SinglyLinkedList list = new SinglyLinkedList();
		list.insert(29);
		list.insert(144);
		list.insert(12);
		list.insert(129);
		list.insert(130);
		list.insert(177);
		list.insert(5);
		list.insert(44);
		list.insert(164);

		list.insert(14);
		list.insert(139);
		list.insert(7);
		list.insert(41);
		list.insert(105);
		list.insert(19);
		list.insert(129);
		list.insert(89);
		list.insert(170);
		list.insert(118);

		// 29 144 12 129 130 177 5 44 164 14 139 7 41 105 19 129 89 170 118

		// ?? 12/2 =6 11/2 = 5
		// 75 122 59 196 30 38 36 194

		list.printList(list.head);
		System.out.println(" After Sort ");
		reorderlist(list.head);
		list.printList(list.head);
	}

	static Node orig;
	static boolean reached = false;
	static Node origh;
	static int size;
	static int count;

	static Node reorderlist(Node head) {
		if (head == null) {
			return head;
		}
		origh = head;
		orig = head;
		Node h = head;

		reorder(h);
		return origh;

	}

	static void reorder(Node head) {
		if (head == null) {
			return;
		}
		count++;
		size++;
		reorder(head.next);
		count--;
		if ( (size %2 !=0 && count == size / 2) || (size %2 ==0 && count < size / 2)) {
			reached = true;
		}
		if (reached) {
			orig.next = null;
			return;
		}

		Node temp = orig.next;
		orig.next = head;
		orig.next.next = temp;
		orig = orig.next.next;
		// head = null;

	}
}