package com.array_string;

public class OneEditDistance {

	public static void main(String[] args) {
		String s = "abcd";
		String t = "abxde";
		OneEditDistance o = new OneEditDistance();
		System.out.println(o.isOneEditDistance(s, t));
	}
	
	public boolean isOneEditDistance(String s, String t) {
		if (s.length() > t.length()) return isOneEditDistance(t, s);
		if (t.length() - s.length() > 1) return false;
		if (s.length() == t.length()) {
			/* is substitute some character */
			int i = 0;
			while (i < s.length() && s.charAt(i) == t.charAt(i)) i++;
			if (i < s.length()) i++;
			while (i < s.length() && s.charAt(i) == t.charAt(i)) i++;
			return i == s.length();
		}
		/* is insert operation */
		int i = 0;
		while (i < s.length() && s.charAt(i) == t.charAt(i)) i++;
		while (i < s.length() && s.charAt(i) == t.charAt(i + 1)) i++;
		return i == s.length();
	}
	
	public boolean isOneEditDistance2(String s, String t) {
		if (s.length() > t.length()) return isOneEditDistance2(t, s);
		if (t.length() - s.length() > 1) return false;
		int i = 0, shift = t.length() - s.length();
		while (i < s.length() && s.charAt(i) == t.charAt(i)) i++;
		if (i == s.length()) return shift > 0;
		if (shift == 0) i++;
		while (i < s.length() && s.charAt(i) == t.charAt(i + shift)) i++;
		return i == s.length();
	}
}
