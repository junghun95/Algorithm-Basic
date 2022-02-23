package algorithm.Stack1;

import java.util.Scanner;
import java.util.Stack;

public class 정곤이의단조증가하는수 {
	static int result;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[] num = new int[N];
			for (int i = 0; i < num.length; i++) {
				num[i] = sc.nextInt();
			}
			result = -1;
			for (int i = 0; i < num.length-1; i++) {
				for (int j = i+1; j < num.length; j++) {
					if(result<num[i]*num[j]) {
						check(num[i]*num[j]);						
					}
				}
			}
			System.out.println("#" + tc + " " + result);
		}
		sc.close();
	}
	
	static void check(int i) {
		Stack<Integer> stack = new Stack<>();
		int can = i;
		while(true) {
			stack.add(i%10);
			if(i-i%10 == 0) break;
			i /= 10;
		}
		int temp = 0;
		int size = stack.size();
		for (int j = 0; j < size; j++) {
			if(temp<=stack.peek()) {
				temp = stack.pop();
			} else {
				return;
			}
		}
		result = Math.max(result, can);
	}
}
