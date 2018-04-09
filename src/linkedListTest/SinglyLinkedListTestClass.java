package linkedListTest;

import java.util.Iterator;

public class SinglyLinkedListTestClass {

	public static void main(String[] args) {

		SinglyLinkedList list = new SinglyLinkedList();
		list.insert(3);
		list.insert(5);
		list.insert(9);
		System.out.println(list.size());
		Iterator itr = list.iterator();
		System.out.println(itr.hasNext());
		System.out.println(itr.next());
		System.out.println(itr.next());
		System.out.println(itr.next());
		System.out.println(itr.next());
	}

}
