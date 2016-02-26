package com.array_string;

public class LongestSubstringWithAtMostTwoDistinctCharacters {
	
	public int lengthOflongestSubstringTwoDistinct(String s) {
		/* i: start, k: current. */
		int i = 0, j = -1, maxLen = 0;
		for (int k = 1; k < s.length(); k++) {
			if (s.charAt(k) == s.charAt(k - 1)) continue;
			/* 3 char appear. s[k] != s[k-1] */
			if (j >= 0 && s.charAt(j) != s.charAt(k)) {
				/* substring: [i](a || b), (a || b)*, [j](a), (b)*, [k](c) */
				maxLen = Math.max(maxLen, k - i);
				i = j + 1;
			}
			j = k - 1;
		}
		
		/* consider last substring */
		return Math.max(maxLen, s.length() - i);
	}
	
	public int lengthOfLongestSubstringTwoDistinct2(String s) {
		int[] count = new int[256];
		int i = 0, numDistinct = 0, maxLen = 0;
		for (int j = 0; j < s.length(); j++) {
			if (count[s.charAt(j)] == 0) numDistinct++;
			count[s.charAt(j)]++;
			while (numDistinct > 2) {
				count[s.charAt(i)]--;
				if (count[s.charAt(i)] == 0) numDistinct--;
				i++;
			}
			maxLen = Math.max(j - i + 1, maxLen);
		}
		return maxLen;
	}
}
