package treeQuestions;

import java.util.*;
import java.util.Map.Entry;

public class TestMap {
		public static void main(String[] args) {
			Emp e1 = new Emp(1, "Robin");
			Emp e2 = new Emp(2, "Singh");
			Map<Emp,String> map = new HashMap();
			System.out.println("trie put " + map.put(e1, "RObin"));
			System.out.println("trie put " + map.put(e2, "Singh"));
			for (Entry<Emp, String> entry : map.entrySet()) {
				System.out.println("Key"+ entry.getKey().getId() + "  Value " + entry.getValue());
			}
			
			map = Collections.unmodifiableMap(map);
			map.put(new Emp(3, "panwar"), "Panwar");
			System.out.println("After unmodifible Map");
			
			for (Entry<Emp, String> entry : map.entrySet()) {
				System.out.println("Key"+ entry.getKey().getId() + "  Value " + entry.getValue());
			}
			
			
	}

}
