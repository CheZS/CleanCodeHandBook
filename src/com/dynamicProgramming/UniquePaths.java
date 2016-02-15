package com.dynamicProgramming;

public class UniquePaths {

	public int uniquePaths(int m, int n) {
		paths = new int[m][n];
		return DP(m - 1, n - 1);
	}
	private int DP(int r, int c) {
		if (r == 0 && c == 0) return 1;
		if (r == 0 && c == 1) return 1;
		if (r == 1 && c == 0) return 1;
		if (paths[r][c] > 0) return paths[r][c];
		int left = (c > 0) ? DP(r, c - 1) : 0;
		int up = (r > 0) ? DP(r - 1, c) : 0;
		paths[r][c] = left + up;
		return paths[r][c];
	}
	private int[][] paths;
}
