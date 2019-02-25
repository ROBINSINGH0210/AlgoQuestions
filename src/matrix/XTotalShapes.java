package matrix;

import java.util.Scanner;

public class XTotalShapes {

	public static void main(String[] args) {
		Scanner ab = new Scanner(System.in);
		int l = ab.nextInt();
		while (l-- > 0) {
			int n = ab.nextInt();
			int k = ab.nextInt();
			char arr[][] = new char[n][k];
			for (int i = 0; i < n; i++) {
				String tm = new String(ab.next());
				for (int j = 0; j < k; j++)
					arr[i][j] = tm.charAt(j);
			}
			System.out.println(count(arr));
		}

	}

	public static int count(char[][] matrix) {
		int count = 0;
		boolean visited[][] = new boolean[matrix.length][matrix[0].length];
		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[row].length; col++) {
				if (matrix[row][col] == 'X' && !visited[row][col]) {
					count++;
					markAllTheAdjcent(matrix, visited, row, col);
				}
				visited[row][col] = true;
			}
		}

		return count;
	}

	private static void markAllTheAdjcent(char[][] matrix, boolean[][] visited, int row, int col) {

		if (matrix[row][col] == 'X' && !visited[row][col]) {
			visited[row][col] = true;
			if (row + 1 < matrix.length)
				markAllTheAdjcent(matrix, visited, row + 1, col);
			if (row - 1 >= 0)
				markAllTheAdjcent(matrix, visited, row - 1, col);
			if (col + 1 < matrix[row].length)
				markAllTheAdjcent(matrix, visited, row, col + 1);
			if (col - 1 >= 0)
				markAllTheAdjcent(matrix, visited, row, col - 1);

		} else
			return;

	}

}
