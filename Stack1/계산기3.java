package algorithm.Stack1;

import java.util.Scanner;
import java.util.Stack;

public class 계산기3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;
		for (int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt();
			char[] input = sc.next().toCharArray();
			char[] output = new char[n];
			Stack<Character> stack = new Stack<>();
			Stack<Integer> stackout = new Stack<>();
			int cur = -1;

			// step 1
			for (int i = 0; i < input.length; i++) {
				switch (input[i]) {
				case ')':
					while (stack.peek() != '(') {
						output[++cur] = stack.pop();
						if (stack.isEmpty())
							break;
					}
					if (!stack.isEmpty()) {
						stack.pop();
					}
					break;
				case '(':
					stack.push(input[i]);
					break;
				case '*':
					while (stack.peek() == '*') {
						output[++cur] = stack.pop();
					}
					stack.push(input[i]);
					break;
				case '+':
					while (stack.peek() != '(') {
						output[++cur] = stack.pop();
						if (stack.isEmpty())
							break;
					}
					stack.push(input[i]);
					break;
				default:
					output[++cur] = input[i];
					break;
				}
			}

			// step 2
			for (int i = 0; i < output.length; i++) {
				if (output[i] != '\u0000') {
					switch (output[i]) {
					case '+':
						stackout.push(stackout.pop() + stackout.pop());
						break;
					case '*':
						stackout.push(stackout.pop() * stackout.pop());
						break;

					default:
						stackout.push(output[i] - '0');
						break;
					}
				} else {
					System.out.println("#" + tc + " " + stackout.pop());
					break;
				}
			}
		}
		sc.close();
	}
}
