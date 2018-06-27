package goldman;

public class NumOfStairs {

	public static void main(String[] args) {
		int num = 15;
		int count = numOfSteps(num);
		System.out.println(count);
	}

	private static int numOfSteps(int num) {
		int count = 0;
		if (num <= count)
			return 0;
		while (num >= count) {
			count++;
			num -= count;
			if (num < 0)
				count--;
		}
		return count;
	}

}
