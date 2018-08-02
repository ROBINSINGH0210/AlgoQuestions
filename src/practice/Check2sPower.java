package practice;

import java.util.*;

class Check2sPower {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		List<Long> list = new ArrayList<Long>();
		long a = sc.nextLong();
		Check2sPower s = new Check2sPower();
		for (long i = 0; i < a; i++)
			list.add(sc.nextLong());
		list.forEach(s::checkMethod);
	}

	public void checkMethod(long num) {
		int i = 1;
		while (num >= i) {
			if (i == num) {
				System.out.println("YES");
				break;
			}
			i = i << 1;
		}
		if (num < i)
			System.out.println("NO");
	}
}
