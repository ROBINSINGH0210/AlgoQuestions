package practice;

class FiobnacciSeries {
	static int fib(int n) {
		if (n <= 1)
			return n;
		return fib(n - 1) + fib(n - 2);
	}

	public static void main(String args[]) {
		int n = 40;
		System.out.println(fib(n));
		System.out.println(fibDP(n));
	}

	static int fibDP(int n) {
		if (n == 0 || n == 1)
			return n;
		int []fib = new int[n+2];
		fib[0] = 0;
		fib[1] = 1;
		for (int i = 2; i <= n; i++) {
			fib[i] = fib[i - 1] + fib[i - 2];
		}
		return fib[n];
	}
}
