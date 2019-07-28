package arrayAlgoQues;

import java.util.*;

public class ArrayBurstProblem {
	public static void main(String[] args) {
		List<String> l = new ArrayList<>();
		l.add("a");
		l.add("b");
		l.add("c");
		l.add("d");
		l.add("e");
		l.add("e");
		l.add("e");
		l.add("e");
		l.add("d");
		l.add("d");
		l.add("c");
		l.add("b");
		l.add("f");
		l.add("g");
		l.add("f");
		System.out.println(getShrunkArray(l,3));
	}

	public static List<String> getShrunkArray(List<String> inputArray, int burstLength) {
		List<String> list = new ArrayList<>();
		String lastchar = null;
		int cnt = 0;
		for (String s : inputArray) {
			if (lastchar == null || s.equals(lastchar)) {
				lastchar = s;
				cnt++;
			} else {
				if (cnt >= burstLength) {
					cnt = 1;
                    if(!list.isEmpty() && list.get(list.size()-1).equals(s)){
                        int size = list.size()-1;
                        while(size >=0 && list.get(size--).equals(s)){
                            cnt++;
                        }
                    }
                    if(!list.isEmpty() && list.get(list.size()-1).equals(lastchar)){
                        int size = list.size()-1;
                        while(size >0 && list.get(size--).equals(lastchar)){
                             list.remove(size);
                        }
                    }
                    lastchar = s;
				} else {
					while (cnt > 0) {
						list.add(lastchar);
						cnt--;
					}
					lastchar = s;
					cnt = 1;
				}
			}
		}
		if(lastchar != null && cnt < burstLength) {
			while (cnt > 0) {
				list.add(lastchar);
				cnt--;
			}
		}

		return list;
	}
}
