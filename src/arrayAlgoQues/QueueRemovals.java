package arrayAlgoQues;
import java.io.*; 
import java.util.*;
// Add any extra import statements you may need here

class Point{
	@Override
	public String toString() {
		return "Point [pos=" + pos + ", value=" + value + "]";
	}
	int pos; 
	int value;
	Point(int pos, int val){
		this.pos = pos;
		this.value = val;
	}
}
class QueueRemovals {
	
  // Add any helper functions you may need here
	
  

  int[] findPositions(int[] arr, int x) {
    int res[] = new int[x];
    Queue<Point> q = new LinkedList<>();
    int i=0;
    for(int a: arr) {
    	q.add(new Point(i++, a));
    }
    
    i=0;
    while(i<x) {
    	int it= 0;
    	Queue<Point> temp = new PriorityQueue<>((a, b) -> (a.value == b.value) ? a.pos - b.pos : b.value - a.value);
    	Queue<Point> q2 = new LinkedList<>();
    	while(it<x && !q.isEmpty()) {
    		Point poll = q.poll();
			temp.offer(poll);
			q2.offer(poll);
    		it++;
    	}
    	Point max = temp.poll();
    	res[i++] = max.pos+1;
    			
    	while(!q2.isEmpty()) {
    		Point tem = q2.poll();
    		if(tem.value == max.value && tem.pos == max.pos) {
    			continue;
    		}
    		if(tem.value>0) {
    			tem.value-=1;
    		}
    		q.offer(tem);
    	}
    	
    	
    	
    }
    
    
    
    return res;
    
  }












  // These are the tests we use to determine if the solution is correct.
  // You can add your own at the bottom, but they are otherwise not editable!
  int test_case_number = 1;
  void check(int[] expected, int[] output) {
    int expected_size = expected.length; 
    int output_size = output.length; 
    boolean result = true; 
    if (expected_size != output_size) {
      result = false;
    }
    for (int i = 0; i < Math.min(expected_size, output_size); i++) {
      result &= (output[i] == expected[i]);
    }
    char rightTick = '\u2713';
    char wrongTick = '\u2717';
    if (result) {
      System.out.println(rightTick + " Test #" + test_case_number);  
    }
    else {
      System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
      printIntegerArray(expected); 
      System.out.print(" Your output: ");
      printIntegerArray(output);
      System.out.println();
    }
    test_case_number++;
  }
  void printIntegerArray(int[] arr) {
    int len = arr.length; 
    System.out.print("[");
    for(int i = 0; i < len; i++) {
      if (i != 0) {
        System.out.print(", ");
      }
      System.out.print(arr[i]);
    }
    System.out.print("]");
  }
  
  public void run() {
    int n_1 = 6;
    int x_1 = 5;
    int[] arr_1 = {1, 2, 2, 3, 4, 5};
    int[] expected_1 = {5, 6, 4, 1, 2 };
    int[] output_1 = findPositions(arr_1, x_1);
    check(expected_1, output_1);
    
    int n_2 = 13;
    int x_2 = 4;
    int[] arr_2 = {2, 4, 2, 4, 3, 1, 2, 2, 3, 4, 3, 4, 4};
    int[] expected_2 = {2, 5, 10, 13};
    int[] output_2 = findPositions(arr_2, x_2);
    check(expected_2, output_2);
  
    // Add your own test cases here
    
  }
  
  public static void main(String[] args) {
    new QueueRemovals().run();
  }
}