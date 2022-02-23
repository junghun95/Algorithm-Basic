package algorithm.Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 암호생성기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;
		for (int tc = 1; tc <= T; tc++) {
			sc.nextInt();
			Queue<Integer> queue = new LinkedList<>();
			
			for (int i = 0; i < 8; i++) {
				queue.offer(sc.nextInt());
			}
			outer:
			while(true) {
				for (int i = 1; i <= 5; i++) {
					int temp = queue.poll() - i;
					if(temp <= 0) {
						queue.offer(0);
						break outer;
					}
					queue.offer(temp);
				}
			}
			System.out.print("#" + tc + " ");
			for (int i = 0; i < 8; i++) {
				System.out.print(queue.poll() + " ");
			}
			System.out.println();
		}
		sc.close();
		
	}
}
