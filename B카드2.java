package algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B카드2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			if(i % 2 == 0) queue.offer(i);
		}
		while(queue.size() != 1) {
			queue.poll();	// 하나 버림
			queue.add(queue.poll());	// 하나 꺼내서 맨뒤로 넣어준다
		}
		System.out.println(queue.peek());
	}
}
