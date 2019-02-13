package matrix;

import java.util.*;

public class Rotate2DArray {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		for (int k = 0; k < testCase; k++) {
			int a = sc.nextInt();
			int arr[][] = new int[a][a];
			for (int i = 0; i < a; i++) {
				for (int j = 0; j < a; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			System.out.println(printRotatedMatrix(a, arr));
		}
	}

	private static String printRotatedMatrix(int a, int arr[][]) {
		String s = "";
		for (int j = 0; j < a; j++) {
			for (int i = a - 1; i >= 0; i--) {
				if ("".equals(s))
					s = "" + arr[i][j];
				else
					s = s + " " + arr[i][j];
			}
		}
		return s;
	}

}
