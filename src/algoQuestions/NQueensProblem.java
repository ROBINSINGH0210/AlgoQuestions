package algoQuestions;

import java.util.LinkedList;
import java.util.List;

public class NQueensProblem {
	private static int n;
	static List<Queen> queens;

	public static void main(String[] args) {
		queens = new LinkedList<>();
		n = 5;
		System.out.println(placeQueen(0));
		System.out.println(queens);
	}

	private static boolean placeQueen(int col) {
		if (col >= n)
			return true;
		int row = 0;
		while (row < n) {
			Queen tempQ = new Queen(row, col);
			queens.add(tempQ);
			if (isSafe(row, col) && placeQueen(col + 1)) {
				return true;
			} else {
				queens.remove(tempQ);
				row++;
			}
		}
		return false;
	}

	private static boolean isSafe(int row, int col) {
		for(int i =0; i<queens.size()-1; i++) {
			int r = queens.get(i).row;
			int c = queens.get(i).col;
			if (r == row || (Math.abs(r - row) == Math.abs(c - col))) {
				return false;
			}
		}
		return true;
	}
}

class Queen {
	int row, col;

	public Queen(int row, int col) {
		this.row = row;
		this.col = col;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Queen [row=").append(row).append(", col=").append(col).append("]");
		return builder.toString();
	}
	
	

}