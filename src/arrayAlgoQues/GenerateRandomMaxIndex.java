package arrayAlgoQues;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GenerateRandomMaxIndex {

	public static void main(String[] args) {
		generateRandomMaxIndex(new int[] { 11, 30, 2, 30, 30, 30, 6, 2, 62, 62 });

	}

	static void generateRandomMaxIndex(int arr[]) {
		int max = Integer.MIN_VALUE;
		List<Integer> list = new ArrayList<>();
		Random r = new Random();
		for (int i = 0; i < arr.length; i++) {
			if (max == arr[i]) {
				list.add(i);
			} else if (max < arr[i]) {
				list.clear();
				list.add(i);
				max = arr[i];
			}
			System.out.println(list.get(r.nextInt(list.size())));
		}

	}

}
