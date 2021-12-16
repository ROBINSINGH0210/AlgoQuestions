package arrayAlgoQues;

public class FirstMissingPositiveNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = { 1,1};
		System.out.println(firstMissingPositive(nums));
	}

	public static int firstMissingPositive(int[] nums) {
		boolean isOnePresent = false; // take a variable to detect if 1 is present in the nums or not
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 1) {
				isOnePresent = true; // mark it true in case if 1 is present
			}
			if (nums[i] < 1 || nums[i] > nums.length) {
				nums[i] = 1; // mark all the elements that are out of range as 1
			}
		}
		// we are marking the element as 1 because in our further logic we will be
		// setting a mark[negative number] to the index number whose number is present
		// in the nums
		// in this way we can easily find out the missing number , if the value at index
		// i is positive then we will say that that index number +1 is the missing
		// number
		if (isOnePresent == false) {
			return 1; // if 1 is not present then ofcourse 1 is the first missing positive
		} else {
			for (int i = 0; i < nums.length; i++) {
				nums[Math.abs(nums[i]) - 1] = -Math.abs(nums[Math.abs(nums[i]) - 1]);
				// now all the numbers are in the range - [1,nums.length]
				// nums[i] is a number then we will go to index nums[i] and mark its value as
				// negative
				// the negative value in the num represents that the index value of it +1 is
				// present in the nums array.
			}
		}
		
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] >= 1) {
				return i + 1; // traverse the array and find if any value is positive
								// is positive value found that means the index number +1 of it is not present
								// in the nums array and it is the smallest posotive missing number
			}
		}
		return nums.length + 1;
	}// if all numbers are negative that means all the numbers between 0-nums.length
		// are present in that case nums.length+1 is the first missing positive number.}
}
