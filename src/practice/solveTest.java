package practice;

public class solveTest {

	public static void main(String[] args) {
		String line;
		while ((line = readline()) != null) {
			String[] nums = line.split(" ");
			if (nums.length == 2) {
				int matchesCount = Integer.parseInt(nums[0]);
				double winningProbability = Double.parseDouble(nums[1]);
				double longestWinningStreak = solve(matchesCount, winningProbability);
				System.out.print(longestWinningStreak);
			}
		}

	}

	private static String readline() {
		// TODO Auto-generated method stub
		return null;
	}

	static double solve(int matchesCount, double winningProbability) {
		double lossProbability = 1 - winningProbability;
		double[] winProbabilities = new double[100];
		winProbabilities[0] = 1;

		for (int i = 1; i < matchesCount + 1; i++) {

			winProbabilities[i] = winProbabilities[i - 1] * winningProbability;
		}
		double streakByMatch[][] = new double[100][];
		for (int match = 0; match < matchesCount + 1; match++) {
			streakByMatch[match] = new double[100];
			for (int streak = 0; streak < matchesCount + 1; streak++) {
				if (streak >= match) {
					streakByMatch[match][streak] = 1;
					continue;
				}
				if (streak + 1 == match) {
					streakByMatch[match][streak] = 1 - winProbabilities[match];
					continue;
				}
				streakByMatch[match][streak] = streakByMatch[match - 1][streak];

				if (match - streak - 2 >= 0) {
					streakByMatch[match][streak] -= streakByMatch[match - streak - 2][streak] * lossProbability
							* winProbabilities[streak + 1];
				}
			}
		}
		double result = 0.;
		for (int i = 1; i < matchesCount + 1; i++) {
			result += i * (streakByMatch[matchesCount][i] - streakByMatch[matchesCount][i - 1]);
		}
		return result;
	}

}
