package bitwiseOperation;

public class AddOne {

	public static void main(String[] args) {
		System.out.println(add(113));
	}

	static int add(int num) {
		int m = 1;

		while ((int) (num & m) == m) {
			num = num ^ m;
			m <<= 1;
		}
		num = num ^ m;
		return num;
	}
}
