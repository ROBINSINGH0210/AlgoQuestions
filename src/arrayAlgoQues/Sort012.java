package arrayAlgoQues;

public class Sort012 {

	public static void main(String[] args) {
		int a[] = { 1, 2, 1, 0, 0, 1, 2, 0, 0, 0, 2 };
		for (int i : a) {
			System.out.print(i);
		}
		System.out.println("Sorted-->");
		for (int i : sort(a)) {
			System.out.print(i);
		}

	}

	static int[] sort(int a[]) {
		int low = 0, mid = 0, hig = a.length - 1, temp = 0;
		while (mid <= hig) {
			if (a[mid] == 0) {
				temp = a[low];
				a[low] = a[mid];
				a[mid] = temp;
				low++;
				mid++;
			} else if (a[mid] == 1) {
				mid++;
			} else {
				temp = a[mid];
				a[mid] = a[hig];
				a[hig] = temp;
				hig--;
			}
		}
		return a;

	}
}
