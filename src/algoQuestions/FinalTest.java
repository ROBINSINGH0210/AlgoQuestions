package algoQuestions;

import java.util.ArrayList;
import java.util.List;

public class FinalTest {
	final List<String> list = new ArrayList();
	List<String>  s = new ArrayList<String>();
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FinalTest f = new FinalTest();
		f.list.add("Robin");
		for (String string : f.list) {
			System.out.println(string);
		}
		f.list.remove("");
//		f.list = f.s;
		
		// TODO Auto-generated method stub

	}

}
