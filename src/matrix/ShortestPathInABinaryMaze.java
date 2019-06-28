package matrix;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInABinaryMaze {

	public static void main(String[] args) {
		 int mat[][] = 
			    { 
			        { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 }, 
			        { 1, 0, 1, 0, 1, 1, 1, 0, 1, 1 }, 
			        { 1, 1, 1, 0, 1, 1, 0, 1, 0, 1 }, 
			        { 0, 0, 0, 0, 1, 0, 0, 0, 0, 1 }, 
			        { 1, 1, 1, 0, 1, 1, 1, 0, 1, 0 }, 
			        { 1, 0, 1, 1, 1, 1, 0, 1, 0, 0 }, 
			        { 1, 0, 0, 0, 0, 0, 0, 0, 0, 1 }, 
			        { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 }, 
			        { 1, 1, 0, 0, 0, 0, 1, 0, 0, 1 } 
			    }; 
		 boolean visited[][] = new boolean[mat.length][mat[0].length];
		 System.out.println(findMinPath(mat,visited , new Point(0, 0), new Point(3, 4)));
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

				if ((row >= 0 && row < mat.length && col >= 0 && col < mat[0].length) && !visited[row][col] && mat[row][col] ==1) {
					q.add(new QNode(new Point(row, col), point.dist + 1));
					visited[row][col] = true;
				}
			}
		}

		return -1;

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