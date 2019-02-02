package algoQuestions;

public class CheckNumberIsPrime {

	public static void main(String[] args) {

		int num = 17;
		int s = 1;
		for (int i = 1; i < num; i++) {
			s = ((s % num) * (2 % num)) % num;
		}

		if (s == 1)
			System.out.println(s + "Prime");
		else
			System.out.println(s + "Not Prime");

	}
}
