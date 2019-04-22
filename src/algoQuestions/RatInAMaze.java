package algoQuestions;

public class RatInAMaze {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static boolean isSafe(int maze[][], int x, int y) {
		return (x >= 0 && y >= 0 && y < maze.length && x < maze.length);
	}

	public static boolean ratInMazeUtil(int maze[][], int x, int y, int sol[][]) {

		if (x == maze.length - 1 && y == maze.length - 1) {
			sol[x][y] = 1;
			return true;
		}

		if (isSafe(maze, x, y)) {
			sol[x][y] = 1;
			if (ratInMazeUtil(maze, x + 1, y, sol)) {
				return true;
			}
			if (ratInMazeUtil(maze, x, y + 1, sol))
				return true;

			sol[x][y] = 0;
			return false;
		}
		return false;
	}

}
