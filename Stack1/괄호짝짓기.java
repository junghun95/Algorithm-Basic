package algorithm.Stack1;

import java.util.Scanner;
import java.util.Stack;

public class 괄호짝짓기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;
		outer:
		for (int tc = 1; tc <= T; tc++) {
			sc.nextInt();
			char[] arr = sc.next().toCharArray();
			Stack<Character> stack = new Stack<>();
			for (int i = 0; i < arr.length; i++) {
				switch (arr[i]) {
				case '(': case '{': case '[': case '<':
					stack.push(arr[i]);
					break;
				case ')':
					if(stack.peek() == '(') {
						stack.pop();
					} else {
						System.out.println("#" + tc + " " + 0);
						continue outer;
					}
					break;
				case '}':
					if(stack.peek() == '{') {
						stack.pop();
					} else {
						System.out.println("#" + tc + " " + 0);
						continue outer;
					}
					break;
				case ']':
					if(stack.peek() == '[') {
						stack.pop();
					} else {
						System.out.println("#" + tc + " " + 0);
						continue outer;
					}
					break;
				case '>':
					if(stack.peek() == '<') {
						stack.pop();
					} else {
						System.out.println("#" + tc + " " + 0);
						continue outer;
					}
					break;
				}
			}
			System.out.println("#" + tc + " " + 1);
		}
		sc.close();
	}
}
