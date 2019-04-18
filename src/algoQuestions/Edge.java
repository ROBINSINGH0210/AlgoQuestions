package algoQuestions;

public class Edge {
	private Vertices sourceVertex;
	private Vertices targetVertex;
	private int weight;

	public Vertices getSourceVertex() {
		return sourceVertex;
	}

	public void setSourceVertex(Vertices sourceVertex) {
		this.sourceVertex = sourceVertex;
	}

	public Vertices getTargetVertex() {
		return targetVertex;
	}

	public void setTargetVertex(Vertices targetVertex) {
		this.targetVertex = targetVertex;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

}
