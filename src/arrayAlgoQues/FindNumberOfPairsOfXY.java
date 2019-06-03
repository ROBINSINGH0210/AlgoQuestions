package arrayAlgoQues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Find number of pairs (x, y) in an array such that x^y > y^x
 */
public class FindNumberOfPairsOfXY {

	public static void main(String[] args) {
		int X[] = {10, 19, 18} ,Y[] = {11, 15, 9};
		
		System.out.println(findPairs(X, Y));
	}

	public static List<Pair> findPairs(int x[], int y[]) {
		List<Pair> pairs = new ArrayList<>();
		Arrays.sort(x);
		Arrays.sort(y);
		for (Integer first : x) {
			for (Integer sec : y) {
				if (Math.pow(first, sec) > Math.pow(sec, first)) {
					pairs.add(new Pair(first, sec));
				}
			}
		}
		return pairs;
	}

}

class Pair {
	int x;
	int y;

	public Pair(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("(").append(x).append(", ").append(y).append(")");
		return builder.toString();
	}
	
	

}