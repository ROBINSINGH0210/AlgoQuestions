package algoQuestions;
import java.util.*;

public class TestClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 List<String> arraylist = new ArrayList<String>();
		   arraylist.add("AA");
		   arraylist.add("ZZ");
		   arraylist.add("CC");
		   arraylist.add("FF");
		   
		   Collections.sort(arraylist,Collections.reverseOrder());
		   
		   for (String string : arraylist) {
			System.out.println(string);
		}

	}

}
