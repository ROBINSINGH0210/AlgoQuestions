package treeQuestions;

import java.util.HashMap;
import java.util.Map;

public class Test {
	public static void main(String... strings) {
		Map<Emp, Integer> map = new HashMap<>();
		
		
		Emp key = new Emp(1, "Robin");
		map.put(key, 1);
		key  = new Emp(1, "Robin");
		map.put(key, 2);
		
		System.out.println(map.get(key));
		
	}
}
