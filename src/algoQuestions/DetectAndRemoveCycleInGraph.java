package algoQuestions;

import java.util.*;

public class DetectAndRemoveCycleInGraph {
	static class DirectedGraphNode {
		int label;
		List<DirectedGraphNode> neighbors;

		DirectedGraphNode(int x) {
			label = x;
			neighbors = new ArrayList<>();
		}

		List<Integer> getNeighborsLabels() {
			List<Integer> labels = new ArrayList<Integer>();
			for (DirectedGraphNode neighbor : neighbors)
				labels.add(neighbor.label);
			return labels;
		}
	}

	static boolean removeCycles(DirectedGraphNode node, Set<Integer> visited) {
		visited.add(node.label);
		boolean isCycle = false;
		Iterator<DirectedGraphNode> it = node.neighbors.iterator();
		while (it.hasNext()) {
			DirectedGraphNode neighbour = it.next();
			if (visited.contains(neighbour.label)) {
				isCycle = true;
				it.remove();
			} else {
				isCycle |= removeCycles(neighbour, visited);
			}
		}
		visited.remove(node.label);
		return isCycle;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
