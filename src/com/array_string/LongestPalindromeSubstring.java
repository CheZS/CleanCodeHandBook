package com.array_string;

public class LongestPalindromeSubstring {

	
	public String longestPalindrome(String s) {
		int start = 0, end = 0;
		for (int center = 0; center < s.length(); center++) {
			int len1 = expandAroundCenter(s, center, center);
			int len2 = expandAroundCenter(s, center, center + 1);
			int len = Math.max(len1, len2);
			if (len > end - start) {
				start = center - (len - 1) / 2;
				end = center + len / 2;
			}
		}
		return s.substring(start, end + 1);
	}
	
	private int expandAroundCenter(String s, int left, int right) {
		int l = left, r = right;
		while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
			l--;
			r++;
		}
		return r - l - 1;
	}
	
	public String longestPalindrome2(String s) {
		int n = s.length();
	    int longestLen = 0;
	    int longestIndex = 0;

	    for(int currentIndex = 0; currentIndex < n; currentIndex++) {
	        boolean isP1 = isPalindrome(s,currentIndex - longestLen, currentIndex);
	        boolean isP2 = isPalindrome(s, currentIndex - longestLen - 1, currentIndex);
	    	if(isP1){
	            longestLen += 1;
	            longestIndex = currentIndex;
	        } else if(currentIndex - longestLen - 1 >= 0 && isP2) {
	            longestLen += 2;
	            longestIndex = currentIndex;
	        }   
	    }
	    longestIndex++;
	    return s.substring(longestIndex - longestLen, longestIndex);
    }
	
	private boolean isPalindrome(String s, int startIndex, int endIndex) {
	    int i = startIndex, j = endIndex;
	    if (i < 0 || j >= s.length()) return false;
	    while (i <= j && s.charAt(i) == s.charAt(j)) {
	    	i++;
	    	j--;
	    }
		return (i > j);
	}
}
