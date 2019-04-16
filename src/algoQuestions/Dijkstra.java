package algoQuestions;

import java.util.*;


public class Dijkstra {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int[][] matrix = new int[5][5];
		int[] distance = new int[5];
		int[] visited = new int[5];
		int[] preD = new int[5];
		int min;
		int nextNode =0;
		for(int i = 0; i <5; i++){
			visited[i] =0;
			preD[i] = 0;
			for(int j = 0; j<5; j++){
				matrix[i][j] = scan.nextInt();
				if(matrix[i][j] == 0)
					matrix[i][j] = 999;
			}
		}
		distance = matrix[0];
		distance[0] = 0;
		visited[0] =1;
		for(int i =0; i<5; i++){
			min = 999;
			for(int j =0; j<5; j++){
				if(min> distance[j] && visited[j] !=1){
					min = distance[j];
					nextNode = j;
				}
			}
			visited[nextNode] = 1;
			//Algo Start
			
			for(int c =0; c<5; c++){
				if(visited[c]!=1){
					if(min+matrix[nextNode][c] < distance[c]){
						distance[c] = min+matrix[nextNode][c];
						preD[c] = nextNode;
					}
				}
			}
		}
		for(int i =0; i<5; i++){
			System.out.println(" | " + distance[i]);
		}
		System.out.println(" | ");
		
		for(int i =0; i<5; i++){
			int j;
			System.out.println(" path = " +i);
			j = i;
			do{
				j = preD[j];
				System.out.println(" <- "+j );
			}while(j!=0);
			
			System.out.println();
		}
		System.out.println(" | ");
	}
	
}
