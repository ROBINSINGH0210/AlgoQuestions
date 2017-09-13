package javaTest;

import java.util.*;
import java.util.Map.Entry;

public class TestABC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Abc abc = new Abc();

		abc.m.put("A", "asdA");
		abc.m.put("B", "Bds");
		abc.m.put("C", "wfC");
		abc.m.put("D", "sadD");
		abc.m.put("E", "dsaE");
		abc.m.put("F", "Fddwq");
		
		Set<Map.Entry<String, String>> s = abc.m.entrySet();
		for (Entry<String, String> entry : s) {
			System.out.println(entry.toString());
		}
		
		List<Map.Entry<String, String>> li = new ArrayList<Map.Entry<String,String>>(s);
		Collections.sort(li,new Comparator<Map.Entry<String, String>>(){

			@Override
			public int compare(Entry<String, String> o1,
					Entry<String, String> o2) {
				return o1.getValue().compareToIgnoreCase(o2.getValue());
			}
			
		});
		System.out.println("NEW MAP");
		for (Entry<String, String> entry : li) {
			System.out.println(entry.toString());
		}
		
	}

}

class Abc {
	Map<String, String> m = new HashMap<String, String>();

}