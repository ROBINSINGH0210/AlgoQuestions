package algoQuestions;

import linkedListQues.SinglyLinkedList;

public class DetectAndRemoveLoop {

	public static void main(String[] args) {

	}

	public static void detectAndRemove(SinglyLinkedList list) {
		SinglyLinkedList.Node slow = list.head;
		SinglyLinkedList.Node fast = list.head;

		while (slow != null && fast != null && fast.next != null) {
			fast = fast.next;
			if (slow.data == fast.data) {
				System.out.println(" loop found ");
				break;
			}
		}
		if (slow == fast) {
			slow = list.head;

			while (slow.next != fast.next) {
				slow = slow.next;
				fast = fast.next;
				break;
			}
			fast.next = null;
		}
	}

}
