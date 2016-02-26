package com.array_string;

public class ReverseWords {

	public String reverseWords(String s) {
		StringBuilder reverse = new StringBuilder();
		int j = s.length();
		for (int i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(i) == ' ') {
				j = i;
			} else if (i == 0 || s.charAt(i - 1) == ' ') {
				if (reverse.length() != 0) {
					reverse.append(' ');
				}
				reverse.append(s.substring(i, j));
			}
		}
		return reverse.toString();
	}
	
	/**
	 * Given an input string, reverse the string word by word.
	 * For example,
	 * Given s = "the sky is blue",
	 * return "blue is sky the".
	 * 
	 * The input string does not contain leading or trailing spaces 
	 * and the words are always separated by a single space.
	 * 
	 * do it in-place without allocating extra space!!!
	 * 
	 * @param s
	 */
	public void reverseWords2(char[] s) {
		reverse(s, 0, s.length);
		for (int i = 0, j = 0; j <= s.length; j++) {
			if (j == s.length || s[j] == ' ') {
				reverse(s, i, j);
				i = j + 1;
			}
		}
	}
	
	private void reverse(char[] s, int begin, int end) {
		for (int i = 0; i < (end - begin); i++) {
			char temp = s[begin + i];
			s[begin + i] = s[end - i - 1];
			s[end - i - 1] = temp;
		}
	}
	
	/**
	 * Rotate an array to the right by k steps in-place without allocating extra space.
	 * For instance,
	 * Given s [0, 1, 2, 3, 4, 5, 6] and k = 3,
	 * return [4, 5, 6, 0, 1, 2, 3]
	 * @param s
	 * @param k
	 */
	public void rateteKSteps(char[] s, int k) {
		/* s = AB, return s = BA = B''A'' = (A'B')' */
		if (s == null || s.length <= k) {
			return;
		}
		reverse(s, 0, k + 1);
		reverse(s, k + 1, s.length);
		reverse(s, 0, s.length);
	}
}
