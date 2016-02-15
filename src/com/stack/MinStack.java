package com.stack;

import java.util.Stack;

public class MinStack {

	public void push(int x) {
		stack.push(x);
		if (minStack.isEmpty() || x <= minStack.peek()) {
			minStack.push(x);
		}
	}
	
	public int pop() {
		int p = stack.pop();
		if (minStack.peek().equals(p)) minStack.pop();
		return p;
	}
	
	public int top() {
		return stack.peek();
	}
	
	public int getMin() {
		return minStack.peek();
	}
	
	private Stack<Integer> stack = new Stack<>();
	private Stack<Integer> minStack = new Stack<>();
}
