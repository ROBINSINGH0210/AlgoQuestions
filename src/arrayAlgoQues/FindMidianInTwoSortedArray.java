package arrayAlgoQues;

public class FindMidianInTwoSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []nums1 = {1,3};
		int [] nums2 = {2};
		System.out.println(findMedianSortedArrays(nums1, nums2));
	}

	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		if (nums1.length > nums2.length) {
			return findMedianSortedArrays(nums2, nums1);
		}
		int x = nums1.length;
		int y = nums2.length;
		int low = 0;
		int high = x;
		while (low <= high) {
			int partx = (low + high) / 2;
			int party = ((x + y + 1) / 2) - partx;
			int maxX = (partx == 0) ? Integer.MIN_VALUE : nums1[partx - 1];
			int minX = (partx == x) ? Integer.MAX_VALUE : nums1[partx];

			int maxY = (party == 0) ? Integer.MIN_VALUE : nums2[party - 1];
			int minY = (party == y) ? Integer.MAX_VALUE : nums2[party];

			if (maxX <= minY && maxY <= minX) {
				if ((x + y) % 2 == 0)
					return (double) (Math.max(maxX, maxY) + Math.min(minY, minX)) / 2;
				else
					return (double) Math.max(maxY, maxX);
			} else if (maxX > minY) {
				high = partx-1;
			} else
				low = partx+1;

		}
		return 0;
	}
}
