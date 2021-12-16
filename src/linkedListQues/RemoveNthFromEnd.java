package linkedListQues;

public class RemoveNthFromEnd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(1);
//		head.next = new ListNode(2);
//		head.next.next = new ListNode(3);
//		head.next.next.next = new ListNode(4);
//		head.next.next.next.next = new ListNode(5);
		System.out.println( removeNthFromEnd(head, 1));
	}

	public static ListNode removeNthFromEnd(ListNode head, int n) {

		ListNode head1 = head;
		ListNode prev = null;
		ListNode curr = head;
		int size = 0;
		while (curr != null) {
			curr = curr.next;
			size++;
		}
		curr = head;
		int count = 1;
		while (curr != null) {
			if (size - count + 1 == n) {
				if (prev != null)
					prev.next = curr.next;
				else
					head1 = curr.next ;
				break;
			} else {
				prev = curr;
				curr = curr.next;
			}
			count++;
		}

		return head1;
	}

}

class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}

	@Override
	public String toString() {
		return "ListNode [val=" + val + ", next=" + next + "]";
	}
	
}
