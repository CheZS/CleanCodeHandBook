package com.dynamicProgramming;

public class CoinsInALine {

	public int maxMoney(int[] A) {
		int len = A.length;
		int[][] P = new int[len][len];
		int a, b, c;
		for (int i = 0; i < len; i++) {
			for (int m = 0, n = i; m < len && n < len; m++, n++) {
				a = (m + 2 < len) ? P[m+2][n] : 0;
				b = (m + 1 < len && n - 1 >= 0) ? P[m+1][n-1] : 0;
				c = (n - 2 >= 0) ? P[m][n - 2] : 0;
				P[m][n] = Math.max(A[m] + Math.min(a, b), 
						A[n] + Math.min(b, c));
			}
		}
		return P[0][len - 1];
	}
	
	public static void main(String[] args) {
		CoinsInALine c = new CoinsInALine();
		int[] A = new int[]{3, 2, 2, 3, 1, 2};
		System.out.println(c.maxMoney(A));
	}
}
