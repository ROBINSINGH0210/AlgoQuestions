package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Feature {

	static int missingNumber(int arr[]) {
		int y = arr[0];

		for (int i = 1; i < arr.length; i++) {
			y ^= arr[i];
		}
		return y;

	}

	public static void main(String[] args) throws IOException {
//		 int arr[] = {0b01001,0b11100,0b10111};

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		String aarr[] = reader.readLine().split(" ");
		int arr[] = new int[Integer.parseInt(aarr[0].trim())];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(reader.readLine(), 2);
		}
		if (arr.length == 1) {
			Integer.toBinaryString(arr[0]);
		}
		 
		 
		System.out.println(Integer.toBinaryString(missingNumber(arr)).);
	}

}
