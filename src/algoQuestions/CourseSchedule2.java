package algoQuestions;

import java.util.*;

public class CourseSchedule2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] prerequisites = { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } };
		System.out.println(Arrays.toString(findOrder(4, prerequisites)));
	}

	public static int[] findOrder(int numCourses, int[][] prerequisites) {

		List<List<Integer>> graph = new ArrayList<>();
		boolean dp[] = new boolean[numCourses];
		boolean visited[] = new boolean[numCourses];
		for (int i = 0; i < numCourses; i++) {
			graph.add(new ArrayList<Integer>());
		}
		for (int i = 0; i < prerequisites.length; i++) {
			graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
		}

		Stack<Integer> st = new Stack<>();

		for (int i = 0; i < graph.size(); i++) {
			if (dfs(graph, i, st, dp, visited)) {
				return new int[0];
			}
		}
		
		int res[] = new int[numCourses];
//		System.out.println(graph);
		int i =0;
		while(!st.isEmpty()) {
			res[i++] = st.pop();
		}
		
		return res;
	}

	private static boolean dfs(List<List<Integer>> graph, int course, Stack<Integer> st, boolean[] dp,
			boolean[] visited) {
		if (dp[course]) {
			return true;
		} else if(visited[course]) {
			return false;
		} else {
			visited[course] = dp[course] = true;
		}
		for (int i :  graph.get(course)) {
			if (dfs(graph, i, st, dp, visited)) {
				return true;
			}
		}
		st.add(course);
		dp[course] = false;

		return false;
	}

	private boolean dfs(ArrayList[] graph, boolean[] visited, int course, boolean[] dp) {
		if (visited[course])
			return dp[course];
		else
			visited[course] = true;

		for (int i = 0; i < graph[course].size(); i++) {
			if (!dfs(graph, visited, (int) graph[course].get(i), dp)) {
				dp[course] = false;
				return false;
			}
		}

		dp[course] = true;
		return true;
	}
}
