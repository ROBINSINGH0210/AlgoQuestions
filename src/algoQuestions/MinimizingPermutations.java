package algoQuestions;

import java.util.*;
// Add any extra import statements you may need here

class MinimizingPermutations {

	// Add any helper functions you may need here
	static class Node {
		String str;
		int step;

		Node(String str, int step) {
			this.str = str;
			this.step = step;
		}
	}

	String reverse(String s, int index) {
		int i = 0;
		char[] c = s.toCharArray();
		while (i < index) {
			char temp = c[i];
			c[i] = c[index];
			c[index] = temp;
			i++;
			index--;
		}
		return new String(c);
	}

	int minOperations(int[] arr) {
	        StringBuilder sb = new StringBuilder();
	        for(int i = 0; i < arr.length; i++)
	        {
	            sb.append(arr[i]);
	        }
	        String start = sb.toString();
	        Arrays.sort(arr);
	        sb = new StringBuilder();
	        for(int i = 0; i < arr.length; i++)
	        {
	            sb.append(arr[i]);
	        }
	        String dest = sb.toString();
	        Queue<Node> queue = new LinkedList<>();
	        queue.offer(new Node(start, 0));
	        HashSet<String>set = new HashSet<>();
	        set.add(start);
	        if (start.equals(dest)) { 
	            return 0; 
	        } 
	        while(!queue.isEmpty())
	        {
	             Node node = queue.poll();
	             String startnode = node.str;
	             if(startnode.equals(dest))
	             {
	                return node.step;
	             }
	             for(int i = 1 ; i < arr.length; i++)
	             {
	                 for(int j = 0; j < i; j++)
	                 {
	                      
	                      String reverse = startnode.substring(j, i+1);
	                      StringBuffer sbr = new StringBuffer(reverse);
	                      
	                      sbr.reverse();
	                      reverse = sbr.toString();
	                      String newnode="";
	                      if (j>0)
	                         newnode = startnode.substring(0,j);
	                      if (i+1< arr.length)
	                         newnode += reverse + startnode.substring(i+1);
	                      else
	                         newnode += reverse;
	                      if (!set.contains(newnode))
	                      {
	                         set.add(newnode);
	                         queue.offer(new Node(newnode, node.step+1));
	                      }
	                 }
	             }
	        }
	        return -1;
	  }

	// These are the tests we use to determine if the solution is correct.
	// You can add your own at the bottom, but they are otherwise not editable!
	int test_case_number = 1;

	void check(int expected, int output) {
		boolean result = (expected == output);
		char rightTick = '\u2713';
		char wrongTick = '\u2717';
		if (result) {
			System.out.println(rightTick + " Test #" + test_case_number);
		} else {
			System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
			printInteger(expected);
			System.out.print(" Your output: ");
			printInteger(output);
			System.out.println();
		}
		test_case_number++;
	}

	void printInteger(int n) {
		System.out.print("[" + n + "]");
	}

	public void run() {

		int[] arr_1 = { 1, 2, 5, 4, 3 };
		int expected_1 = 1;
		int output_1 = minOperations(arr_1);
		check(expected_1, output_1);

		int[] arr_2 = { 3, 1, 2 };
		int expected_2 = 2;
		int output_2 = minOperations(arr_2);
		check(expected_2, output_2);

		// Add your own test cases here

	}

	public static void main(String[] args) {
		new MinimizingPermutations().run();
	}
}