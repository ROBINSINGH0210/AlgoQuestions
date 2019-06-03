package arrayAlgoQues;

import java.util.Arrays;

public class Sort0s1 {

	public static void main(String[] args) {
		int arr[] = new int[] { 0, 1, 1, 0, 0, 0, 1, 1, 1, 0 };
		sort0s1(arr);
		System.out.println(Arrays.asList(arr));

	}

	static void sort0s1(int[] arr) {
		int i = 0;
		int len = arr.length - 1;

		while (i < len) {
			if(arr[i] == 1) {
				int temp = arr[i];
				arr[i] = arr[len];
				arr[len] = temp;
				len--;
			}else
				i++;
			
		}

	}

}
