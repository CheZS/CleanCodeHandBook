package com.array_string;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges {

	public List<String> findMissingRanges(int[] vals, int start, int end) {
		List<String> res = new ArrayList<String>();
		int prev = start - 1;
		for (int i = 0; i <= vals.length; i++) {
			int curr = (i == vals.length) ? end + 1 : vals[i];
			if (curr - prev >= 2) {
				res.add(getRange(prev + 1, curr - 1));
			}
			prev = curr;
		}
		
		return res;
	}
	
	private String getRange(int from, int to) {
		return (from == to) ? String.valueOf(from) : from + "->" + to;
	}
}
