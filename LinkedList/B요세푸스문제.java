package algorithm.LinkedList;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B요세푸스문제 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			queue.offer(i);
		}
		int[] result = new int[N];
		int idx = 0;
		while(!queue.isEmpty()) {
			for (int i = 1; i < K; i++) {
				queue.offer(queue.poll());
			}
			result[idx] = queue.poll();
			idx++;
		}
		System.out.print("<");
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i]);
			if(i==N-1) break;
			System.out.print(", ");
		}
		System.out.print(">");
		sc.close();
	}
}
