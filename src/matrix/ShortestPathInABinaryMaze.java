package matrix;

import java.util.*;

public class ShortestPathInABinaryMaze {

	public static void main(String[] args) {
		int mat[][] = { { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 }, { 1, 0, 1, 0, 1, 1, 1, 0, 1, 1 }, { 1, 1, 1, 0, 1, 1, 0, 1, 0, 1 },
				{ 0, 0, 0, 0, 1, 0, 0, 0, 0, 1 }, { 1, 1, 1, 0, 1, 1, 1, 0, 1, 0 }, { 1, 0, 1, 1, 1, 1, 0, 1, 0, 0 },
				{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 1 }, { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 }, { 1, 1, 0, 0, 0, 0, 1, 0, 0, 1 } };
		boolean visited[][] = new boolean[mat.length][mat[0].length];
//		System.out.println(findMinPath(mat, visited, new Point(0, 0), new Point(3, 4)));
		
		ArrayList<Integer> i = new ArrayList<>();
		i.add(20);
		i.add(70);
		i.add(90);
		i.add(30);
		i.add(60);
		i.add(110);
		System.out.println(IDsOfSongs(110, i));
	}

	public static int findMinPath(int mat[][], boolean visited[][], Point src, Point dest) {
		int rowNum[] = { -1, 0, 0, 1 };
		int colNum[] = { 0, -1, 1, 0 };
		if (mat[src.x][src.y] == 0 || mat[dest.x][dest.y] == 0) {
			return -1;
		}
		Queue<QNode> q = new LinkedList<>();
		q.add(new QNode(src, 0));
		while (!q.isEmpty()) {
			QNode point = q.poll();

			Point pt = point.pt;
			if (pt.x == dest.x && pt.y == dest.y) {
				return point.dist;
			}

			for (int i = 0; i < 4; i++) {
				int row = pt.x + rowNum[i];
				int col = pt.y + colNum[i];

				if ((row >= 0 && row < mat.length && col >= 0 && col < mat[0].length) && !visited[row][col] && mat[row][col] == 1) {
					q.add(new QNode(new Point(row, col), point.dist + 1));
					visited[row][col] = true;
				}
			}
		}

		return -1;

	}

	int minimumDistance(int numRows, int numColumns, List<List<Integer>> area) {
		boolean visited[][] = new boolean[area.size()][area.get(0).size()];
		int rowNum[] = { -1, 0, 0, 1 };
		int colNum[] = { 0, -1, 1, 0 };
		// if (area.get(0).get(0) == 0) {
		// return -1;
		// }
		Queue<QNode> q = new LinkedList<>();
		q.add(new QNode(new Point(0, 0), area.get(0).get(0)));
		while (!q.isEmpty()) {
			QNode point = q.poll();

			Point pt = point.pt;
			if (area.get(pt.x).get(pt.y) == 9) {
				return point.dist;
			}

			for (int i = 0; i < 4; i++) {
				int row = pt.x + rowNum[i];
				int col = pt.y + colNum[i];

				if ((row >= 0 && row < numRows && col >= 0 && col < numColumns) && !visited[row][col] && area.get(row).get(col) == 1) {
					q.add(new QNode(new Point(row, col), point.dist + 1));
					visited[row][col] = true;
				} else if ((row >= 0 && row < numRows && col >= 0 && col < numColumns) && !visited[row][col]
						&& area.get(row).get(col) == 9) {
					q.add(new QNode(new Point(row, col), point.dist));
					visited[row][col] = true;
				}
			}
		}

		return -1;
	}
	// METHOD SIGNATURE ENDS

	static ArrayList<Integer> IDsOfSongs(int rideDuration, ArrayList<Integer> songDurations) {
		int songTime = rideDuration - 30;
		int x = 0;
		int y = songDurations.size() - 1;
		ArrayList<Integer> l = new ArrayList<>();
		ArrayList<Integer> s = (ArrayList<Integer>) songDurations.clone();
		Collections.sort(songDurations);

		while (x < y) {
			int length = songDurations.get(x) + songDurations.get(y);
			if (length == songTime) {
				if (l.isEmpty()) {
					l.clear();
					l.add(s.indexOf(songDurations.get(x)));
					l.add(s.indexOf(songDurations.get(y)));
				}
				x++;
				y--;
			} else if (length > songTime) {
				y--;
			} else {

				x++;
			}

		}
		return l;
	}

}

class Point {
	int x;
	int y;

	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

}

class QNode {
	Point pt;
	int dist;

	public QNode(Point pt, int dist) {
		super();
		this.pt = pt;
		this.dist = dist;
	}
}