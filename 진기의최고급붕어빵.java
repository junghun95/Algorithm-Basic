package algorithm;

import java.util.Scanner;

public class 진기의최고급붕어빵 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		outer:
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int K = sc.nextInt();
			int[] order = new int[N];
			int last = 0;
			// 입력받고 최댓값 저장하기
			for (int i = 0; i < N; i++) {
				order[i] = sc.nextInt();
				last = Math.max(order[i], last);
			}
			int[] cnt = new int[last / M + 1];
			for (int i = 0; i < order.length; i++) {
				cnt[order[i] / M]++;
			}
			for (int i = 0; i < cnt.length - 1; i++) {
				cnt[i + 1] += cnt[i];
			}

			for (int i = 0; i < cnt.length; i++) {
				if (K * i < cnt[i]) {
					System.out.println("#" + tc + " Impossible");
					continue outer;
				}
			}
			System.out.println("#" + tc + " Possible");
		}
		sc.close();
	}
}
