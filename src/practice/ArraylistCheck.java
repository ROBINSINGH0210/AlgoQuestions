package practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class ArraylistCheck {
	static List<Employee> list = new ArrayList<Employee>();

	public static void main(String... strings) {
		if (list.isEmpty()) {
			Random r = new Random();
			for (int i = 0; i < 9999999; i++) {
				Employee e = new Employee();
				e.setId(r.nextInt((9999999 - 1) + 1) + 1);
				list.add(e);
			}
		}
		long indexstart = System.currentTimeMillis();
		Employee er = new Employee();
		er.setId(5558884);
		int index = list.indexOf(er);
		if(index == -1)
			System.exit(0);
		list.get(index);
		System.out.println("Index " + index + " Time Taken --> " + (System.currentTimeMillis() - indexstart));
		long forstart = System.currentTimeMillis();
		for (Employee emp : list) {
			if (er.equals(emp)) {
				System.out.println("ForIndex " + index + "  for Time Taken --> " + (System.currentTimeMillis() - forstart));
				break;
			}
		}

		long binarystart = System.currentTimeMillis();
		list.sort(new Comparator<Employee>() {
			@Override
			public int compare(Employee o1, Employee o2) {
				if(o1.getId() == o2.getId())
					return 0;
				else if(o1.getId() > o2.getId())
					return -1;
				else
					return 1;
			}
		});
		
		int key = Collections.binarySearch(list, er);
		System.out.println("Binary Search Index " + key + "  for Time Taken --> " + (System.currentTimeMillis() - binarystart));
	}
}
