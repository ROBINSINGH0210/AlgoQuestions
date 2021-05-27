package algoQuestions;

import java.util.*;
// Add any extra import statements you may need here

class CountDistinctTriangles {

	class Sides {
		int a;
		int b;
		int c;

		Sides(int a, int b, int c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}
	}

	// Add any helper functions you may need here

	int countDistinctTriangles(ArrayList<Sides> arr) {
		Set<String> s = new HashSet<>();
		for (Sides sd : arr) {
			int max1, max2, max3 = 0;
			max1 = sd.a;
			if (sd.b >= max1) {
				max2 = sd.b;
			} else {
				max2 = max1;
				max1 = sd.b;
			}
			if (sd.c >= max2) {
				max3 = sd.c;
			} else if (max2 > sd.c && sd.c > max1) {
				max3 = max2;
				max2 = sd.c;

			} else if (sd.c < max2 && sd.c < max1) {
				int temp = max1;
				max3 = max2;
				max1 = sd.c;
				max2 = temp;
			}
			String str = "" + max1 + max2 + max3;
			s.add(str);
		}

		return s.size();

	}

	// These are the tests we use to determine if the solution is correct.
	// You can add your own at the bottom, but they are otherwise not editable!
	int test_case_number = 1;

	void check(int expected, int output) {
		boolean result = (expected == output);
		char rightTick = '\u2713';
		char wrongTick = '\u2717';
		if (result) {
			System.out.println(rightTick + " Test #" + test_case_number);
		} else {
			System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
			printInteger(expected);
			System.out.print(" Your output: ");
			printInteger(output);
			System.out.println();
		}
		test_case_number++;
	}

	void printInteger(int n) {
		System.out.print("[" + n + "]");
	}

	public void run() {
		ArrayList<Sides> arr_1 = new ArrayList<>();
		arr_1.add(new Sides(7, 6, 5));
		arr_1.add(new Sides(5, 7, 6));
		arr_1.add(new Sides(8, 2, 9));
		arr_1.add(new Sides(2, 3, 4));
		arr_1.add(new Sides(2, 4, 3));
		int expected_1 = 3;
		int output_1 = countDistinctTriangles(arr_1);
		check(expected_1, output_1);

		ArrayList<Sides> arr_2 = new ArrayList<>();
		arr_2.add(new Sides(3, 4, 5));
		arr_2.add(new Sides(8, 8, 9));
		arr_2.add(new Sides(7, 7, 7));
		int expected_2 = 3;
		int output_2 = countDistinctTriangles(arr_2);
		check(expected_2, output_2);

		// Add your own test cases here

	}

	public static void main(String[] args) {
		new CountDistinctTriangles().run();
	}
}