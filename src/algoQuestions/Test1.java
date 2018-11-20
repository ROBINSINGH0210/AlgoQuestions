package algoQuestions;

public class Test1 {

	 public boolean validStatements(char[][] equal, char[][] unequal) {
	        int[] sets = new int[26];
	        for(int i = 0; i < 26; i++) {
	            sets[i] = i;
	        }

	        for(char[] pair: equal) {
	            mergeSets(sets, pair[0] - 'A', pair[1] - 'A');
	        }
	        for(int i = 0; i < 26; i++) {
	            findSrc(sets, i);
	        }

	        for(char[] pair: unequal) {
	            if(sets[pair[0] - 'A'] == sets[pair[1] - 'A']) return false;
	        }
	        return true;
	    }

	    private int findSrc(int[] sets, int i) {
	        int src = i;
	        while(src != sets[src]) {
	            src = sets[src];
	        }
	        int tmp;
	        while (i != sets[i]) {
	            tmp = sets[i];
	            sets[i] = src;
	            i = tmp;
	        }
	        return src;
	    }

	    private void mergeSets(int[] sets, int a, int b) {
	        int srcA = findSrc(sets, a);
	        int srcB = findSrc(sets, b);
	        sets[srcB] = srcA;
	    }

}
