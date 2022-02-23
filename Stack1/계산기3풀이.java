package algorithm.Stack1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class 계산기3풀이 {
	static Map<Character, Integer> priority = new HashMap<>();
	static {
		priority.put('(', 0);
		priority.put('+', 1);
		priority.put('-', 1);
		priority.put('*', 2);
		priority.put('/', 2);		
	}
	private static String makePost(String inData) {
		StringBuffer post = new StringBuffer();		// 후위표현식을 담을 곳
		Stack<Character> op = new Stack<>();
		
		for (int i = 0; i < inData.length(); i++) {
			char c = inData.charAt(i);
			if(c == '(') {		// 연산자가 모여있는 스택에 무조건 집어넣는다.
				op.push(c);
				continue;
			}
			if(c == ')') {		// 여는괄호가 나올때 까지 모두 꺼낸다. 단, 여는괄호는 버린다.
				while(op.peek() != '(') {
					post.append(op.pop());
				}
				// 여는괄호일 경우 -> 버린다
				op.pop();
				continue;
			}
			if(c >= '0' && c <= '9') {	// 숫자인 경우에는 후위표현식에 추가한다.
				post.append(c);
				continue;
			}
			// 연산자일 경우
			if(op.empty()) {	// 스택이 비어있는 경우 -> 그냥 넣어줌
				op.push(c);
				continue;
			}
			// 연산자 우선순위를 체크해서 처리
			while(!op.empty() && priority.get(c) <= priority.get(op.peek())) {
				post.append(op.pop());
			}
			op.push(c);
		}
		// 스택에 남아있는 연산자를 꺼내서 후위표현식에 추가한다.
		while(!op.isEmpty()) post.append(op.pop());
		
		return post.toString();
	}
	
	private static int calc(String post) {
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < post.length(); i++) {
			char c = post.charAt(i);
			if(c >= '0' && c <= '9') {
				stack.push(c - '0');
				continue;
			}
			// 연산자일 경우
			int num2 = stack.pop();
			int num1 = stack.pop();
			int result = 0;
			switch(c) {
			case '+': result = num1 + num2; break;
			case '-': result = num1 - num2; break;
			case '*': result = num1 * num2; break;
			case '/': result = num1 / num2; break;
			}
			stack.push(result);
		}
		return stack.pop();
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int t = 1; t <= 10; t++) {
			sc.nextInt(); 	// 버림
			System.out.println("#" + t + " " + calc(makePost(sc.next())));
		}
		sc.close();
	}
}
