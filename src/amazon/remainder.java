package amazon;

import java.util.Arrays;

class A {
	protected int x = 10;
	static int j = 21;
}

class B extends A {

}

public class Test {
	static int number;

	public static void main(String[] args) {
		Double d1 = 0.0 / 0.0;
		int modNumber = 9;
		int number = 213;
		System.out.println(number - (modNumber*remainder(number, modNumber)));

	}

	static int remainder(int num, int modNum) {
		int count = 0;
		while (num > modNum) {
			num = num - modNum;

			count++;
		}
		return count;
	}

}
