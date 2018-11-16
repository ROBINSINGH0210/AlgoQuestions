package practice;

public class ThiefTryingToEscape {

	public static void main(String[] args) {
		System.out.println(countJump(4, 1, 5, new int[] {6, 9, 11, 4, 5}));
	}

	public static int countJump(int jump, int slip, int nWalls, int[] h) {

		int jumpCount = 0;
		int i = 0;
		while (nWalls > i) {
			int hightOfWall = h[i];
			while (hightOfWall > 0) {
				hightOfWall -= jump;
				if (hightOfWall > 0)
					hightOfWall += slip;
				jumpCount++;
			}
			i++;
		}
		return jumpCount;
	}

}
