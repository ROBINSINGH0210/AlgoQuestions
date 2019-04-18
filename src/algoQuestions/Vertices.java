package algoQuestions;

import java.util.List;

public class Vertices implements Comparable<Vertices> {
	private List<Edge> adjecentVerticies;
	private int distance = Integer.MAX_VALUE;
	private Vertices predecessor;
	private boolean isVisited;
	private String name;

	public boolean isVisited() {
		return isVisited;
	}

	public void setVisited(boolean isVisited) {
		this.isVisited = isVisited;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Edge> getAdjecentVerticies() {
		return adjecentVerticies;
	}

	public void setAdjecentVerticies(List<Edge> adjecentVerticies) {
		this.adjecentVerticies = adjecentVerticies;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public Vertices getPredecessor() {
		return predecessor;
	}

	public void setPredecessor(Vertices predecessor) {
		this.predecessor = predecessor;
	}

	@Override
	public int compareTo(Vertices o) {
		return this.distance - o.distance;
	}

}
