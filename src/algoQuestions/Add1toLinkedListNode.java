package algoQuestions;

public class Add1toLinkedListNode {

	public static void main(String[] args) {
		SinglyNode node = new SinglyNode(9);
		node.next = new SinglyNode(9);

		System.out.println(addOne(node));

	}
	
	static SinglyNode addOne( SinglyNode node) {
		int carry = addOneWithCarry(node);
		
		if(carry >0) {
			SinglyNode node1 = new SinglyNode(carry);
			node1.next = node;
			return node1;
		}else
			return node;
	}

	static int addOneWithCarry(SinglyNode node) {
		int temp;
		if (node == null)
			return 1;
		temp = node.data + addOneWithCarry(node.next);
		node.data = temp % 10;
		return temp / 10;
	}
}

class SinglyNode {
	int data;
	SinglyNode next;

	SinglyNode(int item) {
		data = item;
		next = null;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SinglyNode [data=").append(data).append(", next=").append(next).append("]");
		return builder.toString();
	}

}
