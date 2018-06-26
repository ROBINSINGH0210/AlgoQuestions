package bitwiseOperation;

import java.util.Scanner;

public class DivisibilityCheck {

	public static void main(String[] args) {
		isDivisible(4);
	}

	static void isDivisible(int num) {
		int rem = 0;
		while (true) {
			Scanner s = new Scanner(System.in);
			int bit = s.nextInt();
			if (bit == 1)
				rem = ((rem * 2) + 1) % num;
			else if (bit == 0)
				rem = (rem * 2) % num;
			else
				break;

			if (rem == 0)
				System.out.println("Number is divisble");
			else
				System.out.println("not divisible");

		}
	}
}
