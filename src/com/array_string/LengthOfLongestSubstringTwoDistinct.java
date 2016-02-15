package com.array_string;

public class LengthOfLongestSubstringTwoDistinct {

	
	public static void main(String[] args) {
		String s = "abaac";
//		String s2 = "eceba";
//		String s3 = "caaba";
		LengthOfLongestSubstringTwoDistinct l = new LengthOfLongestSubstringTwoDistinct();
		System.out.println(l.lengthOfLongestSubstringTwoDistinct(s));
		System.out.println(l.lengthOfLongestSubstringTwoDistinct2(s));
	}
	
	public int lengthOfLongestSubstringTwoDistinct(String s) {
		/* 3 pointers: i, j, k */
		/* i: start point */
		/* j: last repeat character point - 1 */
		/* k: last point */
		int i = 0, j = -1, maxLen = 0;
		for (int k = 1; k < s.length(); k++) {
			if (s.charAt(k) == s.charAt(k-1)) {
				continue;
			}
			if (j >= 0 && s.charAt(k) != s.charAt(j)) {
				/* s.charAt(k) != s.charAt(k-1) */
				/* a new character comes */
				maxLen = Math.max(maxLen, k - i);
				i = j + 1;
			}
			j = k - 1;
		}
		
		/* consider the string like "abbbbbbbbb" */
		return Math.max(maxLen, s.length() - i);
	}
	
	public int lengthOfLongestSubstringTwoDistinct2(String s) {
		int[] c = new int[256];
		int i = 0, maxLen = 0, distinct = 0;
		for (int k = 0; k < s.length() - 1; k++) {
			if (s.charAt(k) == s.charAt(k + 1)) {
				continue;
			}
			if (c[s.charAt(k)] == 0) {
				distinct++;
			}
			c[s.charAt(k)] = k;
			if (distinct > 2) {
				maxLen = Math.max(maxLen, k - i + 1);
				i = c[s.charAt(i)];
				c[s.charAt(i)] = 0;
				i++;
				distinct--;
			}
		}
		return Math.max(maxLen, s.length() - i);
	}
	
	public int lengthOfLongestSubstringTwoDistinct3(String s) {
		int[] count = new int[256];
		int i = 0, distinct = 0, maxLen = 0;
		for (int j = 0; j < s.length(); j++) {
			if (count[s.charAt(j)] == 0) {
				distinct++;
			}
			count[s.charAt(j)]++;
			while (distinct > 2) {
				count[s.charAt(i)]--;
				if (count[s.charAt(i)] == 0) {
					distinct--;
				}
				i++;
			}
			maxLen = Math.max(j -i + 1, maxLen);
		}
		return maxLen;
	}
}
