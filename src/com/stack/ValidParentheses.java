package com.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {

	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();
		for (char c : s.toCharArray()) {
			if (PAIR.containsKey(c)) {
				if (stack.isEmpty() || !PAIR.get(c).isPair(stack.pop())) {
					return false;
				}
			} else {
				stack.push(c);
			}
		}
		return stack.isEmpty();
	}
	
	private static final Map<Character, Pair> PAIR = 
			new HashMap<Character, Pair>() {
				private static final long serialVersionUID = 1L;
			{
				put(')', new Pair() {
					public boolean isPair(Character c) {
						return (c.equals('(')) ? true : false;
					}
				});
				put(']', new Pair() {
					public boolean isPair(Character s) {
						return (s.equals('[')) ? true : false;
					}
				});
				put('}', new Pair() {
					public boolean isPair(Character s) {
						return (s.equals('{')) ? true : false;
					}
				});
			}};
	
	interface Pair {
		boolean isPair(Character s);
	}
}
