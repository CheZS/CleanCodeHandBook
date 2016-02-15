package com.dynamicProgramming;

public class MaximumSubarray {

	public int maxSubArray(int[] nums) {
		return DP(nums, 0, nums.length - 1);
	}
	
	private int DP(int[] nums, int start, int end) {
		if (start > end) return Integer.MIN_VALUE;
		int mid = (start + end) / 2;
		int leftAns = DP(nums, start, mid - 1);
		int rightAns = DP(nums, mid + 1, end);
		int lMaxSum = 0;
		int sum = 0;
		for (int i = mid - 1; i >= start; i--) {
			sum += nums[i];
			lMaxSum = Math.max(lMaxSum, sum);
		}
		int rMaxSum = 0;
		sum = 0;
		for (int i = mid + 1; i <= end; i++) {
			sum += nums[i];
			rMaxSum = Math.max(rMaxSum, sum);
		}
		return Math.max(lMaxSum + nums[mid] + rMaxSum, Math.max(leftAns, rightAns));
	}
	
	public int maxSubArray2(int[] nums) {
		int maxEndingHere = nums[0], maxSoFar = nums[0];
		for (int i = 1; i < nums.length; i++) {
			maxEndingHere = Math.max(maxEndingHere + nums[i], nums[i]);
			maxSoFar = Math.max(maxSoFar, maxEndingHere);
		}
		return maxSoFar;
	}
}
