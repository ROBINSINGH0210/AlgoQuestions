package matrix;

import java.util.HashMap;
import java.util.Map;

public class BejeweledScores {
	static char B = 'b';
	static char Y = 'y';
	static char G = 'g';
	static char R = 'r';

	public static void main(String[] args) {
		char[][] arr = { { G, R, R, B, B, G, B, Y }, 
						 { R, R, R, B, Y, G, B, Y }, 
						 { G, B, R, B, B, B, B, R },
						 { G, R, B, B, B, G, B, Y }, 
						 { G, R, R, G, G, G, B, R }, 
						 { G, R, R, B, B, R, B, Y },
						 { G, B, R, Y, B, G, G, G }, 
						 { G, R, R, B, B, G, B, Y } };
		BejeweledScores b = new BejeweledScores();
		System.out.println(b.count(arr));
//		r ,13
//		b ,20
//		g ,12
//		450
	}

	int count(char arr[][]) {
		Map<Character, Integer> map = new HashMap<>();
		int sum = 0;
		count(arr, map);

		for (Map.Entry<Character, Integer> m : map.entrySet()) {
			System.out.println(m.getKey() + " ," + m.getValue());
			sum += m.getValue() * 10;
		}
		return sum;
	}

	int i = 0;
	int j = 0;

	private void count(char[][] arr, Map<Character, Integer> map) {
		for (i = 0; i < arr.length; i++) {
			for (j = 0; j < arr[i].length; j++) {
				if (j + 2 < arr[i].length) {
					if (arr[i][j] == arr[i][j + 1] && arr[i][j] == arr[i][j + 2]) {
						findAndMarkRow(arr, i, map);
					}

				}
			}
		}

		for (j = 0; j < arr[0].length; j++) {
			for (i = 0; i < arr.length; i++) {
				if (i + 2 < arr.length) {
					if (arr[i][j] == arr[i + 1][j] && arr[i][j] == arr[i + 2][j]) {
						findAndMarkCol(arr, j, map);
					}

				}
			}
		}

	}

	void findAndMarkRow(char[][] arr, int i2, Map<Character, Integer> map) {
		int count = 1;
		while (j < arr[i].length -1 && arr[i][j] == arr[i][j + 1]) {
			count++;
			j++;
		}
		map.put(arr[i][j], map.getOrDefault(arr[i][j], 0) + count);

	}

	void findAndMarkCol(char[][] arr, int j, Map<Character, Integer> map) {
		int count = 1;
		while (i < arr.length -1 && arr[i][j] == arr[i + 1][j]) {
			count++;
			i++;
		}
		map.put(arr[i][j], map.getOrDefault(arr[i][j], 0) + count);

	}
}
