package com.misc;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

	public static void main(String[] args) {
//		int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		int[][] m = new int[][]{{2}, {3}};
		SpiralMatrix s = new SpiralMatrix();
		System.out.println(s.spiralOrder(m));
	}
	public List<Integer> spiralOrder(int[][] matrix) {
		if (matrix == null || matrix.length == 0) return new ArrayList<Integer>();
		return spiralOrder(matrix, 0, matrix.length - 1, 0, matrix[0].length - 1);
	}
	private List<Integer> spiralOrder(int[][] matrix, int rStart, 
			int rEnd, int cStart, int cEnd) {
		if (rStart > rEnd || cStart > cEnd) return null;
		List<Integer> res = new ArrayList<Integer>();
		int column = cStart, row = rStart;
		while (column <= cEnd) {
			res.add(matrix[row][column]);
			column++;
		}
		column = cEnd;
		row = rStart + 1;
		while (row <= rEnd) {
			res.add(matrix[row][column]);
			row++;
		}
		row = rEnd;
		column = cEnd - 1;
		while (row != rStart && column >= cStart) {
			res.add(matrix[row][column]);
			column--;
		}
		row = rEnd - 1;
		column = cStart;
		while (column != cEnd && row > rStart) {
			res.add(matrix[row][column]);
			row--;
		}
		List<Integer> sub = spiralOrder(matrix, rStart+1, rEnd-1, cStart+1, cEnd-1);
		if (sub != null) res.addAll(sub);
		
		return res;
	}
}
