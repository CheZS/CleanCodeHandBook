package com.binarySearch;

public class FindMinimumInRotatedSortedArray {

	public static void main(String[] args) {
//		int[] n1 = new int[]{4, 5, 6, 7, 0, 1, 2};
		int[] n2 = new int[]{5, 6, 7, 0, 1, 2, 4};
//		int[] n3 = new int[]{5, 6, 7, 0, 1, 2};
		FindMinimumInRotatedSortedArray f = new FindMinimumInRotatedSortedArray();
		System.out.println(f.findMin(n2));
	}
	public int findMin(int[] nums) {
		int L = 0, R = nums.length - 1;
		while (L < R && nums[L] >= nums[R]) {
			int M = (L + R) / 2;
			if (nums[M] > nums[R]) {
				L = M + 1;
			} else {
				R = M;
			}
		}
		return nums[L];
	}
}
