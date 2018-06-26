package bitwiseOperation;

public class MultiplyBySeven {

	public static void main(String[] args) {
		System.out.println(multiply(7));
	}

	static int multiply(int num) {
		return (num << 3) + (3*num);
	}
}
