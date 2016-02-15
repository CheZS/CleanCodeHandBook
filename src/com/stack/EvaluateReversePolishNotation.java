package com.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class EvaluateReversePolishNotation {

	public int evalRPN(String[] tokens) {
		Stack<Integer> stack = new Stack<Integer>();
		for (String token : tokens) {
			if (!OPERATORS.containsKey(token)) {
				stack.push(Integer.parseInt(token));
				continue;
			}
			int y = stack.pop();
			int x = stack.pop();
			stack.push(OPERATORS.get(token).eval(x, y));
		}
		return stack.isEmpty() ? 0 : stack.pop();
	}
	private static final Map<String, Operator> OPERATORS = 
			new HashMap<String, Operator>() {
				private static final long serialVersionUID = 1L;
			{
				put("+", new Operator() {
					public int eval(int x, int y) {
						return x + y;
					}
				});
				put("-", new Operator() {
					public int eval(int x, int y) {
						return x - y;
					}
				});
				put("*", new Operator() {
					public int eval(int x, int y) {
						return x * y;
					}
				});
				put("/", new Operator() {
					public int eval(int x, int y) {
						return x / y;
					}
				});
			}};

	interface Operator {
		int eval(int x, int y);
	}
}
