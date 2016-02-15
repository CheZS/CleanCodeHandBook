package com.binarySearch;

public class SearchInsertPosition {

	public static void main(String[] args) {
		int[] n = new int[]{1, 3, 5, 6};
		int t1 = 5;
		int t2 = 2;
		int t3 = 7;
		int t4 = 0;
		int t5 = 4;
		int t6 = 6;
		SearchInsertPosition s = new SearchInsertPosition();
		System.out.println(s.searchInsert(n, t1));
		System.out.println(s.searchInsert(n, t2));
		System.out.println(s.searchInsert(n, t3));
		System.out.println(s.searchInsert(n, t4));
		System.out.println(s.searchInsert(n, t5));
		System.out.println(s.searchInsert(n, t6));
	}
	public int searchInsert(int[] nums, int target) {
		return BS(nums, target, 0, nums.length);
	}
	private int BS(int[] nums, int target, int l, int r) {
		if (l == r) return l;
		if (l + 1 == r) {
			return (nums[l] < target) ? r : l;
		}
		int mid = (l + r) / 2;
		if (target < nums[mid]) return BS(nums, target, l, mid);
		if (target > nums[mid]) return BS(nums, target, mid, r);
		while (target == nums[mid]) mid--;
		return ++mid;
	}
	
	public int searchInsert2(int[] nums, int target) {
		int L = 0, R = nums.length - 1;
		while (L < R) {
			int M = (L + R) / 2;
			if (nums[M] < target) {
				L = M + 1;
			} else {
				R = M;
			}
		}
		return (nums[L] < target) ? L + 1 : L;
	}
}
