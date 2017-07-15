package com.vixir.beprepared.stack;

import java.util.Stack;

public class BalancedParanthesis {
	public static void main(String[] args) {
		char exp[] = { '{', '(', ')', '}', '[', ']' };
		if (areParenthesisBalanced(exp))
			System.out.println("Balanced ");
		else
			System.out.println("Not Balanced ");
	}

	private static boolean areParenthesisBalanced(char[] exp) {
		int n = exp.length;
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < n; i++) {
			char c = exp[i];
			if (c == '{' || c == '[' || c == '(') {
				stack.push(c);
			}
			if (c == '}' || c == ']' || c == ')') {
				if (stack.isEmpty()) {
					return false;
				} else if (!isMatchingPair(stack.pop(), c)) {
					return false;
				}
			}
		}
		if (stack.isEmpty()) {
			return true;
		}
		return false;
	}

	private static boolean isMatchingPair(char pop, char c) {
		if (pop == '(') {
			if (c == ')') {
				return true;
			}
		} else if (pop == '{') {
			if (c == '}') {
				return true;
			}
		} else if (pop == '[') {
			if (c == ']') {
				return true;
			}
		}
		return false;
	}
}
