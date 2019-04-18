package algoQuestions;

import java.util.PriorityQueue;
import java.util.Queue;

public class DikstraUsingPriorityQueue {

	public static void main(String[] args) {

	}

	public static void getSortestPath(Vertices startVertex) {
		Queue<Vertices> queue= new PriorityQueue<Vertices>();
		startVertex.setDistance(0);
		startVertex.setVisited(true);
		queue.add(startVertex);
		
		while(!queue.isEmpty()) {
			Vertices start = queue.poll();
			for (Edge edge : start.getAdjecentVerticies()) {
				Vertices targetVertex = edge.getTargetVertex();
				if(!targetVertex.isVisited()) {
					int minDist = start.getDistance() + edge.getWeight();
					if(minDist < targetVertex.getDistance()) {
						queue.remove(targetVertex);
						targetVertex.setDistance(minDist);
						targetVertex.setPredecessor(start);
						queue.add(targetVertex);
					}
				}
				
			}
			start.setVisited(true);
		}
		
	}
}
