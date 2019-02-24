package algoQuestions;

import java.util.*;

public class Graph {
	private List<Integer>[] adjecentVertx;

	public Graph(int vertex) {
		adjecentVertx = new LinkedList[vertex];

		for (int i = 0; i < vertex; i++) {
			adjecentVertx[i] = new LinkedList<>();
		}
	}

	public void addEdge(int start, int end) {
		adjecentVertx[start].add(end);
	}

	private int getNumVertices() {
		return adjecentVertx.length;
	}

	public void topologicalSort(int current, boolean visited[], Stack<Integer> stack) {

		visited[current] = true;

		for (Integer adjcent : adjecentVertx[current]) {
			if (!visited[adjcent]) {
				topologicalSort(adjcent, visited, stack);
			}
		}
		stack.push(current);
	}

	public void topologicalSort() {
		Stack<Integer> stack = new Stack<>();
		boolean[] visited = new boolean[getNumVertices()];

		for (int i = 0; i < visited.length; i++) {
			if (!visited[i]) {
				topologicalSort(i, visited, stack);
			}
		}

		while (!stack.isEmpty()) {
			System.out.println(((char) (stack.pop() + 'a') + " "));
		}
	}
}
