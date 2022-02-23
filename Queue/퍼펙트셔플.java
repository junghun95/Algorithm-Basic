package algorithm.Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author hun95
 *
 */
public class 퍼펙트셔플 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 1; i <= T; i++) {
			int N = sc.nextInt();
			Queue<String> deck1 = new LinkedList<>();
			Queue<String> deck2 = new LinkedList<>();

			for (int j = 0; j < N/2 + N%2; j++) {
				deck1.add(sc.next());
			}
			for (int j = 0; j < N/2; j++) {
				deck2.add(sc.next());
			}
			String[] result = new String[N];
			for (int j = 0; j < result.length; j++) {
				if(j % 2 == 0) {
					result[j] = deck1.poll();					
				} else {
					result[j] = deck2.poll();
				}
			}
			System.out.print("#" + i + " ");
			for (int j = 0; j < result.length; j++) {
				System.out.print(result[j] + " ");
			}
			System.out.println();
		}
		sc.close();
	}
}
