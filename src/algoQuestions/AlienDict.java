package algoQuestions;

public class AlienDict {

	public static void main(String[] args) {
		String Dict[] = {"baa", "abcd", "abca", "cab", "cad"};
		int alpha = 4;
		dictOrder(Dict, alpha);
	}
	
	private static void dictOrder(String[] arr, int alpha) {
		
		Graph g = new Graph(alpha);
		
		for (int i = 1; i < arr.length; i++) {
			String s1 = arr[i-1];
			String s2 = arr[i];
			for(int j =0; j < Math.min(s1.length(), s2.length()); j++) {
				if(s1.charAt(j) != s2.charAt(j)) {
					g.addEdge(s1.charAt(j) - 'a', s2.charAt(j) - 'a');
					break;
				}
				
			}
		}
		g.topologicalSort();
		
	}


}


